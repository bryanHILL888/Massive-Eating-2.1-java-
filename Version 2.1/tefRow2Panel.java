import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.ComponentOrientation;
import java.text.DecimalFormat;
import java.text.NumberFormat; 
import java.awt.Component.*; 
import java.lang.Object;
import java.util.Locale; 

public class tefRow2Panel extends JPanel
{
   // declare variables
   public JRadioButton modP;
   public JRadioButton highP;
      
   /**
	   Constructor
	*/
   
   public tefRow2Panel()
   {
      // create components
      modP = new JRadioButton("Moderate Protein Diet");
      highP = new JRadioButton("High Protein Diet");  
          
      // set layout
      setLayout(new FlowLayout(FlowLayout.CENTER, 4, 1));
      
      // add components
      add(modP);
      add(highP);
   }
}