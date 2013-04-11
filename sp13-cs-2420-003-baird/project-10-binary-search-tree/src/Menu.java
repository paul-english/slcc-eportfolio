import java.util.ArrayList;
import java.util.Scanner;

/**
 * Project : Binary Search Tree
 * File : Menu.java
 * Name : Paul English
 * Date : April 11, 2013
 * 
 * Description :
 * 
 * Implement a student list as a binary search tree (BST) with natural ordering
 * defined as last name, first name.
 * 
 * Specification
 * 
 * 1) Each Student record should have the following fields:
 * - studentNumber:Integer
 * - lastname:String
 * - firstName:String
 * - major:String
 * - gpa:Double
 * 2) Run the program from an appropriate menu allowing for the following
 * operations:
 * - Adding a Student record
 * - Deleting a Student record
 * - Listing students by:
 * -- All students
 * -- A given major
 * -- GPA above a certain value
 * -- GPA below a certain value
 * 3) Automatically load the Student records from secondary storage each time
 * the program runs.
 * 4) Automatically save the Student records before the program ends.
 * 5) Use a custom Visitor object to write the Student records.
 */
/**
 * 
 * @author nrub
 */
public class Menu
{

	/**
	 *
	 */
	public static abstract class Option
	{

		abstract void action(Scanner input);
	}

	private class OptionPair
	{

		private final Option option;
		private final String text;

		public OptionPair(String text, Option opt)
		{
			this.text = text;
			this.option = opt;
		}

		public Option getOption()
		{
			return this.option;
		}

		public String getText()
		{
			return this.text;
		}
	}

	private final Scanner input = new Scanner(System.in);

	private final String menuHeader;

	private final ArrayList<OptionPair> options = new ArrayList<>();

	public Menu()
	{
		this("Choose your action below");
	}

	public Menu(String header)
	{
		this.menuHeader = header;
		this.input.useDelimiter(System.getProperty("line.separator"));
	}

	/**
	 * 
	 * @param optionText
	 * @param opt
	 */
	public void addOption(String optionText, Option opt)
	{
		this.options.add(new OptionPair(optionText, opt));
	}

	/**
	 *
	 */
	public void display()
	{
		System.out.println("");
		System.out
				.println("--------------------------------------------------");
		System.out.println(this.menuHeader);
		for (int i = 0; i < this.options.size(); i++)
		{
			System.out.println("  " + (i + 1) + ": "
					+ this.options.get(i).getText());
		}

		System.out.print("> ");
		int selection = this.input.nextInt() - 1;

		if (selection >= this.options.size())
		{
			System.out.println("Invalid selection");
		}
		else
		{
			Option option = this.options.get(selection).getOption();
			System.out.println("");
			option.action(this.input);
		}

	}
}
