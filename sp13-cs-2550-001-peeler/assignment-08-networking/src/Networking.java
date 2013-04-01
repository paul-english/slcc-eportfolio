/**
 * Use a socket connection to allow a client to specify a file name of
 * a text file and have the server send the contents of the file or
 * indicate that the file does not exist. 
 */
import javax.swing.JFrame;

/**
 * @author Paul English
 * 
 */
public class Networking
{

	public static void main(String[] args)
	{

		Thread thread1 = new Thread()
		{

			@Override
			public void run()
			{
				// startup a server
				Server server = new Server();
				server.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				server.waitForPackets();
			}
		};
		Thread thread2 = new Thread()
		{

			@Override
			public void run()
			{
				// startup a client
				Client client = new Client();
				client.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				client.waitForPackets();
			}
		};
		thread1.start();
		thread2.start();

		// allow a client to specify a file
		// TODO if server finds file in resources send the data to the
		// client
		// TODO have the client save the file to it's own directory
	}
}
