package genericsinglelinkedlist;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nrub
 */
public class Menu
{

	private ArrayList<OptionPair> options = new ArrayList<>();
	private Scanner input = new Scanner(System.in);

	/**
	 *
	 */
	public static abstract class Option
	{

		abstract void action(Scanner input);
	}

	private class OptionPair
	{

		private String text;
		private Option option;

		public OptionPair(String text, Option opt)
		{
			this.text = text;
			this.option = opt;
		}

		public String getText()
		{
			return text;
		}

		public Option getOption()
		{
			return option;
		}
	}

	/**
	 *
	 * @param optionText
	 * @param opt
	 */
	public void addOption(String optionText, Option opt)
	{
		options.add(new OptionPair(optionText, opt));
	}

	/**
	 *
	 */
	public void display()
	{
		System.out.println("");
		System.out.println("--------------------------------------------------");
		System.out.println("Choose your action below");
		for (int i = 0; i < options.size(); i++)
		{
			System.out.println("  " + (i + 1) + ": " + options.get(i).getText());
		}

		System.out.print("> ");
		int selection = input.nextInt() - 1;

		if (selection >= options.size())
		{
			System.out.println("Invalid selection");
		}
		else
		{
			Option option = options.get(selection).getOption();
			System.out.println("");
			option.action(input);
		}

	}
}
