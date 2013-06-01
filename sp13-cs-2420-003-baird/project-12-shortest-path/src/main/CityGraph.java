package main;

import gray.adts.graph.Vertex;
import gray.adts.graph.WeightedAdjMatrixGraph;
import gray.adts.priorityqueue.HeapPriorityQueue;
import gray.misc.Tuple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CityGraph
{

	private Vertex<String>[] cities;
	private WeightedAdjMatrixGraph<String> connectionGraph;
	private WeightedAdjMatrixGraph<String> graph;
	private final HeapPriorityQueue<Vertex<String>> plainQueue = new HeapPriorityQueue<Vertex<String>>(
			new Comparator<Vertex<String>>()
			{

				@Override
				public int compare(Vertex<String> o1, Vertex<String> o2)
				{
					return 0;
				}
			});
	private final HeapPriorityQueue<Tuple<Vertex<String>, Double>> queue = new HeapPriorityQueue<Tuple<Vertex<String>, Double>>(
			new Comparator<Tuple<Vertex<String>, Double>>()
			{

				@Override
				public int compare(Tuple<Vertex<String>, Double> city1,
						Tuple<Vertex<String>, Double> city2)
				{
					return (int) (city1.getSecondElement() - city2
							.getSecondElement());
				}
			});

	private void clearVisited()
	{
		for (Vertex<String> city : this.cities)
		{
			city.setVisited(false);
		}
	}

	public void loadCities()
	{
		// This should load up the required cities into our graph
		this.cities = new Vertex[14];

		this.cities[0] = new Vertex<String>("SEA");
		this.cities[1] = new Vertex<String>("SFR");
		this.cities[2] = new Vertex<String>("LA");
		this.cities[3] = new Vertex<String>("LV");
		this.cities[4] = new Vertex<String>("PHO");
		this.cities[5] = new Vertex<String>("OKC");
		this.cities[6] = new Vertex<String>("DAL");
		this.cities[7] = new Vertex<String>("MIN");
		this.cities[8] = new Vertex<String>("MIL");
		this.cities[9] = new Vertex<String>("CHI");
		this.cities[10] = new Vertex<String>("NOR");
		this.cities[11] = new Vertex<String>("NYC");
		this.cities[12] = new Vertex<String>("WDC");
		this.cities[13] = new Vertex<String>("MIA");

		this.graph = new WeightedAdjMatrixGraph<>();

		for (Vertex<String> city : this.cities)
		{
			this.graph.addVertex(city);
		}

		this.graph.addEdge(this.cities[0], 808, this.cities[1]);
		this.graph.addEdge(this.cities[0], 2060, this.cities[9]);
		this.graph.addEdge(this.cities[1], 414, this.cities[2]);
		this.graph.addEdge(this.cities[1], 2257, this.cities[8]);
		this.graph.addEdge(this.cities[2], 272, this.cities[3]);
		this.graph.addEdge(this.cities[2], 1440, this.cities[6]);
		this.graph.addEdge(this.cities[3], 1780, this.cities[9]);
		this.graph.addEdge(this.cities[4], 1771, this.cities[8]);
		this.graph.addEdge(this.cities[5], 792, this.cities[7]);
		this.graph.addEdge(this.cities[6], 949, this.cities[7]);
		this.graph.addEdge(this.cities[6], 571, this.cities[10]);
		this.graph.addEdge(this.cities[6], 1614, this.cities[11]);
		this.graph.addEdge(this.cities[7], 1217, this.cities[11]);
		this.graph.addEdge(this.cities[8], 811, this.cities[12]);
		this.graph.addEdge(this.cities[9], 948, this.cities[10]);
		this.graph.addEdge(this.cities[9], 1423, this.cities[13]);
		this.graph.addEdge(this.cities[11], 237, this.cities[12]);

		this.connectionGraph = new WeightedAdjMatrixGraph();
		for (Vertex<String> city : this.cities)
		{
			this.connectionGraph.addVertex(city);
		}
		this.connectionGraph.addEdge(this.cities[0], this.cities[1]);
		this.connectionGraph.addEdge(this.cities[0], this.cities[9]);
		this.connectionGraph.addEdge(this.cities[1], this.cities[2]);
		this.connectionGraph.addEdge(this.cities[1], this.cities[8]);
		this.connectionGraph.addEdge(this.cities[2], this.cities[3]);
		this.connectionGraph.addEdge(this.cities[2], this.cities[6]);
		this.connectionGraph.addEdge(this.cities[3], this.cities[9]);
		this.connectionGraph.addEdge(this.cities[4], this.cities[8]);
		this.connectionGraph.addEdge(this.cities[5], this.cities[7]);
		this.connectionGraph.addEdge(this.cities[6], this.cities[7]);
		this.connectionGraph.addEdge(this.cities[6], this.cities[10]);
		this.connectionGraph.addEdge(this.cities[6], this.cities[11]);
		this.connectionGraph.addEdge(this.cities[7], this.cities[11]);
		this.connectionGraph.addEdge(this.cities[8], this.cities[12]);
		this.connectionGraph.addEdge(this.cities[9], this.cities[10]);
		this.connectionGraph.addEdge(this.cities[9], this.cities[13]);
		this.connectionGraph.addEdge(this.cities[11], this.cities[12]);

	}

	public void printAdjacencyMatrix()
	{
		System.out.print("    ");
		for (Vertex<String> city : this.cities)
		{
			System.out.printf(" %4s", city);
		}
		System.out.print("\n");

		for (Vertex<String> city : this.cities)
		{
			System.out.printf("%4s", city);
			for (Vertex<String> neighbor : this.cities)
			{
				System.out.printf(" %4.0f",
						this.graph.getEdgeWeight(city, neighbor));
			}
			System.out.print("\n");
		}
	}

	/**
	 * 
	 * @param selection
	 */
	public void printBreadthFirstTraversal(int selection)
	{
		Vertex<String> city = this.cities[selection - 1];
		System.out.print("\n");
		this.printBreadthFirstTraversal(city);

	}

	public void printBreadthFirstTraversal(Vertex<String> city)
	{
		this.clearVisited();
		city.setVisited(true);
		this.plainQueue.enqueue(city);
		while (!this.plainQueue.isEmpty())
		{
			Vertex<String> nextCity = this.plainQueue.dequeue();
			System.out.print(" -> " + nextCity);
			List<Vertex<String>> neighbors = this.graph.getNeighbors(nextCity);
			for (Vertex<String> neighbor : neighbors)
			{
				if (!neighbor.isVisited())
				{
					this.plainQueue.enqueue(neighbor);
					neighbor.setVisited(true);
				}
			}
		}
	}

	public void printCities()
	{
		for (int i = 0; i < this.cities.length; i++)
		{
			System.out.println((i + 1) + ": " + this.cities[i]);
		}
	}

	/**
	 * To show connecting cites for each city on the map, show the city and each
	 * connected (adjacent) city and mileage to that city.
	 */
	public void printConnections()
	{
		for (int i = 0; i < this.cities.length; i++)
		{
			Vertex<String> city = this.cities[i];
			System.out.print("\n" + (i + 1) + ": " + city + ":");

			List<Vertex<String>> neighbors = this.graph.getNeighbors(city);
			for (Vertex<String> neighbor : neighbors)
			{
				System.out.print(" -> " + neighbor);
			}
		}
	}

	/**
	 * 
	 * @param selection
	 */
	public void printDepthFirstTraversal(int selection)
	{
		this.clearVisited();
		System.out.print("\n");
		this.printDepthFirstTraversal(this.cities[selection - 1]);
	}

	public void printDepthFirstTraversal(Vertex<String> v)
	{
		System.out.print(" -> " + v);
		v.setVisited(true);
		List<Vertex<String>> neighbors = this.graph.getNeighbors(v);
		for (Vertex<String> neighbor : neighbors)
		{
			if (!neighbor.isVisited())
			{
				this.printDepthFirstTraversal(neighbor);
			}
		}
	}

	/**
	 * For shortest path connections, show the fewest number of connections on
	 * the path from the source city to the destination city.
	 * 
	 * @param start
	 * @param end
	 */
	public void printShortestConnectionPath(int start, int end)
	{
		Vertex<String> src = this.cities[start - 1];
		Vertex<String> dest = this.cities[end - 1];
		Tuple<ArrayList<Vertex<String>>, Double> path = this.connectionGraph
				.minimalPath(src, dest);
		System.out.println(path);
	}

	/**
	 * For shortest path distance, show the shortest distance and the connecting
	 * cities on the path from the source city to the destination city.
	 * 
	 * @param start
	 * @param end
	 */
	public void printShortestDistancePath(int start, int end)
	{
		Vertex<String> src = this.cities[start - 1];
		Vertex<String> dest = this.cities[end - 1];
		Tuple<ArrayList<Vertex<String>>, Double> path = this.graph.minimalPath(
				src, dest);
		System.out.println(path);
	}
}
