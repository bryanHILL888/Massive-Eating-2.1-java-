import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.ComponentOrientation;
import java.text.DecimalFormat;
import java.text.NumberFormat; 
import java.awt.Component.*; 
import java.lang.Object;
import java.util.Locale; 

public class ThermicSouthPanel extends JPanel
{
   // declare variables
   tefRow3Panel tefRowThree;
   tefRow4Panel tefRowFour;
      
   /**
	   Constructor
	*/
   
   public ThermicSouthPanel()
   {
      // create components
      tefRowThree = new tefRow3Panel();
      tefRowFour = new tefRow4Panel();
            
      // set layout
      setLayout(new BorderLayout());
      
      // add components
      add(tefRowThree, BorderLayout.NORTH);
      add(tefRowFour, BorderLayout.SOUTH);
   }
}