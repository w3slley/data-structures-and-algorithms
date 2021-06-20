/*
  Implementation of Bellman-Ford's algorithm for finding the minimum distance between nodes in a directed weighted graph with negative weights on a single-source shortest path problem (minimal distance from one node to another).

  Time Complexity of the Bellman-Ford's algoritm: O(|V||E|)
 */

import java.util.*;

class Edge{
    int to;
    int weight;

    Edge(int t, int w){
	this.to = t;
	this.weight = w;
    }
}

class Node{
    LinkedList<Edge> adj;
    int distance;

    Node(){
	adj = new LinkedList<>();
    }
}

class Graph{
    int n;
    Node[] nodes;

    Graph(int n){
	this.n = n;
	nodes = new Node[n+1];
	for(int i=1;i<=n;i++)
	    nodes[i] = new Node();
    }

    void addLink(int a, int b, int w){
	nodes[a].adj.add(new Edge(b,w));
    }

    void bellmanFord(int s){
	for(int i=1;i<=n;i++)
	    nodes[i].distance = Integer.MAX_VALUE; // Setting all distance on all nodes to Infinity

	nodes[s].distance = 0;// Setting origin node distance to 0
	    
	for(int i=1;i<n;i++){// O(|V|) Doing edge relaxation |V|-1 times
	    for(int u=1;u<=n;u++){// O(|E|) Doing edge relaxation on all the edges in the graph
		for(Edge e : nodes[u].adj){
		    int v = e.to;
		    int w = e.weight;
		    if(nodes[u].distance + w < nodes[v].distance){
			nodes[v].distance = nodes[u].distance + w;
		    }
		}
	    }
	}
	// Looping through all the nodes and printing their distance from the origin node s!
	for(int u=1;u<=n;u++)
	    System.out.println(u + " [dist=" + nodes[u].distance + "]");
	//If one wants to find if there are negative cycles in the graph, you just need to do edge relaxation on the edges of the graph one more time: if any distance in a node changes, then there is a cycle. If not, there isn't
	boolean negativeCycle = false;
	for(int u=1;u<=n;u++){
	    for(Edge e : nodes[u].adj){
		int v = e.to;
		int w = e.weight;
		if(nodes[u].distance + w < nodes[v].distance)
		    negativeCycle = true;
	    }
	}
	System.out.println(negativeCycle?"Found a negative cycle!":"Graph doesn't have a negative cycle!");

    }
}

class bellmanFord{
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	Graph g = new Graph(stdin.nextInt());
	int e = stdin.nextInt();
	for (int i=0; i<e; i++) 
	    g.addLink(stdin.nextInt(), stdin.nextInt(), stdin.nextInt());

	g.bellmanFord(1);
    }
}
