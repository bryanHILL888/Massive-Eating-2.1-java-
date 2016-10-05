import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.ComponentOrientation;
import java.text.DecimalFormat;
import java.text.NumberFormat; 
import java.awt.Component.*; 
import java.lang.Object;
import java.util.Locale; 

public class WeightGainPanel extends JPanel
{
   // declare variables
   ActivityPanel activityPanel;
   ThermicPanel thermicPanel;
      
   /**
	   Constructor
	*/
   
   public WeightGainPanel()
   {
      // create components
      activityPanel = new ActivityPanel();
      thermicPanel = new ThermicPanel();
      
      // set layout
      setLayout(new BorderLayout());
      
      // add components
      add(activityPanel, BorderLayout.NORTH);
      add(thermicPanel, BorderLayout.SOUTH);
   }
}