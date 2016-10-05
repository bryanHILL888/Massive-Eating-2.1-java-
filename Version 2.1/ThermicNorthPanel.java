import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.ComponentOrientation;
import java.text.DecimalFormat;
import java.text.NumberFormat; 
import java.awt.Component.*; 
import java.lang.Object;
import java.util.Locale; 

public class ThermicNorthPanel extends JPanel
{
   // declare variables
   tefRow1Panel tefRowOne;
   tefRow2Panel tefRowTwo;
      
   /**
	   Constructor
	*/
   
   public ThermicNorthPanel()
   {
      // create components
      tefRowOne = new tefRow1Panel();
      tefRowTwo = new tefRow2Panel();
        
      // set layout
      setLayout(new BorderLayout());
      
      // add components
      add(tefRowOne, BorderLayout.NORTH);
      add(tefRowTwo, BorderLayout.SOUTH);
   }
}