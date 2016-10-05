import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.ComponentOrientation;
import java.text.DecimalFormat;
import java.text.NumberFormat; 
import java.awt.Component.*; 
import java.lang.Object;
import java.util.Locale; 

public class ffmPanel extends JPanel
{
   // declare variables
   private JLabel ffmLabel;
   public JTextField ffmQuan;
   private JLabel ffmBlank;
   
   /**
	   Constructor
	*/
   
   public ffmPanel()
   {
      // create components
      ffmLabel = new JLabel("Fat Free Mass (kg): ");
      ffmQuan = new JTextField(7);
      ffmBlank = new JLabel("                     ");
      ffmQuan.setEditable(false);
                        
      // set layout
      setLayout(new FlowLayout(FlowLayout.RIGHT, 4, 1));
      
      // add components
      add(ffmLabel);
      add(ffmQuan);
      add(ffmBlank);
   }
}