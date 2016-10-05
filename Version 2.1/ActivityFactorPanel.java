import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.ComponentOrientation;
import java.text.DecimalFormat;
import java.text.NumberFormat; 
import java.awt.Component.*; 
import java.lang.Object;
import java.util.Locale; 

public class ActivityFactorPanel extends JPanel
{
   // declare variables
   public JButton questButton;
   private JLabel activityFactorLbl;
   public JTextField activityFactorQuan;
   public JButton activityFactorBtn;
      
   /**
	   Constructor
	*/
   
   public ActivityFactorPanel()
   {
      // create components
      questButton = new JButton("?");
      activityFactorLbl = new JLabel("Activity Factor: ");
      activityFactorQuan = new JTextField(7);
      activityFactorBtn = new JButton("Enter");
            
      // set layout
      setLayout(new FlowLayout(FlowLayout.RIGHT, 4, 1));
      
      // add components
      add(questButton);
      add(activityFactorLbl);
      add(activityFactorQuan);
      add(activityFactorBtn);
   }
}