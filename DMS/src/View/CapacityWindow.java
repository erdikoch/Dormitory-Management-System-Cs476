package view;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
 
public class CapacityWindow extends ApplicationFrame 
{
   public CapacityWindow( String title ) 
   {
      super( title ); 
      setContentPane(createDemoPanel( ));
   }
   
   //will be implemented (i will add counter function later)
   private static PieDataset createDataset( ) 
   {
      DefaultPieDataset dataset = new DefaultPieDataset( );
      dataset.setValue( "Students" , new Double( 20 ) );  // after student Addititon will be changed
      dataset.setValue( "Employees" , new Double( 20 ) );   
      dataset.setValue( "Teachers" , new Double( 40 ) );    
      dataset.setValue("Dorm Empty Spaces",new Double( 20 ));
      return dataset;         
   }
   private static JFreeChart createChart( PieDataset dataset )
   {
      JFreeChart chart = ChartFactory.createPieChart(      
         "Dorm Capacity",  // chart title 
         dataset,        // data    
         true,           // include legend   
         true, 
         false);

      return chart;
   }
   public static JPanel createDemoPanel( )
   {
      JFreeChart chart = createChart(createDataset( ) );  
      return new ChartPanel( chart ); 
   }
  
}
