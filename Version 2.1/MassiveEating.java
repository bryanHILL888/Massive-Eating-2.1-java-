import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.ComponentOrientation;
import java.text.DecimalFormat;
import java.text.NumberFormat; 
import java.awt.Component.*; 
import java.lang.Object;
import java.util.Locale;

public class MassiveEating extends JFrame
{
   NorthPanel massiveNorth; 
   SouthPanel massiveSouth;
   Calculations massiveCalc;
   private JMenuBar menuBar;
	private JMenu fileMenu;    
	private JMenu helpMenu; 
	private JMenuItem exitItem;
	private JMenuItem aboutItem;
   private final int WINDOW_WIDTH = 382; // window width
   private final int WINDOW_HEIGHT = 650; // window height
   
   double bWeightLbsInput;
   double bWeightKgOutput;
   double bodyFatPrcntInput;
   double ffmOutput;
   double rmrOutput;
   
   double activityFactorInput;
   double rmrActivityOutput;
   double exWeightsInput;
   double rmrWeightsOutput;
   double exCardioInput;
   double rmrCardioOutput = 0;
   double thermicOutput;
   double targetBodyFatInput;
   double adjustedMR;
   double targetFatFreeMassDecimal;
   double targetTotalMassKg = 0;
   double targetTotalMassLbs;
   double targetCalorieBurn;
   
	DecimalFormat df = new DecimalFormat("#,##0.0");
   
   /**
	   Constructor
	*/
   
   public MassiveEating()
   {
      // set title
	   setTitle("Massive Eating");
      
      // set the size of the window
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		// set close action
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// set resizability
		setResizable(false);
		
		
		// create BorderLayout manager
		setLayout(new BorderLayout());
		
		// set look and feel
		try
		{
		   UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			SwingUtilities.updateComponentTreeUI(this);
		}
		catch (Exception e)
		{
		   JOptionPane.showMessageDialog(massiveNorth, "Error setting the look and feel.", "Alert", JOptionPane.ERROR_MESSAGE);
			
			System.exit(0);
		}
      
      // create north panel
      massiveNorth = new NorthPanel();
      
      // create south panel
      massiveSouth = new SouthPanel();
      
      // create calculations class
      massiveCalc = new Calculations();
      
      // register button listeners
      massiveNorth.cCondition.PoundsPanel.bWeightLbsButton.addActionListener(new ButtonListener());
      massiveNorth.cCondition.BodyFatPanel.bFatPercentBtn.addActionListener(new ButtonListener());
      massiveSouth.weightGoal.wlPanel.meansPanel.targetBFbtn.addActionListener(new ButtonListener());
      massiveSouth.weightGoal.wgPanel.activityPanel.activityNorth.afPanel.activityFactorBtn.addActionListener(new ButtonListener());
      massiveSouth.weightGoal.wgPanel.activityPanel.activityNorth.weightsPanel.exWeightsBtn.addActionListener(new ButtonListener());
      massiveSouth.weightGoal.wgPanel.activityPanel.activitySouth.cardioPanel.exCardioBtn.addActionListener(new ButtonListener());
      massiveSouth.weightGoal.wgPanel.thermicPanel.tsPanel.tefRowThree.calcTMRbtn.addActionListener(new ButtonListener());
      massiveSouth.weightGoal.wgPanel.activityPanel.activityNorth.afPanel.questButton.addActionListener(new ButtonListener());
      massiveSouth.weightGoal.wgPanel.thermicPanel.tnPanel.tefRowOne.questButton2.addActionListener(new ButtonListener());
      massiveSouth.weightGoal.wlPanel.meansPanel.questButton3.addActionListener(new ButtonListener());
      massiveSouth.clrPanel.clearButton.addActionListener(new ButtonListener());
      
      // add panels
      add(massiveNorth, BorderLayout.NORTH);
      add(massiveSouth, BorderLayout.SOUTH);
      
      buildMenuBar();
		
		pack();
		setVisible(true);
      
		// set location
		setLocationRelativeTo(null);
   }
   
