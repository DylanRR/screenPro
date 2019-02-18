package API;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class screenCapture {
	
	public static BufferedImage screenCap;
	public static Dimension screenSize;
	public static Rectangle captureRect;
	
	/**
	 * Used to grab screen size and set the capture area
	 */
	public static void screenCapProgramInitialization() {
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		captureRect = new Rectangle(0,0, screenSize.width/2, screenSize.height/2);
	}
	
	/**
	 * Sets a screen capture of the pre-defined area utilizing Robot() and stores the image in <code>public static BufferedImage screenCap</code>
	 */
	public static void setScreenCap() {
		try {
			Robot robot = new Robot();
			screenCap = robot.createScreenCapture(captureRect);
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