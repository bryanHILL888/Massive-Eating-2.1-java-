import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.ComponentOrientation;
import java.text.DecimalFormat;
import java.text.NumberFormat; 
import java.awt.Component.*; 
import java.lang.Object;
import java.util.Locale; 

public class ActivitySouthPanel extends JPanel
{
   // declare variables
   AdjustedMRPanel amr2Panel;
   ExCardioPanel cardioPanel;
   AdjustedMRPanel amr3Panel;
      
   /**
	   Constructor
	*/
   
   public ActivitySouthPanel()
   {
      // create components
      amr2Panel = new AdjustedMRPanel();
      cardioPanel = new ExCardioPanel();
      amr3Panel = new AdjustedMRPanel();
      
      // set layout
      setLayout(new BorderLayout());
      
      // add components
      add(amr2Panel, BorderLayout.NORTH);
      add(cardioPanel, BorderLayout.CENTER);
      add(amr3Panel, BorderLayout.SOUTH);
   }
}