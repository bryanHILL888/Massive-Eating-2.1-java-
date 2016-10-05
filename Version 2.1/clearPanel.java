import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Component.*;

public class clearPanel extends JPanel
{
   // declare variables
   public JButton clearButton;
     
   /**
	   Constructor
	*/
   
   public clearPanel()
   {
      // create components
      clearButton = new JButton("Clear");
      
      // set layout
      setLayout(new FlowLayout(FlowLayout.CENTER, 4, 1));
      
      // add components
      add(clearButton);
   }
}