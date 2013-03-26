import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * Project : Concurrency
 * File : Concurrency.java
 * Name : Paul English
 * Date : Mar 13, 2013
 * 
 * Description :
 * 
 * (Bouncing Ball) Write a program that bounces a blue ball inside a JPanel. The
 * ball should begin moving with a mousePressed event. When the ball hits the
 * edge of the JPanel, it should bounce off the edge and continue in the
 * opposite direction. The ball should be updated using a Runnable.
 */

/**
 * @author Paul English
 * 
 */
public class Concurrency
{

	private static Bouncer bouncer;
	private static int delay = 10;
	private static ExecutorService executor;
	private static int height = 400;
	private static Timer timer;
	private static int width = 600;

	/**
	 * @param args
	 */
	public static void main( String[ ] args )
	{
		JFrame frame = new JFrame( "Concurrent Bouncing Ball" );
		Concurrency.bouncer = new Bouncer( );

		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.add( Concurrency.bouncer.getBall( ) );
		frame.setSize( Concurrency.width, Concurrency.height );

		frame.setVisible( true );
		frame.addMouseListener( new MouseAdapter( )
		{
			@Override
			public void mouseClicked( MouseEvent e )
			{
				System.out.println( "click" );
				Concurrency.timer.start( );
			}
		} );

		Concurrency.executor = Executors.newCachedThreadPool( );
		Concurrency.timer = new Timer( Concurrency.delay, new ActionListener( )
		{

			@Override
			public void actionPerformed( ActionEvent e )
			{
				Concurrency.executor.execute( Concurrency.bouncer );
			}

		} );
	}

}
