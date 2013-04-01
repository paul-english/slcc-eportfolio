// Fig. 27.9: Server.java
// Server side of connectionless client/server computing with datagrams.
import java.awt.BorderLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class Server extends JFrame
{

	private final JTextArea displayArea;
	private DatagramSocket socket;

	public Server()
	{
		super("Server");

		this.displayArea = new JTextArea();
		this.add(new JScrollPane(this.displayArea), BorderLayout.CENTER);
		this.setSize(400, 300);
		this.setVisible(true);

		try
		{
			this.socket = new DatagramSocket(5000);
		}
		catch (SocketException socketException)
		{
			socketException.printStackTrace();
			System.exit(1);
		}
	}

	private void displayMessage(final String messageToDisplay)
	{
		SwingUtilities.invokeLater(new Runnable()
		{

			@Override
			public void run()
			{
				Server.this.displayArea.append(messageToDisplay + "\n");
			}
		});
	}

	private void sendFile(File file, InetAddress address, int port)
	{
		try
		{
			byte[] data = new byte[512];
			DatagramPacket sendPacket = new DatagramPacket(data, data.length,
					address, port);
			FileInputStream fis = new FileInputStream(file);

			int a;
			while ((a = fis.read(data, 0, 512)) != -1)
			{
				this.displayMessage(String.valueOf(a));
				sendPacket.setLength(a);

				this.socket.send(sendPacket);
				Thread.sleep(5);
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void sendPacketToClient(DatagramPacket sendPacket)
			throws IOException
	{
		this.socket.send(sendPacket);
		this.displayMessage("Packet sent");
	}

	public void waitForPackets()
	{
		this.displayMessage("server wait");
		while (true)
		{
			try
			{
				byte[] data = new byte[100];
				DatagramPacket receivePacket = new DatagramPacket(data,
						data.length);

				this.socket.receive(receivePacket);

				String filename = "serverFiles"
						+ File.separator
						+ new String(receivePacket.getData(), 0,
								receivePacket.getLength());
				this.displayMessage("getting filename: " + filename);
				File file = new File(filename);
				if (file.exists())
				{
					this.displayMessage("send file");
					byte[] messageData = "NEW_FILE".getBytes();
					DatagramPacket sendPacket = new DatagramPacket(messageData,
							messageData.length, receivePacket.getAddress(),
							receivePacket.getPort());
					this.sendPacketToClient(sendPacket);
					this.sendFile(file, receivePacket.getAddress(),
							receivePacket.getPort());
				}
				else
				{
					this.displayMessage("file not found");
					String error = "404: File not found";
					this.displayMessage(error);

					data = error.getBytes();
					DatagramPacket sendPacket = new DatagramPacket(data,
							data.length, receivePacket.getAddress(),
							receivePacket.getPort());
					this.sendPacketToClient(sendPacket);

				}
			}
			catch (IOException ioException)
			{
				this.displayMessage(ioException.toString());
				ioException.printStackTrace();
			}
		}
	}
}

/**************************************************************************
 * (C) Copyright 1992-2012 by Deitel & Associates, Inc. and *
 * Pearson Education, Inc. All Rights Reserved. *
 * *
 * DISCLAIMER: The authors and publisher of this book have used their *
 * best efforts in preparing the book. These efforts include the *
 * development, research, and testing of the theories and programs *
 * to determine their effectiveness. The authors and publisher make *
 * no warranty of any kind, expressed or implied, with regard to these *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or *
 * consequential damages in connection with, or arising out of, the *
 * furnishing, performance, or use of these programs. *
 *************************************************************************/
