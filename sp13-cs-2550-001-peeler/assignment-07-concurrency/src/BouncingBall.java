import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

/**
 * Project : Concurrency
 * File : BouncingBall.java
 * Name : Paul English
 * Date : Mar 13, 2013
 * 
 * Description :
 * 
 * TODO
 */

/**
 * @author Paul English
 * 
 */
public class BouncingBall extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7261477245010427332L;

	private final int diameter = 50;
	private final int speed = 3;
	private int x = 0;
	private int xSpeed = this.speed;
	private int y = 0;
	private int ySpeed = this.speed;

	public boolean hitBottomWall( )
	{
		return ( ( this.y + this.diameter ) >= this.getHeight( ) );

	}

	public boolean hitLeftWall( )
	{
		return ( this.x <= 0 );
	}

	public boolean hitRightWall( )
	{
		return ( ( this.x + this.diameter ) >= this.getWidth( ) );
	}

	public boolean hitTopWall( )
	{
		return ( this.y <= 0 );
	}

	@Override
	public void paintComponent( Graphics g )
	{
		super.paintComponent( g );
		g.setColor( Color.BLUE );
		g.fillOval( this.x, this.y, this.diameter, this.diameter );

		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint( RenderingHints.KEY_ANTIALIASING, // Anti-alias!
				RenderingHints.VALUE_ANTIALIAS_ON );
	}

	public synchronized void step( )
	{
		if ( this.hitLeftWall( ) )
		{
			this.xSpeed = this.speed;
		}
		else if ( this.hitRightWall( ) )
		{
			this.xSpeed = -this.speed;
		}

		this.x += this.xSpeed;

		if ( this.hitTopWall( ) )
		{
			this.ySpeed = this.speed;
		}
		else if ( this.hitBottomWall( ) )
		{
			this.ySpeed = -this.speed;
		}

		this.y += this.ySpeed;
		this.repaint( );
	}
}
