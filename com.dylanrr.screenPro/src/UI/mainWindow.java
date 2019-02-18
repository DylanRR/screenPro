package UI;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import API.screenCapture;

public class mainWindow {

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
			screenCapture.setScreenCap();	//Sets a new bufferedImage using setScreenCap() method
			panel.remove(label);	//Removes past panels
			label = new JLabel(new ImageIcon(screenCapture.getScreenCap()));
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
		screenCapture.screenCapProgramInitialization();
		mainCapture();
		
	}
}
