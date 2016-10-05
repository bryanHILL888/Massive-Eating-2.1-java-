import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.ComponentOrientation;
import java.text.DecimalFormat;
import java.text.NumberFormat; 
import java.awt.Component.*; 
import java.lang.Object;
import java.util.Locale; 

public class ExCardioPanel extends JPanel
{
   // declare variables
   private JLabel exCBlank;
   private JLabel exCardioLbl;
   public JTextField exCardioQuan;
   public JButton exCardioBtn;
      
   /**
	   Constructor
	*/
   
   public ExCardioPanel()
   {
      // create components
      exCBlank = new JLabel("   ");
      exCardioLbl = new JLabel("Excercise Time for Cardio (hrs): ");
      exCardioQuan = new JTextField(7);
      exCardioBtn = new JButton("Enter");
            
      // set layout
      setLayout(new FlowLayout(FlowLayout.RIGHT, 4, 1));
      
      // add components
      add(exCBlank);
      add(exCardioLbl);
      add(exCardioQuan);
      add(exCardioBtn);
   }
}