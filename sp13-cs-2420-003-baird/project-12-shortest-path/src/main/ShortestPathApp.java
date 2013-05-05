package main;

import java.util.Scanner;

/**
 * Problem
 * 
 * Write a program that determines the shortest distance between any two
 * connected cities on the map below.
 * 
 * Specifications
 * 
 * 1. Run the program from a menu that includes the following options:
 * a. Show Connecting Cities
 * b. Depth-first Traversal
 * c. Breadth-first Traversal
 * d. Shortest Path - Connections
 * e. Shortest Path - Distance
 * f. Adjacency Matrix
 * g. Exit
 * 2. To show connecting cites for each city on the map, show the city and each
 * connected (adjacent) city and mileage to that city.
 * 3. For shortest path connections, show the fewest number of connections on
 * the path from the source city to the destination city.
 * 4. For shortest path distance, show the shortest distance and the connecting
 * cities on the path from the source city to the destination city.
 * 5. Use an adjacency matrix to solve the problem given the following table of
 * distances
 * 
 * @author nrub
 * 
 */
public class ShortestPathApp
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Menu mainMenu = new Menu("--[ Shortest Path Application ]--");
		final CityGraph graph = new CityGraph();
		graph.loadCities();

		mainMenu.addOption("Show Connecting Cities", new Menu.Option()
		{

			@Override
			void action(Scanner input)
			{
				graph.printConnections();
			}
		});
		mainMenu.addOption("Depth-first Traversal", new Menu.Option()
		{

			@Override
			void action(Scanner input)
			{
				graph.printCities();
				System.out
						.print("Which city would you like to start the traversal from? ");
				int selection = input.nextInt();
				graph.printDepthFirstTraversal(selection);
			}
		});
		mainMenu.addOption("Breadth-first Traversal", new Menu.Option()
		{

			@Override
			void action(Scanner input)
			{
				graph.printCities();
				System.out
						.print("Which city would you like to start the traversal from? ");
				int selection = input.nextInt();
				graph.printBreadthFirstTraversal(selection);
			}
		});
		mainMenu.addOption("Shortest Path - Connections", new Menu.Option()
		{

			@Override
			void action(Scanner input)
			{
				graph.printCities();
				System.out.print("Starting city: ");
				int start = input.nextInt();
				System.out.print("Ending city: ");
				int end = input.nextInt();
				graph.printShortestConnectionPath(start, end);
			}
		});
		mainMenu.addOption("Shortest Path - Distance", new Menu.Option()
		{

			@Override
			void action(Scanner input)
			{
				graph.printCities();
				System.out.print("Starting city: ");
				int start = input.nextInt();
				System.out.print("Ending city: ");
				int end = input.nextInt();
				graph.printShortestDistancePath(start, end);
			}
		});
		mainMenu.addOption("Adjacency Matrix", new Menu.Option()
		{

			@Override
			void action(Scanner input)
			{
				graph.printAdjacencyMatrix();
			}
		});
		mainMenu.addOption("Exit", new Menu.Option()
		{

			@Override
			void action(Scanner input)
			{
				System.out.println("Goodbye!");
				System.exit(0);
			}
		});

		while (true)
		{
			mainMenu.display();
		}
	}
}
