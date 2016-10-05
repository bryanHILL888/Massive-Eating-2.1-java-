import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.ComponentOrientation;
import java.text.DecimalFormat;
import java.text.NumberFormat; 
import java.awt.Component.*; 
import java.lang.Object;
import java.util.Locale; 

public class WeightLossPanel extends JPanel
{
   // declare variables
   MeansPanel meansPanel;
   DietPanel dietPanel;
   ExercisePanel exercisePanel;
   ResultsPanel resultsPanel;
       
   /**
	   Constructor
	*/
   
   public WeightLossPanel()
   {
      // create components
      meansPanel = new MeansPanel();
      dietPanel = new DietPanel();
      exercisePanel = new ExercisePanel();
      resultsPanel = new ResultsPanel();
      
      // set layout
      setLayout(new GridLayout(4,1));
      
      // add components
      add(meansPanel);
      add(dietPanel);
      add(exercisePanel);
      add(resultsPanel);
   } 
}