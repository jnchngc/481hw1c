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

import java.awt.BasicStroke;
import java.awt.Color;

import java.awt.Font;
import java.awt.GradientPaint;
import java.text.NumberFormat;

import org.jfree.chart.plot.Crosshair;

import org.jfree.chart.labels.StandardCrosshairLabelGenerator;
import org.jfree.chart.ui.RectangleAnchor;
import org.jfree.chart.util.PublicCloneable;


/**
* Here we save a legend to a PNG file...the legend has a lot of items, so we
* apply a width constraint so it doesn't get too wide.
*/
public class ChartTest4 {

  

    private static PieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Samsung", new Double(50.0));
        dataset.setValue("Others", new Double(50.0));
        return dataset;
    }

    private static void testEquals() {

        Crosshair c1 = new Crosshair(1.0, Color.BLUE, new BasicStroke(1.0f));
        Crosshair c2 = new Crosshair(1.0, Color.BLUE, new BasicStroke(1.0f));
        c1.equals(c1);
        c2.equals(c1);

        c1.setVisible(false);
        c1.equals(c2);
        c2.setVisible(false);
        c1.equals(c2);
        /*
        c1.setValue(2.0);
        assertFalse(c1.equals(c2));
        c2.setValue(2.0);
        assertTrue(c1.equals(c2));

        c1.setPaint(Color.RED);
        assertFalse(c1.equals(c2));
        c2.setPaint(Color.RED);
        assertTrue(c1.equals(c2));

        c1.setStroke(new BasicStroke(1.1f));
        assertFalse(c1.equals(c2));
        c2.setStroke(new BasicStroke(1.1f));
        assertTrue(c1.equals(c2));

        c1.setLabelVisible(true);
        assertFalse(c1.equals(c2));
        c2.setLabelVisible(true);
        assertTrue(c1.equals(c2));

        c1.setLabelAnchor(RectangleAnchor.TOP_LEFT);
        assertFalse(c1.equals(c2));
        c2.setLabelAnchor(RectangleAnchor.TOP_LEFT);
        assertTrue(c1.equals(c2));

        c1.setLabelGenerator(new StandardCrosshairLabelGenerator("Value = {0}",
                NumberFormat.getNumberInstance()));
        assertFalse(c1.equals(c2));
        c2.setLabelGenerator(new StandardCrosshairLabelGenerator("Value = {0}",
                NumberFormat.getNumberInstance()));
        assertTrue(c1.equals(c2));

        c1.setLabelXOffset(11);
        assertFalse(c1.equals(c2));
        c2.setLabelXOffset(11);
        assertTrue(c1.equals(c2));

        c1.setLabelYOffset(22);
        assertFalse(c1.equals(c2));
        c2.setLabelYOffset(22);
        assertTrue(c1.equals(c2));

        c1.setLabelFont(new Font("Dialog", Font.PLAIN, 8));
        assertFalse(c1.equals(c2));
        c2.setLabelFont(new Font("Dialog", Font.PLAIN, 8));
        assertTrue(c1.equals(c2));

        c1.setLabelPaint(Color.RED);
        assertFalse(c1.equals(c2));
        c2.setLabelPaint(Color.RED);
        assertTrue(c1.equals(c2));

        c1.setLabelBackgroundPaint(Color.YELLOW);
        assertFalse(c1.equals(c2));
        c2.setLabelBackgroundPaint(Color.YELLOW);
        assertTrue(c1.equals(c2));

        c1.setLabelOutlineVisible(false);
        assertFalse(c1.equals(c2));
        c2.setLabelOutlineVisible(false);
        assertTrue(c1.equals(c2));

        c1.setLabelOutlineStroke(new BasicStroke(2.0f));
        assertFalse(c1.equals(c2));
        c2.setLabelOutlineStroke(new BasicStroke(2.0f));
        assertTrue(c1.equals(c2));

        c1.setLabelOutlinePaint(Color.darkGray);
        assertFalse(c1.equals(c2));
        c2.setLabelOutlinePaint(Color.darkGray);
        assertTrue(c1.equals(c2));
        */
    }

    /**
     * Entry point.
     *
     * @param args  command line arguments (ignored).
     *
     * @throws IOException if there is an input/output problem.
     */
    public static void main(String[] args) throws IOException {


        testEquals();
    }
}
