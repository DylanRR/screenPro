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
	 * Method used for building jFrame/JPanel and displaying screen captures in rapid succession.
	 * (For debugging and or building use corresponding BigDecimals outlined in the code to measure the time from frame to frame.)
	 */
	public static void mainCapture() {
		JPanel panel = new JPanel(); 
		JFrame frame = new JFrame("ScreenCap");
		JLabel label = new JLabel();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BigDecimal start, end, time;
		final BigDecimal bg2 = new BigDecimal(1000000000);	//Consent for nanoTime() to Seconds
		
		for(;;) {
			start = new BigDecimal(System.nanoTime()); //Time Grab for start of capture (Only used for console debugging or FPS counter
			setScreenCap();	//Sets a new bufferedImage using setScreenCap() method
			panel.remove(label);	//Removes past panels
			label = new JLabel(new ImageIcon(screenCap));
			panel.add(label);
		    frame.add(panel);
		    frame.pack();
		    frame.setVisible(true);
		    
		    //The Following shall only be used for console debugging (Possible use in FPS)
		    end = new BigDecimal(System.nanoTime()); //Time grab for end of capture
		    time = end.subtract(start); 
		    System.out.println(time.divide(bg2, 10, RoundingMode.CEILING));
		}
		
	}
	
	public static void main(String[] args) {
		screenCapProgramInitialization();
		mainCapture();
		
	}
}