import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.ComponentOrientation;
import java.text.DecimalFormat;
import java.text.NumberFormat; 
import java.awt.Component.*; 
import java.lang.Object;
import java.util.Locale; 

public class NorthPanel extends JPanel
{
   // declare variables
   LogoPanel meLogo;
   CurrentPanel cCondition;
      
   /**
	   Constructor
	*/
   
   public NorthPanel()
   {
      // create components
      meLogo = new LogoPanel();
      cCondition = new CurrentPanel();
      
      // set layout
      setLayout(new BorderLayout());
      
      // add components
      add(meLogo, BorderLayout.NORTH);
      add(cCondition, BorderLayout.SOUTH);
   }
}