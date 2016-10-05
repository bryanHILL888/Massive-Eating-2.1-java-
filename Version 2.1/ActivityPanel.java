import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.ComponentOrientation;
import java.text.DecimalFormat;
import java.text.NumberFormat; 
import java.awt.Component.*; 
import java.lang.Object;
import java.util.Locale; 

public class ActivityPanel extends JPanel
{
   // declare variables
   ActivityNorthPanel activityNorth; 
   ActivitySouthPanel activitySouth;
      
   /**
	   Constructor
	*/
   
   public ActivityPanel()
   {
      // create components
      activityNorth = new ActivityNorthPanel();
      activitySouth = new ActivitySouthPanel();
      
      // set layout
      setLayout(new BorderLayout());
      
      // add components
      add(activityNorth, BorderLayout.NORTH);
      add(activitySouth, BorderLayout.SOUTH);
   }
}