   	private void buildMenuBar()
	{
	   // create menu bar
		menuBar = new JMenuBar();
		
		buildFileMenu();
		buildHelpMenu(); 
		
		menuBar.add(fileMenu);
		menuBar.add(helpMenu);
		
		setJMenuBar(menuBar); 
	}
	
	private void buildFileMenu()
	{
	   // create exit menu item
		exitItem = new JMenuItem("Exit");
		exitItem.setMnemonic(KeyEvent.VK_X);
		exitItem.addActionListener(new ExitListener());
		
		fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		
		fileMenu.add(exitItem);
	}
	
	private class ExitListener implements ActionListener
	{
	   public void actionPerformed(ActionEvent e)
		{
		   System.exit(0);
		}
	}
	
	private void buildHelpMenu()
	{
	   // create exit menu item
		aboutItem = new JMenuItem("About");
		aboutItem.setMnemonic(KeyEvent.VK_A);
		aboutItem.addActionListener(new AboutListener());
		
		helpMenu = new JMenu("Help");
		helpMenu.setMnemonic(KeyEvent.VK_H);
		
		helpMenu.add(aboutItem);
	}
	
	private class AboutListener implements ActionListener
	{
	   public void actionPerformed(ActionEvent e)
		{
		   JOptionPane.showMessageDialog(massiveNorth, "This app was written to help you reach your bodyweight goals." +
              "\nThe theory behind the weight gain portion is based on" + 
              "\nJohn M. Berardi's Massive Eating article at www.t-nation.com" +
              "\nThe weight loss portion is based on my own personal experience." + 
              "\n                                    \u00A9 2014 Bryan Hill", "About Massive Eating", JOptionPane.INFORMATION_MESSAGE);
		}
	}
   
   private class ButtonListener implements ActionListener
	{
	   public void actionPerformed(ActionEvent e)
		{
         if (e.getSource() == massiveNorth.cCondition.PoundsPanel.bWeightLbsButton)
			{		
			   getBodyWeight();   				
			}
         else if (e.getSource() == massiveNorth.cCondition.BodyFatPanel.bFatPercentBtn)
         {
            checkBodyFat();  
         }
         else if (e.getSource() == massiveSouth.weightGoal.wgPanel.activityPanel.activityNorth.afPanel.activityFactorBtn)
         {
            checkActivityFactor();
         }
         else if (e.getSource() == massiveSouth.weightGoal.wgPanel.activityPanel.activityNorth.weightsPanel.exWeightsBtn)
         {
            checkWeights();
         }
         else if (e.getSource() == massiveSouth.weightGoal.wgPanel.activityPanel.activitySouth.cardioPanel.exCardioBtn)
         {
            checkCardio();
         }
         else if (e.getSource() == massiveSouth.weightGoal.wgPanel.thermicPanel.tsPanel.tefRowThree.calcTMRbtn)
         {
            checkTEF();
         }
         else if (e.getSource() == massiveSouth.weightGoal.wgPanel.activityPanel.activityNorth.afPanel.questButton)
         {
            answerActivityQuest();
         }
         else if (e.getSource() == massiveSouth.weightGoal.wgPanel.thermicPanel.tnPanel.tefRowOne.questButton2)
         {
            explainTEF();
         }
         else if (e.getSource() == massiveSouth.weightGoal.wlPanel.meansPanel.questButton3)
         {
            explainTBF();
         }
         else if (e.getSource() == massiveSouth.weightGoal.wlPanel.meansPanel.targetBFbtn)
         {
            checkBoxes();
         }
         else if (e.getSource() == massiveSouth.clrPanel.clearButton)
         {
            clearAllText();
         }
      }
   }
   
   // string to hold input
   String input;
   
