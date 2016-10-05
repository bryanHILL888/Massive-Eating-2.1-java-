import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.ComponentOrientation;
import java.text.DecimalFormat;
import java.text.NumberFormat; 
import java.awt.Component.*; 
import java.lang.Object;
import java.util.Locale; 

public class ResultsPanel extends JPanel
{
   // declare variables
   ResultsRow1Panel resultsRowOne;
   ResultsRow2Panel resultsRowTwo;
      
   /**
	   Constructor
	*/
   
   public ResultsPanel()
   {
      // create components
      resultsRowOne = new ResultsRow1Panel();
      resultsRowTwo = new ResultsRow2Panel();
      
      // set layout
      setLayout(new BorderLayout());
      
      // set border
      setBorder(BorderFactory.createTitledBorder("Results"));
      
      // add components
      add(resultsRowOne, BorderLayout.NORTH);
      add(resultsRowTwo, BorderLayout.SOUTH);
   }
}