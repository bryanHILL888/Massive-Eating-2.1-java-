import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.ComponentOrientation;
import java.text.DecimalFormat;
import java.text.NumberFormat; 
import java.awt.Component.*; 
import java.lang.Object;
import java.util.Locale; 

public class tefRow1Panel extends JPanel
{
   // declare variables
   public JButton questButton2;
   public JRadioButton lowP;
   private JLabel tefBlank1;
   private JLabel tefBlank2;
      
   /**
	   Constructor
	*/
   
   public tefRow1Panel()
   {
      // create components
      questButton2 = new JButton("?");
      tefBlank1 = new JLabel("   ");
      lowP = new JRadioButton("Low Protein Diet");
      tefBlank2 = new JLabel("        ");  
          
      // set layout
      setLayout(new FlowLayout(FlowLayout.CENTER, 4, 1));
      
      // add components
      add(questButton2);
      add(tefBlank1);
      add(lowP);
      add(tefBlank2);
   }
}