   // method to calculate bodyweight
   public double getBodyWeight()
   {
      // get input from user
      input = massiveNorth.cCondition.PoundsPanel.bWeightLbsQuan.getText();
      
      // check for null/empty text box
      if(input != null && !input.isEmpty())
      {
         // try/catch for exceptions
         try
         {  
            // convert input to double    
            bWeightLbsInput = Double.parseDouble(input);
            
            // convert lbs to kgs
            bWeightKgOutput = massiveCalc.calcKilos(bWeightLbsInput);
            
            // display bodyweight in kgs to user
            massiveNorth.cCondition.KiloPanel.bWeightKgsQuan.setText(df.format(bWeightKgOutput));
         }
         catch (Exception e)
         {
            JOptionPane.showMessageDialog(massiveNorth.cCondition.PoundsPanel, e.getMessage() + "\nPlease enter a proper value.", 
            "Alert", JOptionPane.ERROR_MESSAGE);
         }
      }
      else
      {
         JOptionPane.showMessageDialog(massiveNorth.cCondition.PoundsPanel, "Missing information. \nPlease enter a value.", 
         "Alert", JOptionPane.ERROR_MESSAGE);
      }
      
      return bWeightKgOutput;
   } 
   
   public void checkBodyFat()
    {
      if (massiveNorth.cCondition.KiloPanel.bWeightKgsQuan.getText().trim().isEmpty())
      {
         JOptionPane.showMessageDialog(massiveNorth.cCondition.BodyFatPanel, "Missing information. \nPlease enter a value.", 
         "Alert", JOptionPane.ERROR_MESSAGE);
      }
      else
      {
         getBodyFat();
         getRMR();
      }   
   }
   
   // method to calculate body fat
   public double getBodyFat()
   {
      // get input from user
      input = massiveNorth.cCondition.BodyFatPanel.bFatPercentQuan.getText();
      
      // check for null/empty text box
      if(input != null && !input.isEmpty())
      {
         // try/catch for exceptions
         try
         {
            // convert input to double
            bodyFatPrcntInput = Double.parseDouble(input);
            
            // calculate fat free mass
            ffmOutput = massiveCalc.calcFFM(bodyFatPrcntInput);
            
            // display fat free mass in kgs to user
            massiveNorth.cCondition.FatFreePanel.ffmQuan.setText(df.format(ffmOutput));
         }
         catch (Exception e)
         {
            JOptionPane.showMessageDialog(massiveNorth.cCondition.BodyFatPanel, e.getMessage() + "\nPlease enter a proper value.", 
            "Alert", JOptionPane.ERROR_MESSAGE);
         }
      }
      else
      {
         JOptionPane.showMessageDialog(massiveNorth.cCondition.BodyFatPanel, "Missing information. \nPlease enter a value.", 
         "Alert", JOptionPane.ERROR_MESSAGE);
      } 
            
      return ffmOutput; 
   } 
   
   // method to calculate resting metabolic rate
   public double getRMR()
   {
      // calculate resting metabolic rate
      rmrOutput = massiveCalc.calcRMR();
            
      // display rmr to user
      massiveNorth.cCondition.RestingPanel.rmrQuan.setText(df.format(rmrOutput));
           
      return rmrOutput;
   }
   
   public void checkActivityFactor()
   {
      if (massiveNorth.cCondition.KiloPanel.bWeightKgsQuan.getText().trim().isEmpty() || 
      massiveNorth.cCondition.FatFreePanel.ffmQuan.getText().trim().isEmpty() ||
      massiveNorth.cCondition.RestingPanel.rmrQuan.getText().trim().isEmpty())
      {
         JOptionPane.showMessageDialog(massiveSouth.weightGoal.wgPanel.activityPanel.activityNorth, 
         "Missing information. \nPlease enter a value.", "Alert", JOptionPane.ERROR_MESSAGE);
      }
      else
      {
         getActivityFactor();
      }   
   }
   
