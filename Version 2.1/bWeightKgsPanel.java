import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.ComponentOrientation;
import java.text.DecimalFormat;
import java.text.NumberFormat; 
import java.awt.Component.*; 
import java.lang.Object;
import java.util.Locale; 

public class bWeightKgsPanel extends JPanel
{
   // declare variables
   private JLabel bWeightKgsLabel;
   public JTextField bWeightKgsQuan;
   private JLabel kgBlank;
   
   /**
	   Constructor
	*/
   
   public bWeightKgsPanel()
   {
      // create components
      bWeightKgsLabel = new JLabel("Bodyweight (kg): ");
      bWeightKgsQuan = new JTextField(7);
      bWeightKgsQuan.setEditable(false); 
      kgBlank = new JLabel("                     "); 
            
      // set layout
      setLayout(new FlowLayout(FlowLayout.RIGHT, 4, 1));
      
      // add components
      add(bWeightKgsLabel);
      add(bWeightKgsQuan);
      add(kgBlank);
   }
}