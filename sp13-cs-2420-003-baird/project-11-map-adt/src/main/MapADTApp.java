package main;

/**
 * Situation
 *
 * The software development company you work for has recently been awarded a 
 * contract to create an accounts receivable management system for a local law 
 * firm. As a member of the development team, you have been tasked to write the 
 * engine that will drive the system. You've decided to write a prototype 
 * application to test the feasibility of using an implementation of the Map ADT 
 * as the foundation for the engine.
 *
 * You can use a simple AccountRecord class you remember from your days at SLCC in 
 * your prototype (an account record provided by the law firm will be used in the 
 * delivered product). The account number and an instance of the AccountRecord will 
 * serve nicely as the key-value pair to be stored in the map. You also determine to 
 * take advantage of the memory management, searching, and balancing features of an 
 * AVL tree as the backing store for your map.
 *
 * If all goes well and your concept proves viable, you'll be looking at a quick 
 * promotion and a really big raise from your boss.
 *
 * Specification
 *
 * 1. Create class AVLMap that implements Gray's Map interface and uses the 
 * implementation of Gray's AVLTree as the backing store.
 * 2. Use class Entry<K, V> from Gray's Map package to store key-value pairs in 
 * the AVL tree. K and V will represent the account number and account record 
 * respectively.
 * 3. Order the entries in the AVL tree by the key (account number) in the 
 * key-value entry.
 * 4. Create a test application to validate your prototype that allows for adding, 
 * searching, removing and editing account records.
 */

import java.util.Scanner;

public class MapADTApp
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		final AVLMap<Integer, AccountRecordSerializable> map = new AVLMap<>();
		Menu menu = new Menu();
		menu.addOption("Add a new account", new Menu.Option()
		{

			@Override
			void action(Scanner input)
			{
				System.out.println("Adding a new account");
				AccountRecordSerializable account = new AccountRecordSerializable();
				System.out.print("Account #: ");
				account.setAccount(input.nextInt());
				System.out.print("First Name: ");
				account.setFirstName(input.next());
				System.out.print("Last Name: ");
				account.setLastName(input.next());
				System.out.print("Balance: ");
				account.setBalance(input.nextDouble());
				AccountRecordSerializable old = map.put(account.getAccount(),
						account);
				if (old != null)
				{
					System.out.println("Replaced old account: " + old);
				}
				else
				{
					System.out.println("Added new account: " + account);
				}
			}
		});
		menu.addOption("Search for an account", new Menu.Option()
		{

			@Override
			void action(Scanner input)
			{
				System.out.println("Searching for an account");
				System.out.print("Account #: ");
				int accountNumber = input.nextInt();
				AccountRecordSerializable account = map.get(accountNumber);
				if (account != null)
				{
					System.out.println(account);
				}
				else
				{
					System.out.println("Account not found!");
				}
			}
		});
		menu.addOption("Remove an account", new Menu.Option()
		{

			@Override
			void action(Scanner input)
			{
				System.out.println("Deleting an account");
				System.out.print("Account #: ");
				int accountNumber = input.nextInt();
				AccountRecordSerializable account = map.remove(accountNumber);
				if (account != null)
				{
					System.out.println("Deleted: " + account);
				}
				else
				{
					System.out.println("Account not found to delete!");
				}
			}
		});
		menu.addOption("Exit", new Menu.Option()
		{

			@Override
			void action(Scanner input)
			{
				System.exit(0);
			}
		});

		while (true)
		{
			menu.display();
		}
	}

}
