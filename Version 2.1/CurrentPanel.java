import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.ComponentOrientation;
import java.text.DecimalFormat; 
import java.awt.Component.*; 
import java.lang.Object;
import java.util.Locale; 

public class CurrentPanel extends JPanel
{
   // declare variables
	DecimalFormat df = new DecimalFormat("#0.0");
   
   bWeightLbsPanel PoundsPanel;  
   bWeightKgsPanel KiloPanel;
   bFatPercentPanel BodyFatPanel;
   ffmPanel FatFreePanel;
   rmrPanel RestingPanel;
       
   /**
	   Constructor
	*/
   
   public CurrentPanel()
   {
      // create bodyweight lbs panel
      PoundsPanel = new bWeightLbsPanel();
      
      // create bodyweight kgs panel
      KiloPanel = new bWeightKgsPanel();
      
      // create bodyfat % panel
      BodyFatPanel = new bFatPercentPanel();
      
      // create fat free mass panel
      FatFreePanel = new ffmPanel();
            
      // create rmr panel
      RestingPanel = new rmrPanel();
      
      
      // set layout
      setLayout(new GridLayout(5, 1));
      
      // set border
      setBorder(BorderFactory.createTitledBorder("Current Condition"));
      
      // add components
      add(PoundsPanel);
      add(KiloPanel);
      add(BodyFatPanel);
      add(FatFreePanel);
      add(RestingPanel);
   }
}