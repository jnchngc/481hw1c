/* Adapted From 
 * 
 * https://github.com/jfree/jfree-demos/blob/master/src/main/java/org/jfree/chart/demo/PieChartDemo1.java
 *
 * and
 *
 * http://www.jfree.org/phpBB2/viewtopic.php?f=3&t=25969
 */
/* ----------------------------
* LegendTitleToImageDemo2.java
* ----------------------------
* (C) Copyright 2008, by Object Refinery Limited.
*
*/

package test;

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
import org.jfree.chart.plot.IntervalMarker;

import org.jfree.chart.event.MarkerChangeEvent;
import org.jfree.chart.event.MarkerChangeListener;
import org.jfree.chart.ui.GradientPaintTransformType;
import org.jfree.chart.ui.GradientPaintTransformer;
import org.jfree.chart.ui.StandardGradientPaintTransformer;


/**
* Here we save a legend to a PNG file...the legend has a lot of items, so we
* apply a width constraint so it doesn't get too wide.
*/
public class ChartTest3 {
    MarkerChangeEvent lastEvent;

  private static JFreeChart createChart(PieDataset dataset) {

	  JFreeChart chart = ChartFactory.createPieChart(
	      "Smart Phones Manufactured / Q3 2011",  // chart title
	      dataset,            // data
	      false,              // no legend
	      true,               // tooltips
	      false               // no URL generation
	  );

	  return chart;
  }

    private static PieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Samsung", new Double(50.0));
        dataset.setValue("Others", new Double(50.0));
        return dataset;
    }

    public void testSerialization() {
        IntervalMarker m1 = new IntervalMarker(45.0, 50.0);
        IntervalMarker m2 = (IntervalMarker) TestUtils.serialised(m1);
        m1.equals(m2);
    }

    public void testGetSetStartValue() {
        IntervalMarker m = new IntervalMarker(1.0, 2.0);
        m.addChangeListener(this);
        this.lastEvent = null;
        // assertEquals(1.0, m.getStartValue(), EPSILON);
        m.setStartValue(0.5);
        // assertEquals(0.5, m.getStartValue(), EPSILON);
        // assertEquals(m, this.lastEvent.getMarker());
    }

    public void testGetSetEndValue() {
        IntervalMarker m = new IntervalMarker(1.0, 2.0);
        m.addChangeListener(this);
        this.lastEvent = null;
        //assertEquals(2.0, m.getEndValue(), EPSILON);
        m.setEndValue(0.5);
        //assertEquals(0.5, m.getEndValue(), EPSILON);
        //assertEquals(m, this.lastEvent.getMarker());
    }

    /**
     * Entry point.
     *
     * @param args  command line arguments (ignored).
     *
     * @throws IOException if there is an input/output problem.
     */
    public static void main(String[] args) throws IOException {


        /**
     * Confirm that the equals method can distinguish all the required fields.
     */
        IntervalMarker m1 = new IntervalMarker(45.0, 50.0);
        IntervalMarker m2 = new IntervalMarker(45.0, 50.0);
        m1.equals(m2);
        m2.equals(m1);

        m1 = new IntervalMarker(44.0, 50.0);
        m1.equals(m2);
        m2 = new IntervalMarker(44.0, 50.0);
        m1.equals(m2);

        m1 = new IntervalMarker(44.0, 55.0);
        m1.equals(m2);
        m2 = new IntervalMarker(44.0, 55.0);
        m1.equals(m2);

        GradientPaintTransformer t = new StandardGradientPaintTransformer(
                GradientPaintTransformType.HORIZONTAL);
        m1.setGradientPaintTransformer(t);
        m1.equals(m2);
        m2.setGradientPaintTransformer(t);
        m1.equals(m2);

        /**
     * Confirm that cloning works.
     */
        IntervalMarker m3 = new IntervalMarker(45.0, 50.0);
        IntervalMarker m4 = (IntervalMarker) m3.clone();
        boolean bo = (m3 != m4);
        bo = (m3.getClass() == m4.getClass());
        m3.equals(m4);


        testSerialization();
        testGetSetStartValue();
        testGetSetEndValue();




        PieDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset); 


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
                new File("output1.png")));
        ChartUtils.writeBufferedImageAsPNG(out, img2);
        out.close();
        System.out.println("output1.png created"); 
    }
}
