import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;

/**
 * 15.18 (Screen Saver) Write an application that simulates a screen
 * saver. The application should randomly draw lines using method
 * drawLine of class Graphics. After drawing 100 lines, the application
 * should clear itself and start drawing lines again. To allow the
 * program to draw continuously, place a call to repaint as the last
 * line in method paintComponent. Do you notice any problems with this
 * on your system?
 * 
 * 15.19 (Screen Saver Using Timer) Package javax.swing contains a class
 * called Timer that is capable of calling method actionPerformed of
 * interface ActionListener at a fixed time interval (specified in
 * milliseconds). Modify your solution to Exercise 15.18 to remove the
 * call to repaint from method paintComponent. Declare your class to
 * implement ActionListener. (The actionPerformed method should simply
 * call repaint.) Declare an instance variable of type Timer called
 * timer in your class. In the constructor for your class, write the
 * following statements:
 * 
 * <pre>
 * timer = new Timer( 1000, this );
 * timer.start( );
 * </pre>
 * 
 * This creates an instance of class Timer that will call this object's
 * actionPerformed method every 1000 milliseconds (i.e., every second).
 * 
 * @author nrub
 */
public class ScreenSaver
{

	/**
	 * @param args
	 */
	public static void main( String[ ] args )
	{
		JFrame frame = new JFrame( "Screensaver" );
		RandomLinePanel screenSaver = new RandomLinePanel( );

		// Exclusive full screen
		GraphicsEnvironment env = GraphicsEnvironment
				.getLocalGraphicsEnvironment( );
		GraphicsDevice device = env.getDefaultScreenDevice( );
		device.setFullScreenWindow( frame );

		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.add( screenSaver );

		// Somehow setVisible(false) makes the JPanel capture mouse movement,
		// without having to click first.
		frame.setVisible( false );
		frame.setVisible( true );
	}

}
