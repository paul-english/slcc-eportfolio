/**
 * Project : Applet
 * File : RectangleExample.java
 * Name : Paul English
 * Date : Mar 6, 2013
 * 
 * Description :
 * 
 * (Drawing Rectangles) Write an applet that draws rectangles of different sizes
 * and locations.
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JApplet;
import javax.swing.Timer;

/**
 * @author Paul English
 * 
 */
public class RectangleExample extends JApplet implements ActionListener
{

	private static final long serialVersionUID = 1L;
	private final int delay = 120;
	private final int height = 300;
	private final Random r = new Random( );
	private final int width = 450;

	/*
	 * (non-Javadoc)
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed( ActionEvent e )
	{
		this.repaint( );

	}

	@Override
	public void init( )
	{
		this.setBackground( Color.GRAY );
		this.setSize( this.width, this.height );

		Timer timer = new Timer( this.delay, this );
	}

	@Override
	public void paint( Graphics g )
	{
		super.paint( g );

		int i = 20;
		while ( i > 0 )
		{
			Color c = new Color( this.r.nextInt( 255 ), this.r.nextInt( 255 ),
					this.r.nextInt( 255 ), this.r.nextInt( 255 ) );
			g.setColor( c );
			int x = this.r.nextInt( this.width );
			int y = this.r.nextInt( this.height );
			g.fillRect( x, y, this.r.nextInt( this.width - x ),
					this.r.nextInt( this.height - y ) );
			i--;
		}

	}

	@Override
	public void stop( )
	{
	}

}
