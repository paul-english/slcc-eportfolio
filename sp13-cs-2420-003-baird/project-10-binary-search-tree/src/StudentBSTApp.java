import java.util.Scanner;

/**
 * Project : Binary Search Tree
 * File : StudentBSTApp.java
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

public class StudentBSTApp
{

	private static StudentBST studentTree;

	private static Menu buildListMenu()
	{
		Menu listMenu = new Menu("How would you like to list students?");
		listMenu.addOption("All Students", new Menu.Option()
		{

			@Override
			void action(Scanner input)
			{
				StudentBSTApp.studentTree.printAllStudents();
			}
		});
		listMenu.addOption("By Major", new Menu.Option()
		{

			@Override
			void action(Scanner input)
			{
				System.out.print("Major: ");
				String major = input.next();
				StudentBSTApp.studentTree.printStudentsByMajor(major);
			}
		});
		listMenu.addOption("By GPA greater than", new Menu.Option()
		{

			@Override
			void action(Scanner input)
			{
				System.out.println("GPA: ");
				double gpa = input.nextDouble();
				StudentBSTApp.studentTree.printStudentsByGPA(gpa);
			}
		});
		listMenu.addOption("By GPA less than", new Menu.Option()
		{

			@Override
			void action(Scanner input)
			{
				System.out.println("GPA: ");
				double gpa = input.nextDouble();
				StudentBSTApp.studentTree.printStudentsByGPA(gpa, true);
			}
		});
		return listMenu;
	}

	private static Menu buildMainMenu()
	{
		Menu menu = new Menu();
		menu.addOption("Add a Student record", new Menu.Option()
		{

			@Override
			void action(Scanner input)
			{
				System.out.print("Student Number: ");
				int studentNumber = input.nextInt();
				System.out.print("First Name: ");
				String firstName = input.next();
				System.out.print("Last Name: ");
				String lastName = input.next();
				System.out.print("Major: ");
				String major = input.next();
				System.out.print("GPA: ");
				double gpa = input.nextDouble();

				Student student = new Student(firstName, lastName, major, gpa,
						studentNumber);
				System.out.println("--- " + student);
				System.out.println("--- " + StudentBSTApp.studentTree);
				StudentBSTApp.studentTree.add(student);
			}

		});
		menu.addOption("Delete a Student record", new Menu.Option()
		{

			@Override
			void action(Scanner input)
			{
				System.out
						.print("Please enter the student number of the student you would like to remove: ");
				int studentNumber = input.nextInt();
				StudentBSTApp.studentTree.remove(studentNumber);
			}
		});
		menu.addOption("List Students", new Menu.Option()
		{

			@Override
			void action(Scanner input)
			{
				Menu listMenu = StudentBSTApp.buildListMenu();

				listMenu.display();
			}
		});
		menu.addOption("Exit", new Menu.Option()
		{

			@Override
			void action(Scanner input)
			{
				System.out.println("exit?");
				StudentBSTApp.studentTree.saveStudentCollection();
				System.out.println("Exiting...");
				System.exit(1);
			}
		});
		return menu;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		StudentBSTApp.studentTree = StudentBST.loadStudentCollection();
		Menu menu = StudentBSTApp.buildMainMenu();
		while (true)
		{
			menu.display();
		}
	}
}