   public double getActivityFactor()
   {      
      // get input from user
      input = massiveSouth.weightGoal.wgPanel.activityPanel.activityNorth.afPanel.activityFactorQuan.getText();
         
      // check for null/empty text box
      if(input != null && !input.isEmpty())
      {
         // try/catch for exceptions
         try
         {
         // convert input to double
         activityFactorInput = Double.parseDouble(input);
      
         // calculate rmrActivity
         rmrActivityOutput = massiveCalc.calcActivityFactor(activityFactorInput);
            
         // display rmrActivity
         massiveSouth.weightGoal.wgPanel.activityPanel.activityNorth.amr1Panel.adjustedMRQuan.setText(df.format(rmrActivityOutput));
         }
         catch (Exception e)
         {
            JOptionPane.showMessageDialog(massiveSouth.weightGoal.wgPanel.activityPanel.activityNorth, 
            e.getMessage() + "\nPlease enter a proper value.", "Alert", JOptionPane.ERROR_MESSAGE);
         }
      }
      else
      {
         JOptionPane.showMessageDialog(massiveSouth.weightGoal.wgPanel.activityPanel.activityNorth, 
         "Missing information. \nPlease enter a value", "Alert", JOptionPane.ERROR_MESSAGE);
      }
            
      return rmrActivityOutput;
   }
   
   public void answerActivityQuest()
   {
      // display dialog box to user explaining activity factor
      JOptionPane.showMessageDialog(massiveSouth.weightGoal.wgPanel.activityPanel.activityNorth, 
              "Activity Factors are as follows: \n1.2-1.3 for Very Light (bed rest)" +
              "\n1.5-1.6 for Light (office work/watching TV) \n1.6-1.7 for Moderate (some activity during day)" + 
              "\n1.9-2.1 for Heavy (labor type work) \nActivity Factors do not include your workouts.");
   }
   
   public void checkWeights()
   {
      if (massiveNorth.cCondition.KiloPanel.bWeightKgsQuan.getText().trim().isEmpty() || 
      massiveNorth.cCondition.FatFreePanel.ffmQuan.getText().trim().isEmpty() ||
      massiveNorth.cCondition.RestingPanel.rmrQuan.getText().trim().isEmpty() ||
      massiveSouth.weightGoal.wgPanel.activityPanel.activityNorth.amr1Panel.adjustedMRQuan.getText().trim().isEmpty())
      {
         JOptionPane.showMessageDialog(massiveSouth.weightGoal.wgPanel.activityPanel.activityNorth.weightsPanel, 
         "Missing information. \nPlease enter a value.", "Alert", JOptionPane.ERROR_MESSAGE);
      }
      else
      {
         getWeightsExpend();
      }   
   }
   
   public double getWeightsExpend()
   {     
      // get input from user
      input = massiveSouth.weightGoal.wgPanel.activityPanel.activityNorth.weightsPanel.exWeightsQuan.getText();
         
      // check for null/empty text box
      if(input != null && !input.isEmpty())
      {
         // try/catch for exceptions
         try
         {
            // convert input to double
            exWeightsInput = Double.parseDouble(input);
            
            // calculate weight expenditure
            rmrWeightsOutput = massiveCalc.calcWeightsExpend(exWeightsInput);   
                           
            // display weight expenditure to user
            massiveSouth.weightGoal.wgPanel.activityPanel.activitySouth.amr2Panel.adjustedMRQuan.setText(df.format(rmrWeightsOutput));
         }
         catch (Exception e)
         {
            JOptionPane.showMessageDialog(massiveSouth.weightGoal.wgPanel.activityPanel.activityNorth.weightsPanel, 
            e.getMessage() + "\nPlease enter a proper value.", "Alert", JOptionPane.ERROR_MESSAGE);
         }
      }
      else
      {
         JOptionPane.showMessageDialog(massiveSouth.weightGoal.wgPanel.activityPanel.activityNorth.weightsPanel, 
         "Missing information. \nPlease enter a value.", "Alert", JOptionPane.ERROR_MESSAGE);
      }
            
      return rmrWeightsOutput;
   } 
   
