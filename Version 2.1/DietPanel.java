import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.ComponentOrientation;
import java.text.DecimalFormat;
import java.text.NumberFormat; 
import java.awt.Component.*; 
import java.lang.Object;
import java.util.Locale; 

public class DietPanel extends JPanel
{
   // declare variables
   private JLabel dietLabel;
   public JTextField dietQuan;
   private JLabel dietSpace;
      
   /**
	   Constructor
	*/
   
   public DietPanel()
   {
      // create components
      dietLabel = new JLabel("Adjusted Metabolic Rate: ");
      dietQuan = new JTextField(7);
      dietQuan.setEditable(false);
      dietSpace = new JLabel("                     ");
      
      // set layout
      setLayout(new FlowLayout(FlowLayout.RIGHT, 4, 1));
      
      // set border
      setBorder(BorderFactory.createTitledBorder("Diet"));
      
      // add components
      add(dietLabel);
      add(dietQuan);
      add(dietSpace);
   }
}