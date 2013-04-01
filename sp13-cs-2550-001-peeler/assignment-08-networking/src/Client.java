// Fig. 27.11: Client.java
// Client side of connectionless client/server computing with datagrams.
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Client extends JFrame
{

	private final JTextArea displayArea;
	private final JTextField enterField;
	private String filename;
	private DatagramSocket socket;

	public Client()
	{
		super("Client");

		this.enterField = new JTextField("Enter filename here");
		this.enterField.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent event)
			{
				try
				{
					Client.this.filename = event.getActionCommand();
					Client.this.displayArea
							.append("\nSending packet containing: "
									+ Client.this.filename + "\n");

					byte[] data = Client.this.filename.getBytes();

					DatagramPacket sendPacket = new DatagramPacket(data,
							data.length, InetAddress.getLocalHost(), 5000);

					Client.this.socket.send(sendPacket);
					Client.this.displayMessage("Requesting file");
				}
				catch (IOException ioException)
				{
					Client.this.displayMessage(ioException.toString());
					ioException.printStackTrace();
				}
			}
		});

		this.add(this.enterField, BorderLayout.NORTH);

		this.displayArea = new JTextArea();
		this.add(new JScrollPane(this.displayArea), BorderLayout.CENTER);

		this.setSize(400, 300);
		this.setLocation(0, 300);
		this.setVisible(true);

		try
		{
			this.socket = new DatagramSocket();
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
				Client.this.displayArea.append(messageToDisplay + "\n");
			}
		});
	}

	public void waitForFile()
	{
		this.displayMessage("waitForFile");
		FileOutputStream fos;
		try
		{
			fos = new FileOutputStream(new File("clientFiles" + File.separator
					+ this.filename));
			while (true)
			{
				byte[] data = new byte[512]; // set up packet

				DatagramPacket receivePacket = new DatagramPacket(data,
						data.length);

				this.socket.receive(receivePacket);
				if (receivePacket.getLength() == 512)
				{
					fos.write(receivePacket.getData());
				}
				else
				{
					this.displayMessage("File received");
					fos.write(receivePacket.getData(),
							receivePacket.getOffset(),
							receivePacket.getLength());
					break;
				}
			}
			fos.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void waitForPackets()
	{
		this.displayMessage("client wait");
		while (true)
		{
			try
			{
				byte[] data = new byte[512]; // set up packet

				DatagramPacket receivePacket = new DatagramPacket(data,
						data.length);
				this.socket.receive(receivePacket);
				String textData = new String(receivePacket.getData(), 0,
						receivePacket.getLength());
				if (textData.equals("NEW_FILE"))
				{
					this.waitForFile();
				}
				else
				{
					this.displayMessage(textData);
				}
			}
			catch (IOException e)
			{
				e.printStackTrace();
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
