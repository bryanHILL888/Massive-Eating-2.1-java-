import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.ComponentOrientation;
import java.text.DecimalFormat;
import java.text.NumberFormat; 
import java.awt.Component.*; 
import java.lang.Object;
import java.util.Locale;

public class TabPanel extends JPanel
{
   // declare variables
   WeightGainPanel wgPanel;
   WeightLossPanel wlPanel;
   JTabbedPane weightGoals;
   
   /**
	   Constructor
	*/
   
   public TabPanel()
   {
      wgPanel = new WeightGainPanel();
      wlPanel = new WeightLossPanel();
      weightGoals = new JTabbedPane();
      weightGoals.add("Weight Gain", wgPanel);
      weightGoals.add("Weight Loss", wlPanel);
   
      add(weightGoals);
   }
   
}
