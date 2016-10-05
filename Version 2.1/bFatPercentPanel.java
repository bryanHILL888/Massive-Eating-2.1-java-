import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.ComponentOrientation;
import java.text.DecimalFormat;
import java.text.NumberFormat; 
import java.awt.Component.*; 
import java.lang.Object;
import java.util.Locale; 

public class bFatPercentPanel extends JPanel
{
   // declare variables
   private JLabel bFatPercentLbl;
   public JTextField bFatPercentQuan;
   public JButton bFatPercentBtn;
   
   /**
	   Constructor
	*/
   
   public bFatPercentPanel()
   {
      // create components
      bFatPercentLbl = new JLabel("Body Fat %: ");
      bFatPercentQuan = new JTextField(7);
      bFatPercentBtn = new JButton("Enter");
                  
      // set layout
      setLayout(new FlowLayout(FlowLayout.RIGHT, 4, 1));
      
      // add components
      add(bFatPercentLbl);
      add(bFatPercentQuan);
      add(bFatPercentBtn);
   }
}