   public void checkCardio()
   {
      if (massiveNorth.cCondition.KiloPanel.bWeightKgsQuan.getText().trim().isEmpty() || 
      massiveNorth.cCondition.FatFreePanel.ffmQuan.getText().trim().isEmpty() ||
      massiveNorth.cCondition.RestingPanel.rmrQuan.getText().trim().isEmpty() ||
      massiveSouth.weightGoal.wgPanel.activityPanel.activityNorth.amr1Panel.adjustedMRQuan.getText().trim().isEmpty() ||
      massiveSouth.weightGoal.wgPanel.activityPanel.activitySouth.amr2Panel.adjustedMRQuan.getText().trim().isEmpty())
      {
         JOptionPane.showMessageDialog(massiveSouth.weightGoal.wgPanel.activityPanel.activitySouth, 
         "Missing information. \nPlease enter a value.", "Alert", JOptionPane.ERROR_MESSAGE);
      }
      else
      {
         getCardioExpend();
      }   
   }
   
   public double getCardioExpend()
   {      
      // get input from user
      input = massiveSouth.weightGoal.wgPanel.activityPanel.activitySouth.cardioPanel.exCardioQuan.getText();
         
      // check for null/empty text box
      if(input != null && !input.isEmpty())
      {
         // try/catch for exceptions
         try
         {
            // convert input to double
            exCardioInput = Double.parseDouble(input);
            
            // calculate cardio expenditure
            rmrCardioOutput = massiveCalc.calcCardioExpend(exCardioInput);   
      
            // display cardio expenditure to user
            massiveSouth.weightGoal.wgPanel.activityPanel.activitySouth.amr3Panel.adjustedMRQuan.setText(df.format(rmrCardioOutput));
         }
         catch (Exception e)
         {
               JOptionPane.showMessageDialog(massiveSouth.weightGoal.wgPanel.activityPanel.activitySouth, 
               e.getMessage() + "\nPlease enter a proper value.", "Alert", JOptionPane.ERROR_MESSAGE);
         }
      }
      else
      {
         JOptionPane.showMessageDialog(massiveSouth.weightGoal.wgPanel.activityPanel.activitySouth, 
         "Missing information. \nPlease enter a value.", "Alert", JOptionPane.ERROR_MESSAGE);
      }
      
      return rmrCardioOutput;
   }
   
   public void checkTEF()
   {
      if (massiveNorth.cCondition.KiloPanel.bWeightKgsQuan.getText().trim().isEmpty() || 
      massiveNorth.cCondition.FatFreePanel.ffmQuan.getText().trim().isEmpty() ||
      massiveNorth.cCondition.RestingPanel.rmrQuan.getText().trim().isEmpty() ||
      massiveSouth.weightGoal.wgPanel.activityPanel.activityNorth.amr1Panel.adjustedMRQuan.getText().trim().isEmpty() ||
      massiveSouth.weightGoal.wgPanel.activityPanel.activitySouth.amr2Panel.adjustedMRQuan.getText().trim().isEmpty() ||
      massiveSouth.weightGoal.wgPanel.activityPanel.activitySouth.amr3Panel.adjustedMRQuan.getText().trim().isEmpty())
      {
         JOptionPane.showMessageDialog(massiveSouth.weightGoal.wgPanel.thermicPanel.tsPanel, "Missing information. \nPlease enter a value.", 
         "Alert", JOptionPane.ERROR_MESSAGE);
      }
      else
      {
         getTEF();
      }   
   }
   
