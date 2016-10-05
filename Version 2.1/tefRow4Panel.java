import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.ComponentOrientation;
import java.text.DecimalFormat;
import java.text.NumberFormat; 
import java.awt.Component.*; 
import java.lang.Object;
import java.util.Locale; 

public class tefRow4Panel extends JPanel
{
   // declare variables
   private JLabel tmrLabel;
   public JTextField tmrQuan;
      
   /**
	   Constructor
	*/
   
   public tefRow4Panel()
   {
      // create components
      tmrLabel = new JLabel("Total Metabolic Rate: ");
      tmrQuan = new JTextField(7);
      tmrQuan.setEditable(false);  
          
      // set layout
      setLayout(new FlowLayout(FlowLayout.CENTER, 4, 1));
      
      // add components
      add(tmrLabel);
      add(tmrQuan);
   }
}