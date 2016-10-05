import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.ComponentOrientation;
import java.text.DecimalFormat;
import java.text.NumberFormat; 
import java.awt.Component.*; 
import java.lang.Object;
import java.util.Locale; 

public class ActivityNorthPanel extends JPanel
{
   // declare variables
   ActivityFactorPanel afPanel;
   AdjustedMRPanel amr1Panel;
   ExWeightsPanel weightsPanel;
      
   /**
	   Constructor
	*/
   
   public ActivityNorthPanel()
   {
      // create components
      afPanel = new ActivityFactorPanel();
      amr1Panel = new AdjustedMRPanel();
      weightsPanel = new ExWeightsPanel();
      
      // set layout
      setLayout(new BorderLayout());
      
      // add components
      add(afPanel, BorderLayout.NORTH);
      add(amr1Panel, BorderLayout.CENTER);
      add(weightsPanel, BorderLayout.SOUTH);
   }
}