   public double getTEF()
   {
      if (rmrCardioOutput != 0)
      {
         // series of if statements to determine which radio button is selected
         if (massiveSouth.weightGoal.wgPanel.thermicPanel.tnPanel.tefRowOne.lowP.isSelected())
         {
            thermicOutput = massiveCalc.calcTEF1();
            massiveSouth.weightGoal.wgPanel.thermicPanel.tsPanel.tefRowFour.tmrQuan.setText(df.format(thermicOutput));
         }
         else if (massiveSouth.weightGoal.wgPanel.thermicPanel.tnPanel.tefRowTwo.modP.isSelected())
         {
            thermicOutput = massiveCalc.calcTEF2();
            massiveSouth.weightGoal.wgPanel.thermicPanel.tsPanel.tefRowFour.tmrQuan.setText(df.format(thermicOutput));
         }
         else if (massiveSouth.weightGoal.wgPanel.thermicPanel.tnPanel.tefRowTwo.highP.isSelected())
         {
            thermicOutput = massiveCalc.calcTEF3();
            massiveSouth.weightGoal.wgPanel.thermicPanel.tsPanel.tefRowFour.tmrQuan.setText(df.format(thermicOutput));
         }
         else
         {
            JOptionPane.showMessageDialog(massiveSouth.weightGoal.wgPanel.thermicPanel, "Please select your level of protein intake.", 
            "Alert", JOptionPane.ERROR_MESSAGE);
         }
      }
      else
      {
         JOptionPane.showMessageDialog(massiveSouth.weightGoal.wgPanel.thermicPanel, 
         "Missing information. \nPlease enter a value.", "Alert", JOptionPane.ERROR_MESSAGE);
      }
      
      return thermicOutput;
   }
   
   public void explainTEF()
   {
      // display dialog box to user explaining thermic effect
      JOptionPane.showMessageDialog(massiveSouth.weightGoal.wgPanel.thermicPanel.tnPanel, 
              "Low protein diet:  < 1 gram protein /lb bodyweight" + 
              "\nMod protein diet:  = 1 gram protein /lb bodyweight" + 
              "\nHigh protein diet: > 1 gram protein /lb bodyweight");

   }
   
   public void checkBoxes()
   {
      // get input from current panel
      input = massiveNorth.cCondition.RestingPanel.rmrQuan.getText();
      
      // check for null/empty text box
      if (input != null && !input.isEmpty())
      {
         // get input from user
         input = massiveSouth.weightGoal.wlPanel.meansPanel.targetBFquan.getText();
         
         // check for null/empty text box
         if (input != null && !input.isEmpty())
         {
            // try/catch for exceptions
            try
            {
               getAMR();
               getExercise();
               getWeightLoss();
            }
            catch (Exception e)
            {
               JOptionPane.showMessageDialog(massiveSouth.weightGoal.wlPanel.meansPanel, 
               e.getMessage() + "\nPlease enter a proper value.", "Alert", JOptionPane.ERROR_MESSAGE);
            }
         }
         else
         {
            JOptionPane.showMessageDialog(massiveSouth.weightGoal.wlPanel.meansPanel, 
            "Missing information. \nPlease enter a value.", "Alert", JOptionPane.ERROR_MESSAGE);
         }
      }
      else
      {
         JOptionPane.showMessageDialog(massiveSouth.weightGoal.wlPanel.meansPanel, 
         "Missing information. \nPlease enter a value.", "Alert", JOptionPane.ERROR_MESSAGE);
      }
   }
   
   // calculate caloric intake needed for diet
   public double getAMR()
   {
      // calcAMR
      adjustedMR = massiveCalc.calcAMR();
            
      // display AMR
      massiveSouth.weightGoal.wlPanel.dietPanel.dietQuan.setText(df.format(adjustedMR));    
      
      return adjustedMR;
   } 
   
   // calculate exercise needed for diet
   public double getExercise()
   {       
       // calculate target calories needed to be burned
       targetCalorieBurn = massiveCalc.calcExercise();
       
       // display calories burned
       massiveSouth.weightGoal.wlPanel.exercisePanel.exerciseQuan.setText(df.format(targetCalorieBurn));
                 
       return targetCalorieBurn;
   }
   
   // calculate target bodyweight   
   public double getWeightLoss()
   {      
      // get input from user
      input = massiveSouth.weightGoal.wlPanel.meansPanel.targetBFquan.getText();
      
      // convert input to double
      targetBodyFatInput = Double.parseDouble(input);
      
      // calculate target fat free mass decimal
      targetFatFreeMassDecimal = massiveCalc.calcWeightLoss(targetBodyFatInput);
      
      getTotalMassKG();
      getTotalMassLBS();
                     
      return targetFatFreeMassDecimal;
   } 
   
