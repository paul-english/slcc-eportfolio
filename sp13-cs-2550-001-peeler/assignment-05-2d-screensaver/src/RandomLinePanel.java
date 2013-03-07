import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @author nrub
 * 
 */
public class RandomLinePanel extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private Random r = new Random( );
	private ArrayList< ScreenSaverLine > lines = new ArrayList<>( );
	private int width;
	private int height;
	private Timer timer;
	private int delay = 120;
	private int numLines = 100;

	private class ScreenSaverLine
	{
		private Color c;
		private int x1;
		private int x2;
		private int y1;
		private int y2;

		public ScreenSaverLine( )
		{
			this.setColor( new Color( r.nextInt( 255 ) + 1,
					r.nextInt( 255 ) + 1, r.nextInt( 255 ) + 1 ) );
			this.setX1( r.nextInt( width ) + 1 );
			this.setY1( r.nextInt( height ) + 1 );
			this.setX2( r.nextInt( width ) + 1 );
			this.setY2( r.nextInt( height ) + 1 );
		}

		public Color getColor( )
		{
			return c;
		}

		public void setColor( Color c )
		{
			this.c = c;
		}

		public int getX1( )
		{
			return x1;
		}

		public void setX1( int x1 )
		{
			this.x1 = x1;
		}

		public int getX2( )
		{
			return x2;
		}

		public void setX2( int x2 )
		{
			this.x2 = x2;
		}

		public int getY1( )
		{
			return y1;
		}

		public void setY1( int y1 )
		{
			this.y1 = y1;
		}

		public int getY2( )
		{
			return y2;
		}

		public void setY2( int y2 )
		{
			this.y2 = y2;
		}
	}

	public RandomLinePanel( )
	{
		super( );
		setup( );
	}

	public RandomLinePanel( boolean isDoubleBuffered )
	{
		super( isDoubleBuffered );
		setup( );
	}

	public RandomLinePanel( LayoutManager layout, boolean isDoubleBuffered )
	{
		super( layout, isDoubleBuffered );
		setup( );
	}

	public RandomLinePanel( LayoutManager layout )
	{
		super( layout );
		setup( );
	}

	private void setup( )
	{
		timer = new Timer( delay, this );
		timer.start( );
		this.addMouseMotionListener( new MouseAdapter( )
		{
			@Override
			public void mouseMoved( MouseEvent e )
			{
				System.exit( 0 );
			}
		} );
	}

	public void paintComponent( Graphics g )
	{
		super.paintComponent( g );
		width = this.getWidth( );
		height = this.getHeight( );

		this.setBackground( new Color( 60, 60, 60 ) );

		lines.add( new ScreenSaverLine( ) );

		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint( RenderingHints.KEY_ANTIALIASING, // Anti-alias!
				RenderingHints.VALUE_ANTIALIAS_ON );

		for ( ScreenSaverLine line : lines )
		{
			g.setColor( line.getColor( ) );
			g.drawLine( line.getX1( ), line.getY1( ), line.getX2( ),
					line.getY2( ) );
		}

		if ( lines.size( ) == numLines )
		{
			lines.clear( );
		}

	}

	@Override
	public void actionPerformed( ActionEvent e )
	{
		repaint( );
	}

}
