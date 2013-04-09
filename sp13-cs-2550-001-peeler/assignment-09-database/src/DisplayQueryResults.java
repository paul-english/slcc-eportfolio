// Fig. 28.28: DisplayQueryResults.java
// Display the contents of the Authors table in the books database.
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.PatternSyntaxException;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class DisplayQueryResults extends JFrame
{

	static final String ALL_AUTHORS_QUERY = "SELECT * FROM Authors";
	static final String ALL_TITLES_QUERY = "SELECT * FROM Titles";
	static final String AUTHORS_BY_TITLE_QUERY = "SELECT * FROM Authors "
			+ "JOIN AuthorISBN ON Authors.AuthorID=AuthorISBN.AuthorID "
			+ "WHERE AuthorISBN.ISBN='?' "
			+ "ORDER BY Authors.LastName, Authors.FirstName";
	static final String DATABASE_URL = "jdbc:mysql://localhost/books";
	static final String JOIN_EVERYTHING_QUERY = "SELECT Authors.AuthorID, Authors.FirstName, Authors.LastName, "
			+ "Titles.ISBN, Titles.Title, Titles.EditionNumber, Titles.Copyright "
			+ "FROM Authors "
			+ "JOIN AuthorISBN ON Authors.AuthorID = AuthorISBN.AuthorID "
			+ "JOIN Titles ON AuthorISBN.ISBN = Titles.ISBN "
			+ "ORDER BY Authors.LastName, Authors.FirstName";
	static final String PASSWORD = "";
	private static final long serialVersionUID = 1L;
	static final String TITLES_BY_AUTHOR_QUERY = "SELECT * FROM Titles "
			+ "JOIN AuthorISBN ON Titles.ISBN=AuthorISBN.ISBN "
			+ "WHERE AuthorISBN.AuthorID=? " + "ORDER BY Titles.Title";
	static final String USERNAME = "root";

	private JTextArea queryArea;
	private ResultSetTableModel tableModel;

	public DisplayQueryResults()
	{
		super("Displaying Query Results");

		// create ResultSetTableModel and display database table
		try
		{
			// create TableModel for results of query
			this.tableModel = new ResultSetTableModel(
					DisplayQueryResults.DATABASE_URL,
					DisplayQueryResults.USERNAME, DisplayQueryResults.PASSWORD,
					DisplayQueryResults.ALL_AUTHORS_QUERY);

			// set up JTextArea in which user types queries
			this.queryArea = new JTextArea(
					DisplayQueryResults.ALL_AUTHORS_QUERY, 3, 100);
			this.queryArea.setWrapStyleWord(true);
			this.queryArea.setLineWrap(true);

			JScrollPane scrollPane = new JScrollPane(this.queryArea,
					ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
					ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

			// set up JButton for submitting queries
			JButton submitButton = new JButton("Submit Query");

			final JComboBox<String> authorsBox = new JComboBox<>();
			authorsBox.setVisible(false);

			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(
					DisplayQueryResults.DATABASE_URL,
					DisplayQueryResults.USERNAME, DisplayQueryResults.PASSWORD);
			final ArrayList<String> authorNames = new ArrayList<String>();
			final HashMap<String, String> authorNameIds = new HashMap<>();
			Statement stm = connection.createStatement();
			ResultSet rs = stm
					.executeQuery(DisplayQueryResults.ALL_AUTHORS_QUERY);
			while (rs.next())
			{
				String authorName = rs.getString("LastName") + ", "
						+ rs.getString("FirstName");
				authorNames.add(authorName);
				authorNameIds.put(authorName, rs.getString("AuthorID"));
			}
			rs.close();

			// Populate the combo box
			String[] strArr = {};
			DefaultComboBoxModel<String> authorsModel = new DefaultComboBoxModel<>(
					authorNames.toArray(strArr));
			authorsBox.setModel(authorsModel);

			authorsBox.addItemListener(new ItemListener()
			{

				@Override
				public void itemStateChanged(ItemEvent e)
				{
					try
					{
						int i = authorsBox.getSelectedIndex();
						String authorName = authorNames.get(i);
						String authorID = authorNameIds.get(authorName);
						String query = DisplayQueryResults.TITLES_BY_AUTHOR_QUERY
								.replace("?", authorID);
						DisplayQueryResults.this.tableModel.setQuery(query);
						DisplayQueryResults.this.queryArea.setText(query);
					}
					catch (IllegalStateException e1)
					{
						e1.printStackTrace();
					}
					catch (SQLException e1)
					{
						e1.printStackTrace();
					}
				}

			});

			final JComboBox<String> titlesBox = new JComboBox<>();
			titlesBox.setVisible(false);

			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					DisplayQueryResults.DATABASE_URL,
					DisplayQueryResults.USERNAME, DisplayQueryResults.PASSWORD);
			final ArrayList<String> titleNames = new ArrayList<>();
			final HashMap<String, String> titleNameIDs = new HashMap<>();
			stm = connection.createStatement();
			rs = stm.executeQuery(DisplayQueryResults.ALL_TITLES_QUERY);
			while (rs.next())
			{
				String titleName = rs.getString("Title");
				titleNames.add(titleName);
				titleNameIDs.put(titleName, rs.getString("ISBN"));
			}
			rs.close();

			// Populate the combo box
			DefaultComboBoxModel<String> titlesModel = new DefaultComboBoxModel<>(
					titleNames.toArray(strArr));
			titlesBox.setModel(titlesModel);
			titlesBox.addItemListener(new ItemListener()
			{

				@Override
				public void itemStateChanged(ItemEvent e)
				{
					try
					{
						int i = titlesBox.getSelectedIndex();
						String titleName = titleNames.get(i);
						String titleID = titleNameIDs.get(titleName);
						String query = DisplayQueryResults.AUTHORS_BY_TITLE_QUERY
								.replace("?", titleID);
						DisplayQueryResults.this.tableModel.setQuery(query);
						DisplayQueryResults.this.queryArea.setText(query);
					}
					catch (IllegalStateException e1)
					{
						e1.printStackTrace();
					}
					catch (SQLException e1)
					{
						e1.printStackTrace();
					}
				}

			});

			String[] names =
			{ "All Authors", "By Author", "By Title", "Join Everyting" };
			final JComboBox<String> comboBox = new JComboBox<>(names);
			comboBox.addItemListener(new ItemListener()
			{

				@Override
				public void itemStateChanged(ItemEvent event)
				{
					if (event.getStateChange() == ItemEvent.SELECTED)
					{
						try
						{
							int selectedIndex = comboBox.getSelectedIndex();
							if (selectedIndex == 0)
							{
								DisplayQueryResults.this.tableModel
										.setQuery(DisplayQueryResults.ALL_AUTHORS_QUERY);
								DisplayQueryResults.this.queryArea
										.setText(DisplayQueryResults.ALL_AUTHORS_QUERY);
								authorsBox.setVisible(false);
								titlesBox.setVisible(false);
							}
							else if (selectedIndex == 1)
							{
								String authorsQuery = DisplayQueryResults.TITLES_BY_AUTHOR_QUERY
										.replace("?", authorNameIds
												.get(authorNames.get(0)));
								DisplayQueryResults.this.tableModel
										.setQuery(authorsQuery);
								DisplayQueryResults.this.queryArea
										.setText(authorsQuery);
								authorsBox.setVisible(true);
								titlesBox.setVisible(false);
							}
							else if (selectedIndex == 2)
							{
								String titlesQuery = DisplayQueryResults.AUTHORS_BY_TITLE_QUERY
										.replace("?", titleNameIDs
												.get(titleNames.get(0)));
								DisplayQueryResults.this.tableModel
										.setQuery(titlesQuery);
								DisplayQueryResults.this.queryArea
										.setText(titlesQuery);
								authorsBox.setVisible(false);
								titlesBox.setVisible(true);
							}
							else if (selectedIndex == 3)
							{
								DisplayQueryResults.this.tableModel
										.setQuery(DisplayQueryResults.JOIN_EVERYTHING_QUERY);
								DisplayQueryResults.this.queryArea
										.setText(DisplayQueryResults.JOIN_EVERYTHING_QUERY);
								authorsBox.setVisible(false);
								titlesBox.setVisible(false);
							}
						}
						catch (IllegalStateException | SQLException e)
						{
							e.printStackTrace();
						}

					}
				}
			});

			// create Box to manage placement of queryArea and
			// submitButton in GUI
			Box queryBox = Box.createHorizontalBox();
			queryBox.add(scrollPane);
			queryBox.add(submitButton);

			Box boxNorth = Box.createVerticalBox();
			boxNorth.add(comboBox);
			boxNorth.add(authorsBox);
			boxNorth.add(titlesBox);
			boxNorth.add(queryBox);

			// create JTable based on the tableModel
			JTable resultTable = new JTable(this.tableModel);

			JLabel filterLabel = new JLabel("Filter:");
			final JTextField filterText = new JTextField();
			JButton filterButton = new JButton("Apply Filter");
			Box boxSouth = Box.createHorizontalBox();

			boxSouth.add(filterLabel);
			boxSouth.add(filterText);
			boxSouth.add(filterButton);

			// place GUI components on content pane
			this.add(boxNorth, BorderLayout.NORTH);
			this.add(new JScrollPane(resultTable), BorderLayout.CENTER);
			this.add(boxSouth, BorderLayout.SOUTH);

			// create event listener for submitButton
			submitButton.addActionListener(

			new ActionListener()
			{

				// pass query to table model
				@Override
				public void actionPerformed(ActionEvent event)
				{
					// perform a new query
					try
					{
						DisplayQueryResults.this.tableModel
								.setQuery(DisplayQueryResults.this.queryArea
										.getText());
					}
					catch (SQLException sqlException)
					{
						JOptionPane.showMessageDialog(null,
								sqlException.getMessage(), "Database error",
								JOptionPane.ERROR_MESSAGE);

						// try to recover from invalid user query
						// by executing default query
						try
						{
							DisplayQueryResults.this.tableModel
									.setQuery(DisplayQueryResults.ALL_AUTHORS_QUERY);
							DisplayQueryResults.this.queryArea
									.setText(DisplayQueryResults.ALL_AUTHORS_QUERY);
						}
						catch (SQLException sqlException2)
						{
							JOptionPane.showMessageDialog(null,
									sqlException2.getMessage(),
									"Database error", JOptionPane.ERROR_MESSAGE);

							// ensure database connection is closed
							DisplayQueryResults.this.tableModel
									.disconnectFromDatabase();

							System.exit(1); // terminate application
						}
					}
				}
			});

			final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(
					this.tableModel);
			resultTable.setRowSorter(sorter);
			this.setSize(500, 250); // set window size
			this.setVisible(true); // display window

			// create listener for filterButton
			filterButton.addActionListener(new ActionListener()
			{

				// pass filter text to listener
				@Override
				public void actionPerformed(ActionEvent e)
				{
					String text = filterText.getText();

					if (text.length() == 0)
					{
						sorter.setRowFilter(null);
					}
					else
					{
						try
						{
							sorter.setRowFilter(RowFilter.regexFilter(text));
						}
						catch (PatternSyntaxException pse)
						{
							JOptionPane.showMessageDialog(null,
									"Bad regex pattern", "Bad regex pattern",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			});
		}
		catch (SQLException sqlException)
		{
			JOptionPane.showMessageDialog(null, sqlException.getMessage(),
					"Database error", JOptionPane.ERROR_MESSAGE);

			// ensure database connection is closed
			this.tableModel.disconnectFromDatabase();

			System.exit(1); // terminate application
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}

		// dispose of window when user quits application (this overrides
		// the default of HIDE_ON_CLOSE)
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		// ensure database connection is closed when user quits application
		this.addWindowListener(

		new WindowAdapter()
		{

			// disconnect from database and exit when window has closed
			@Override
			public void windowClosed(WindowEvent event)
			{
				DisplayQueryResults.this.tableModel.disconnectFromDatabase();
				System.exit(0);
			}

		});
	}

	// execute application
	public static void main(String args[])
	{
		new DisplayQueryResults();
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
