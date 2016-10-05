import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.ComponentOrientation;
import java.text.DecimalFormat;
import java.text.NumberFormat; 
import java.awt.Component.*; 
import java.lang.Object;
import java.util.Locale; 

public class ThermicPanel extends JPanel
{
   // declare variables
   ThermicNorthPanel tnPanel;
   ThermicSouthPanel tsPanel; 
   ButtonGroup radioGroup;
      
   /**
	   Constructor
	*/
   
   public ThermicPanel()
   {
      // create components
      tnPanel = new ThermicNorthPanel();
      tsPanel = new ThermicSouthPanel();
      radioGroup = new ButtonGroup();
      
      // add radio buttons to ButtonGroup
      radioGroup.add(tnPanel.tefRowOne.lowP);
      radioGroup.add(tnPanel.tefRowTwo.modP);
      radioGroup.add(tnPanel.tefRowTwo.highP);
            
      // set layout
      setLayout(new BorderLayout());
      
      // set border
      setBorder(BorderFactory.createTitledBorder("Thermic Effect of Food"));
      
      // add components
      add(tnPanel, BorderLayout.NORTH);
      add(tsPanel, BorderLayout.SOUTH);
   }
}