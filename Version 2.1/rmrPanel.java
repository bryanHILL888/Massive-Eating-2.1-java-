import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.ComponentOrientation;
import java.text.DecimalFormat;
import java.text.NumberFormat; 
import java.awt.Component.*; 
import java.lang.Object;
import java.util.Locale; 

public class rmrPanel extends JPanel
{
   // declare variables
   private JLabel rmrLabel;
   public JTextField rmrQuan;
   private JLabel rmrBlank;
   
   /**
	   Constructor
	*/
   
   public rmrPanel()
   {
      // create components
      rmrLabel = new JLabel("Resting Metabolic Rate: ");
      rmrQuan = new JTextField(7);
      rmrBlank = new JLabel("                     ");
      rmrQuan.setEditable(false);
                              
      // set layout
      setLayout(new FlowLayout(FlowLayout.RIGHT, 4, 1));
      
      // add components
      add(rmrLabel);
      add(rmrQuan);
      add(rmrBlank);
   }
}