   public double getTotalMassKG()
   {      
      // calculate target total mass kg
      targetTotalMassKg = massiveCalc.calcTotalMassKg();
                  
      // display total mass kg
      massiveSouth.weightGoal.wlPanel.resultsPanel.resultsRowOne.targetKGquan.setText(df.format(targetTotalMassKg));
            
      return targetTotalMassKg;
   } 
   
   public double getTotalMassLBS()
   {
      if (targetTotalMassKg != 0)
      {
         // caclulate target total mass lbs
         targetTotalMassLbs = massiveCalc.calcTotalMassLbs();
            
         // display total mass lbs
         massiveSouth.weightGoal.wlPanel.resultsPanel.resultsRowTwo.targetLBSquan.setText(df.format(targetTotalMassLbs));
      }
      
      return targetTotalMassLbs;
   } 
   
   public void explainTBF()
   {
      JOptionPane.showMessageDialog(massiveSouth.weightGoal.wlPanel.meansPanel, 
              "To help you determine an ideal target body fat level use the" +
              "\nfollowing body fat levels to help you determine what's right for you." +
              "\nMale athletes typically have 6-13% body fat." +
              "\nFemale athletes typically have 14-20% body fat.");

   }
   
   public void clearAllText()
   {
      // clear bWeightLbs box
      massiveNorth.cCondition.PoundsPanel.bWeightLbsQuan.setText("");
      
      // clear bWeightKgs box
      massiveNorth.cCondition.KiloPanel.bWeightKgsQuan.setText("");
      
      // clear bodyFat box
      massiveNorth.cCondition.BodyFatPanel.bFatPercentQuan.setText("");
      
      // clear fatFreeMass box
      massiveNorth.cCondition.FatFreePanel.ffmQuan.setText("");
      
      // clear restingMetabolicRate box
      massiveNorth.cCondition.RestingPanel.rmrQuan.setText("");
      
      // clear activityFactor box
      massiveSouth.weightGoal.wgPanel.activityPanel.activityNorth.afPanel.activityFactorQuan.setText("");
      
      // clear adjustedMR1 box
      massiveSouth.weightGoal.wgPanel.activityPanel.activityNorth.amr1Panel.adjustedMRQuan.setText("");
      
      // clear exWeights box
      massiveSouth.weightGoal.wgPanel.activityPanel.activityNorth.weightsPanel.exWeightsQuan.setText("");
      
      // clear adjustedMR2 box
      massiveSouth.weightGoal.wgPanel.activityPanel.activitySouth.amr2Panel.adjustedMRQuan.setText("");
      
      // clear exCardio box
      massiveSouth.weightGoal.wgPanel.activityPanel.activitySouth.cardioPanel.exCardioQuan.setText("");
      
      // clear adjustedMR3 box
      massiveSouth.weightGoal.wgPanel.activityPanel.activitySouth.amr3Panel.adjustedMRQuan.setText("");
      
      // clear radio buttons
      massiveSouth.weightGoal.wgPanel.thermicPanel.radioGroup.clearSelection();
      
      // clear totalMetabolicRate box
      massiveSouth.weightGoal.wgPanel.thermicPanel.tsPanel.tefRowFour.tmrQuan.setText("");
      
      // clear targetBF box
      massiveSouth.weightGoal.wlPanel.meansPanel.targetBFquan.setText("");
       
      // clear dietAdjustedMR box
      massiveSouth.weightGoal.wlPanel.dietPanel.dietQuan.setText("");
       
      // clear exercise box
      massiveSouth.weightGoal.wlPanel.exercisePanel.exerciseQuan.setText("");
       
      // clear results boxes
      massiveSouth.weightGoal.wlPanel.resultsPanel.resultsRowOne.targetKGquan.setText("");
      massiveSouth.weightGoal.wlPanel.resultsPanel.resultsRowTwo.targetLBSquan.setText("");
   }
}
