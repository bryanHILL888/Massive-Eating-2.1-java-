import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Component.*;

public class VersionPanel extends JPanel
{
   // declare variables
   public JLabel versionLabel;
     
   /**
	   Constructor
	*/
   
   public VersionPanel()
   {
      // create components
      versionLabel = new JLabel("Version 2.1");
      
      // set layout
      setLayout(new FlowLayout(FlowLayout.CENTER, 4, 1));
      
      // add components
      add(versionLabel);
   }
}