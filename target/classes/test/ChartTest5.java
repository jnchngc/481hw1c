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

import org.jfree.chart.block.EmptyBlock;
import org.jfree.chart.block.BlockBorder;

import org.jfree.chart.labels.StandardCrosshairLabelGenerator;
import org.jfree.chart.ui.RectangleAnchor;
import org.jfree.chart.util.PublicCloneable;


import java.awt.Color;
import java.awt.geom.Rectangle2D;

import org.jfree.chart.ui.RectangleInsets;


/**
* Here we save a legend to a PNG file...the legend has a lot of items, so we
* apply a width constraint so it doesn't get too wide.
*/
public class ChartTest5 {

  

    private static PieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Samsung", new Double(50.0));
        dataset.setValue("Others", new Double(50.0));
        return dataset;
    }

    private static void testEquals() {
        EmptyBlock b1 = new EmptyBlock(1.0, 2.0);
        EmptyBlock b2 = new EmptyBlock(1.0, 2.0);
        b1.equals(b2);
        //assertTrue(b2.equals(b2));

        b1.setID("Test");
        b1.equals(b2);
        b2.setID("Test");
        //assertTrue(b1.equals(b2));

        b1.setMargin(new RectangleInsets(1.0, 2.0, 3.0, 4.0));
        b1.equals(b2);
        b2.setMargin(new RectangleInsets(1.0, 2.0, 3.0, 4.0));
        //assertTrue(b1.equals(b2));

        b1.setFrame(new BlockBorder(Color.RED));
        b1.equals(b2);
        b2.setFrame(new BlockBorder(Color.RED));
        //assertTrue(b1.equals(b2));

        b1.setPadding(new RectangleInsets(2.0, 4.0, 6.0, 8.0));
        b1.equals(b2);
        b2.setPadding(new RectangleInsets(2.0, 4.0, 6.0, 8.0));
        //assertTrue(b1.equals(b2));

        b1.setWidth(1.23);
        b1.equals(b2);
        b2.setWidth(1.23);
        //assertTrue(b1.equals(b2));

        b1.setHeight(4.56);
        b1.equals(b2);
        b2.setHeight(4.56);
        //assertTrue(b1.equals(b2));

        b1.setBounds(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0));
        b1.equals(b2);
        b2.setBounds(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0));
        //assertTrue(b1.equals(b2));

        b1 = new EmptyBlock(1.1, 2.0);
        b1.equals(b2);
        b2 = new EmptyBlock(1.1, 2.0);
        //assertTrue(b1.equals(b2));

        b1 = new EmptyBlock(1.1, 2.2);
        b1.equals(b2);
        b2 = new EmptyBlock(1.1, 2.2);
        b1.equals(b2);
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
