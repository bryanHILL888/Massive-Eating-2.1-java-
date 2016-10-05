import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.ComponentOrientation;
import java.text.DecimalFormat;
import java.text.NumberFormat; 
import java.awt.Component.*; 
import java.lang.Object;
import java.util.Locale; 

public class ResultsRow1Panel extends JPanel
{
   // declare variables
   private JLabel targetKGlbl;
   public JTextField targetKGquan;
   private JLabel resultsSpace1;
      
   /**
	   Constructor
	*/
   
   public ResultsRow1Panel()
   {
      // create components
      targetKGlbl = new JLabel("Target Bodyweight (kg): ");
      targetKGquan = new JTextField(7);
      targetKGquan.setEditable(false);
      resultsSpace1 = new JLabel("                     ");
      
      // set layout
      setLayout(new FlowLayout(FlowLayout.RIGHT, 4, 1));
           
      // add components
      add(targetKGlbl);
      add(targetKGquan);
      add(resultsSpace1);
   }
}