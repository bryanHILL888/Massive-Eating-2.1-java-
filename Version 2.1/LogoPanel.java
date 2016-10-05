import javax.swing.*;
import java.awt.*;

public class LogoPanel extends JPanel
{	
   // declare variables
	ImageIcon massiveEatingImage;
   private JLabel massiveEatingLogo;

   public LogoPanel()
	{
	// define logo
   massiveEatingImage = new ImageIcon("MassiveEatingLogo2.png");
	massiveEatingLogo = new JLabel(massiveEatingImage);
	
	// add image to logo panel
	add(massiveEatingLogo);				
	}
}