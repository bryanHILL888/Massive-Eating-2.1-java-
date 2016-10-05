import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.ComponentOrientation;
import java.text.DecimalFormat;
import java.text.NumberFormat; 
import java.awt.Component.*; 
import java.lang.Object;
import java.util.Locale; 

public class ExercisePanel extends JPanel
{
   // declare variables
   private JLabel exerciseLabel;
   public JTextField exerciseQuan;
   private JLabel exerciseSpace;
      
   /**
	   Constructor
	*/
   
   public ExercisePanel()
   {
      // create components
      exerciseLabel = new JLabel("Burn This Many Calories/Day: ");
      exerciseQuan = new JTextField(7);
      exerciseQuan.setEditable(false);
      exerciseSpace = new JLabel("                     ");
      
      // set layout
      setLayout(new FlowLayout(FlowLayout.RIGHT, 4, 1));
      
      // set border
      setBorder(BorderFactory.createTitledBorder("Exercise"));
      
      // add components
      add(exerciseLabel);
      add(exerciseQuan);
      add(exerciseSpace);
   }
}