import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.ComponentOrientation;
import java.text.DecimalFormat;
import java.text.NumberFormat; 
import java.awt.Component.*; 
import java.lang.Object;
import java.util.Locale; 

public class bWeightLbsPanel extends JPanel
{
   private JLabel bWeightLbsLabel;
   public JTextField bWeightLbsQuan;
   public JButton bWeightLbsButton;
      
   /**
	   Constructor
	*/
   
   public bWeightLbsPanel()
   {
      // create components
      bWeightLbsLabel = new JLabel("Bodyweight (lbs): ");
      bWeightLbsQuan = new JTextField(7);
      bWeightLbsButton = new JButton("Enter");
      
      // set layout
      setLayout(new FlowLayout(FlowLayout.RIGHT, 4, 1));
      
      // add components
      add(bWeightLbsLabel);
      add(bWeightLbsQuan);
      add(bWeightLbsButton);
   }
}  