/**
 * Problem. Write a program that maintains a list of items using a generic
 * single-linked list as the backing store.
 *
 * Specification. 1. Use the SinglyLinkedList<E> class provided in the text. 2.
 * The type of item stored in the list can be any item of your choice: pets,
 * books, coins, friends, etc. (You'll need to write the class representing the
 * item). 3. Run the program from a menu with the following options: * Add an
 * item. * Delete an item. * Find an item. * Display the list. * Exit 4. When
 * the program runs, programatically create 5 items and add them to the list
 * before the menu is displayed.
 */
package genericsinglelinkedlist;

import java.util.Scanner;

/**
 *
 * @author nrub
 */
public class GenericSingleLinkedList
{

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args)
	{
		final SinglyLinkedList<Rock> list = new SinglyLinkedList<>();
		list.add(new Rock("igneous"));
		list.add(new Rock("sedimentary"));
		list.add(new Rock("metamorphic"));
		list.add(new Rock("candy"));
		list.add(new Rock("band"));

		Menu menu = new Menu();
		menu.addOption("Add an item.", new Menu.Option()
		{
			@Override
			void action(Scanner input)
			{
				System.out.println("What classification of rock would you like to add?");
				String classification = input.next();
				Rock rock = new Rock(classification);
				list.add(rock);
				System.out.println("Rock added.");
			}
		});
		menu.addOption("Delete an item.", new Menu.Option()
		{
			@Override
			void action(Scanner input)
			{
				System.out.println("Enter the index for the item you wish to delete.");
				int index = input.nextInt();
				Rock deleted = list.remove(index);
				System.out.println(deleted + " deleted.");
			}
		});
		menu.addOption("Find an item.", new Menu.Option()
		{
			@Override
			void action(Scanner input)
			{
				System.out.println("Enter the index for the item you want to find.");
				int index = input.nextInt();
				Rock rock = list.getElementAt(index);
				System.out.println("Rock: " + rock);
			}
		});
		menu.addOption("Display the list", new Menu.Option()
		{
			@Override
			void action(Scanner input)
			{
				for (int i = 0; i < list.getLength(); i++)
				{
					System.out.println("- Item at " + i + ": " + list.getElementAt(i));
				}
			}
		});
		menu.addOption("Exit", new Menu.Option()
		{
			@Override
			void action(Scanner input)
			{
				System.out.println("Exiting...");
				System.exit(1);
			}
		});

		while (true)
		{
			menu.display();
		}

	}
}
