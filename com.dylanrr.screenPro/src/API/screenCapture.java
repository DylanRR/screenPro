package API;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.List;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class screenCapture {
	
	public static BufferedImage screenCap;
	public static Dimension screenSize;
	public static Rectangle captureRect;
	public static ArrayList<Integer> colorMatch = new ArrayList<Integer>();
	public static ArrayList<Integer> bar1Look = new ArrayList<Integer>();
	public static ArrayList<Integer> bar2Look = new ArrayList<Integer>();
	public static ArrayList<Integer> bar3Look = new ArrayList<Integer>();
	public static ArrayList<Integer> bar4Look = new ArrayList<Integer>();
	public static ArrayList<Integer> bar1LookMarker = new ArrayList<Integer>();
	public static ArrayList<Integer> bar2LookMarker = new ArrayList<Integer>();
	public static ArrayList<Integer> bar3LookMarker = new ArrayList<Integer>();
	public static ArrayList<Integer> bar4LookMarker = new ArrayList<Integer>();
	/**
	 * Used to grab screen size and set the capture area
	 */
	public static void screenCapProgramInitialization() {
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		captureRect = new Rectangle(0,0, screenSize.width/2, screenSize.height/2);
		setColorThreshold();
		setLookThreshold();
	}
	
	public static void setColorThreshold() {
		int lowestR, highestR, lowestG, highestG, lowestB, highestB;
		lowestR = 250; highestR = 255; lowestG = 250; highestG = 255; lowestB = 250; highestB = 255;
		for(int x=lowestR; x <= highestR; x++)
			for(int y=lowestG; y <= highestG; y++)
				for(int z=lowestB; z <= highestB; z++) {
					int match = new Color(x, y, z).getRGB();
					colorMatch.add(match);
				}
	    
	}
	
	public static void setLookThreshold() {
		int bar1x1, bar1x2, bar1y1, bar1y2;
		bar1x1 = 145; bar1y1 = 115; bar1x2 = 190; bar1y2 = 185;
		for(int x=bar1x1; x <= bar1x2; x++)
			for(int y=bar1y1; y <= bar1y2; y++) {
				bar1Look.add(x);
				bar1Look.add(y);
			}
		int bar2x1, bar2x2, bar2y1, bar2y2;
		bar2x1 = 195; bar2y1 = 115; bar2x2 = 240; bar2y2 = 185;
		for(int x=bar2x1; x <= bar2x2; x++)
			for(int y=bar2y1; y <= bar2y2; y++) {
				bar2Look.add(x);
				bar2Look.add(y);
			}
		int bar3x1, bar3x2, bar3y1, bar3y2;
		bar3x1 = 245; bar3y1 = 115; bar3x2 = 280; bar3y2 = 185;
		for(int x=bar3x1; x <= bar3x2; x++)
			for(int y=bar3y1; y <= bar3y2; y++) {
				bar3Look.add(x);
				bar3Look.add(y);
			}
		int bar4x1, bar4x2, bar4y1, bar4y2;
		bar4x1 = 245; bar4y1 = 115; bar4x2 = 280; bar4y2 = 185;
		for(int x=bar4x1; x <= bar4x2; x++)
			for(int y=bar4y1; y <= bar4y2; y++) {
				bar4Look.add(x);
				bar4Look.add(y);
			}
	}
	
	public static void setLookThresholdMarker() {
		int bar1x1, bar1x2, bar1y1, bar1y2;
		bar1x1 = 145; bar1y1 = 115; bar1x2 = 190; bar1y2 = 185;
		for(int x=bar1x1; x <= bar1x2; x++)
			for(int y=bar1y1; y <= bar1y2; y++) {
				bar1LookMarker.add(x);
				bar1LookMarker.add(y);
			}
		int bar2x1, bar2x2, bar2y1, bar2y2;
		bar2x1 = 195; bar2y1 = 115; bar2x2 = 240; bar2y2 = 185;
		for(int x=bar2x1; x <= bar2x2; x++)
			for(int y=bar2y1; y <= bar2y2; y++) {
				bar2LookMarker.add(x);
				bar2LookMarker.add(y);
			}
		int bar3x1, bar3x2, bar3y1, bar3y2;
		bar3x1 = 245; bar3y1 = 115; bar3x2 = 280; bar3y2 = 185;
		for(int x=bar3x1; x <= bar3x2; x++)
			for(int y=bar3y1; y <= bar3y2; y++) {
				bar3LookMarker.add(x);
				bar3LookMarker.add(y);
			}
		int bar4x1, bar4x2, bar4y1, bar4y2;
		bar4x1 = 245; bar4y1 = 115; bar4x2 = 280; bar4y2 = 185;
		for(int x=bar4x1; x <= bar4x2; x++)
			for(int y=bar4y1; y <= bar4y2; y++) {
				bar4LookMarker.add(x);
				bar4LookMarker.add(y);
			}
	}
	
	public static int getCompareBar1() {
		int count = 0;
		for(int a=0, b=1; b<bar1Look.size(); a=a+2, b=b+2) {
			int x = bar1Look.get(a), y=bar1Look.get(b);
			for(int c=0; c<colorMatch.size(); c++) {
				final int grab = screenCap.getRGB(x, y);
				if(grab == colorMatch.get(c))
					count++;
			}
		}
		return count;
	}
	
	public static int getCompareBar2() {
		int count = 0;
		for(int a=0, b=1; b<bar2Look.size(); a=a+2, b=b+2) {
			int x = bar2Look.get(a), y=bar2Look.get(b);
			for(int c=0; c<colorMatch.size(); c++) {
				final int grab = screenCap.getRGB(x, y);
				if(grab == colorMatch.get(c))
					count++;
			}
		}
		return count;
	}
	
	public static int getCompareBar3() {
		int count = 0;
		for(int a=0, b=1; b<bar3Look.size(); a=a+2, b=b+2) {
			int x = bar3Look.get(a), y=bar3Look.get(b);
			for(int c=0; c<colorMatch.size(); c++) {
				final int grab = screenCap.getRGB(x, y);
				if(grab == colorMatch.get(c))
					count++;
			}
		}
		return count;
	}
	
	public static int getCompareBar4() {
		int count = 0;
		for(int a=0, b=1; b<bar4Look.size(); a=a+2, b=b+2) {
			int x = bar4Look.get(a), y=bar4Look.get(b);
			for(int c=0; c<colorMatch.size(); c++) {
				final int grab = screenCap.getRGB(x, y);
				if(grab == colorMatch.get(c))
					count++;
			}
		}
		return count;
	}
	
	public static int compareBars() {
		int bar1 = getCompareBar1();
		int bar2 = getCompareBar2();
		int bar3 = getCompareBar3();
		int bar4 = getCompareBar4();
		if(bar1 < bar2 && bar1 < bar3 && bar1 < bar4) {
			System.out.println("Bar 1");
			return 1; }
		else if(bar2 < bar1 && bar2 < bar3 && bar2 < bar4) {
			System.out.println("Bar 2");
			return 2; }
		else if(bar3 < bar1 && bar3 < bar2 && bar3 < bar4) {
			System.out.println("Bar 3");
			return 3; }
		else if(bar4 < bar1 && bar4 < bar2 && bar4 < bar3) {
			System.out.println("Bar 4");
			return 4; }
		else
			return 0;
	}
	
	public static void marker() {
		int compareBars = compareBars();
		int R=244; int G=238; int B=66;
	int rgb = 65536 * R + 256 * G + B;
		if (compareBars == 1) {
			for(int a=0, b=1; b<bar1LookMarker.size(); a=a+2, b=b+2) {
				int x = bar1LookMarker.get(a), y=bar1LookMarker.get(b);
				screenCap.setRGB(x, y, rgb);
				System.out.println("bar 1");
			}
		}
		else if (compareBars == 2) {
			for(int a=0, b=1; b<bar2LookMarker.size(); a=a+2, b=b+2) {
				int x = bar2LookMarker.get(a), y=bar2LookMarker.get(b);
				screenCap.setRGB(x, y, rgb);
				System.out.println("bar 2");
			}

		}
		else if (compareBars == 3) {
			for(int a=0, b=1; b<bar3LookMarker.size(); a=a+2, b=b+2) {
				int x = bar3LookMarker.get(a), y=bar3LookMarker.get(b);
				screenCap.setRGB(x, y, rgb);
				System.out.println("bar 3");
			}
		}
		else if (compareBars == 4) {
			for(int a=0, b=1; b<bar4LookMarker.size(); a=a+2, b=b+2) {
				int x = bar4LookMarker.get(a), y=bar4LookMarker.get(b);
				screenCap.setRGB(x, y, rgb);
				System.out.println("bar 4");
			}

		}
	}
	/**
	 * Sets a screen capture of the pre-defined area utilizing Robot() and stores the image in <code>public static BufferedImage screenCap</code>
	 */
	public static void setScreenCap() {
		try {
			Robot robot = new Robot();
			screenCap = robot.createScreenCapture(captureRect);
			marker();
		}
		catch (AWTException ex) {
            System.err.println(ex);
        }
	}
	
	/**
	 * Get method for <code>BufferedImage screenCap</code>
	 * @return BufferedImage screenCap
	 */
	public static BufferedImage getScreenCap() {
		return screenCap;
	}
	
	/**
	 * Get method for <code>Dimension screenSize</code>
	 * @return Dimension screenSize
	 */
	public static Dimension getScreenSize() {
		return screenSize;
	}
	
	/**
	 * Get method for <code>Rectangle captureRect</code>
	 * @return Rectangle captureRect
	 */
	public static Rectangle getCaptureRect() {
		return captureRect;
	}
	
	
}