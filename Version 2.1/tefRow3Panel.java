import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.ComponentOrientation;
import java.text.DecimalFormat;
import java.text.NumberFormat; 
import java.awt.Component.*; 
import java.lang.Object;
import java.util.Locale; 

public class tefRow3Panel extends JPanel
{
   // declare variables
   public JButton calcTMRbtn;
      
   /**
	   Constructor
	*/
   
   public tefRow3Panel()
   {
      // create components
      calcTMRbtn = new JButton("Calculate TEF");  
          
      // set layout
      setLayout(new FlowLayout(FlowLayout.CENTER, 4, 1));
      
      // add components
      add(calcTMRbtn);
   }
}