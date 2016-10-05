import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.ComponentOrientation;
import java.text.DecimalFormat;
import java.text.NumberFormat; 
import java.awt.Component.*; 
import java.lang.Object;
import java.util.Locale; 

public class AdjustedMRPanel extends JPanel
{
   // declare variables
   private JLabel amrBlank1;
   private JLabel adjustedMR1Lbl;
   public JTextField adjustedMRQuan;
   private JLabel amrBlank2;
      
   /**
	   Constructor
	*/
   
   public AdjustedMRPanel()
   {
      // create components
      amrBlank1 = new JLabel("   ");
      adjustedMR1Lbl = new JLabel("Adjusted Metabolic Rate: ");
      adjustedMRQuan = new JTextField(7);
      amrBlank2 = new JLabel("                     ");
      adjustedMRQuan.setEditable(false);
      
      // set layout
      setLayout(new FlowLayout(FlowLayout.RIGHT, 4, 1));
      
      // add components
      add(amrBlank1);
      add(adjustedMR1Lbl);
      add(adjustedMRQuan);
      add(amrBlank2);
   }
}