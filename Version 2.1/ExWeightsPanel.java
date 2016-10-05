import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.ComponentOrientation;
import java.text.DecimalFormat;
import java.text.NumberFormat; 
import java.awt.Component.*; 
import java.lang.Object;
import java.util.Locale; 

public class ExWeightsPanel extends JPanel
{
   // declare variables
   private JLabel exWBlank;
   private JLabel exWeightsLbl;
   public JTextField exWeightsQuan;
   public JButton exWeightsBtn;
      
   /**
	   Constructor
	*/
   
   public ExWeightsPanel()
   {
      // create components
      exWBlank = new JLabel("   ");
      exWeightsLbl = new JLabel("Excercise Time for Weights (hrs): ");
      exWeightsQuan = new JTextField(7);
      exWeightsBtn = new JButton("Enter");
            
      // set layout
      setLayout(new FlowLayout(FlowLayout.RIGHT, 4, 1));
      
      // add components
      add(exWBlank);
      add(exWeightsLbl);
      add(exWeightsQuan);
      add(exWeightsBtn);
   }
}