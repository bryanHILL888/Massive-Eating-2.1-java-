import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.ComponentOrientation;
import java.text.DecimalFormat;
import java.text.NumberFormat; 
import java.awt.Component.*; 
import java.lang.Object;
import java.util.Locale; 

public class ResultsRow2Panel extends JPanel
{
   // declare variables
   private JLabel targetLBSlbl;
   public JTextField targetLBSquan;
   private JLabel resultsSpace2;
      
   /**
	   Constructor
	*/
   
   public ResultsRow2Panel()
   {
      // create components
      targetLBSlbl = new JLabel("Target Bodyweight (lbs): ");
      targetLBSquan = new JTextField(7);
      targetLBSquan.setEditable(false);
      resultsSpace2 = new JLabel("                     ");
      
      // set layout
      setLayout(new FlowLayout(FlowLayout.RIGHT, 4, 1));
           
      // add components
      add(targetLBSlbl);
      add(targetLBSquan);
      add(resultsSpace2);
   }
}