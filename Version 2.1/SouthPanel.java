import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.ComponentOrientation;
import java.text.DecimalFormat;
import java.text.NumberFormat; 
import java.awt.Component.*; 
import java.lang.Object;
import java.util.Locale; 

public class SouthPanel extends JPanel
{
   // declare variables
   TabPanel weightGoal;
   clearPanel clrPanel;
   VersionPanel versionInfo;
      
   /**
	   Constructor
	*/
   
   public SouthPanel()
   {
      // create components
      weightGoal = new TabPanel();
      clrPanel = new clearPanel();
      versionInfo = new VersionPanel();
      
      // set layout
      setLayout(new BorderLayout());
      
      // add components
      add(weightGoal, BorderLayout.NORTH);
      add(clrPanel, BorderLayout.CENTER);
      add(versionInfo, BorderLayout.SOUTH);
   }
}