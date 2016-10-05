import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.ComponentOrientation;
import java.text.DecimalFormat;
import java.text.NumberFormat; 
import java.awt.Component.*; 
import java.lang.Object;
import java.util.Locale; 

public class MeansPanel extends JPanel
{
   // declare variables
   public JButton questButton3;
   private JLabel targetBFlbl;
   public JTextField targetBFquan;
   public JButton targetBFbtn;
      
   /**
	   Constructor
	*/
   
   public MeansPanel()
   {
      // create components
      questButton3 = new JButton("?");
      targetBFlbl = new JLabel("Target Bodyfat %: ");
      targetBFquan = new JTextField(7);
      targetBFbtn = new JButton("Enter");
      
      // set layout
      setLayout(new FlowLayout(FlowLayout.RIGHT, 4, 1));
      
      // set border
      setBorder(BorderFactory.createTitledBorder("Means of Change"));
      
      // add components
      add(questButton3);
      add(targetBFlbl);
      add(targetBFquan);
      add(targetBFbtn);
   }
}