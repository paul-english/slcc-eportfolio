package main;

import java.util.ArrayList;
import java.util.Scanner;

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
