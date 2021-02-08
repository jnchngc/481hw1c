package test;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 

import java.awt.Color;
import java.awt.Font;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Point;
import java.awt.RadialGradientPaint;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.jfree.chart.block.RectangleConstraint;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.chart.ui.HorizontalAlignment;
import org.jfree.chart.ui.RectangleEdge;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.chart.ui.UIUtils;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.Range;


public class BarChart_AWT {
   
   private static JFreeChart createChart( String applicationTitle , String chartTitle, CategoryDataset dataset ) {        
      JFreeChart barChart = ChartFactory.createBarChart(
         chartTitle,           
         "Category",            
         "Score",            
         dataset,          
         PlotOrientation.VERTICAL,           
         true, true, false);
      
         return barChart;      
   }
   private static CategoryDataset createDataset( ) {
      final String fiat = "FIAT";        
      final String audi = "AUDI";        
      final String ford = "FORD";        
      final String speed = "Speed";        
      final String millage = "Millage";        
      final String userrating = "User Rating";        
      final String safety = "safety";        
      final DefaultCategoryDataset dataset = 
      new DefaultCategoryDataset( );  

      dataset.addValue( 1.0 , fiat , speed );        
      dataset.addValue( 3.0 , fiat , userrating );        
      dataset.addValue( 5.0 , fiat , millage ); 
      dataset.addValue( 5.0 , fiat , safety );           

      dataset.addValue( 5.0 , audi , speed );        
      dataset.addValue( 6.0 , audi , userrating );       
      dataset.addValue( 10.0 , audi , millage );        
      dataset.addValue( 4.0 , audi , safety );

      dataset.addValue( 4.0 , ford , speed );        
      dataset.addValue( 2.0 , ford , userrating );        
      dataset.addValue( 3.0 , ford , millage );        
      dataset.addValue( 6.0 , ford , safety ); 
      
      dataset.setValue(48.35, "row 1", "column key 1");
      dataset.setValue(null, "row 2", "column key 12");
      dataset.incrementValue(4.0, "row 1", "column key 1");
      dataset.addValue(100, "row 3", "col 3");
      dataset.removeValue("row 3", "col 3");



      return dataset; 
   }
   public static void main( String[ ] args ) {
      CategoryDataset dataset = createDataset();
      JFreeChart chart = createChart("Car Usage Statistics", "Which car do you like?", dataset);

      // we need to layout the legend to know how much space it requires
      // note that it is also possible to call arrange() with some
      // constraints on the layout
      BufferedImage img = new BufferedImage(1, 1,
      BufferedImage.TYPE_INT_ARGB);
      Graphics2D g2 = img.createGraphics();
      g2.dispose();

      // now create an image of the required size for the legend
      int w = (int) Math.rint(800);
      int h = (int) Math.rint(600);
      BufferedImage img2 = new BufferedImage(w, h,
            BufferedImage.TYPE_INT_ARGB);
      Graphics2D g22 = img2.createGraphics();
      chart.draw(g22, new Rectangle2D.Double(0, 0, w, h));
      g22.dispose();

      // ...and save it to a PNG image
      OutputStream out = new BufferedOutputStream(new FileOutputStream(
            new File("output3.png")));
      ChartUtils.writeBufferedImageAsPNG(out, img2);
      out.close();
      System.out.println("output3.png created"); 

   }
}