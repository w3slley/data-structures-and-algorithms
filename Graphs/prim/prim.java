/*
  Implementation of Prim's algorithm for finding Minimum Spamming Trees (MST) on undirected and weighted graphs. A MST is a sub-set of edges in the graph that connects all the vertices together, without any cycles and with the minimum possible total edge weight. In a sense, Prim's algorithm is really simmilar to Dijkstra's Algorithm for finding the minimum distance between nodes of a weighted and directed graph.

  The Time Complexity of Prim's algoritm using a priority queue is O(|E|log(|V|)) - remember that the naive version of the algorithm (searching linearly to find the node with lowest distance) has time complexity O(|V|²)
  
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
    boolean visited;
    int cost;

    Node(){
	adj = new LinkedList<>();
	predecessor = null;
    }
}

//class that represents node which will be added to the priority queue
class NodeQ implements Comparable<NodeQ>{
    public int cost;
    public int node;

    NodeQ(int c, int n) {
	this.cost = c;
	this.node = n;
    }

    //method compareTo has to be implemented since objects of this class will be inserted into a TreeSet
    @Override
    public int compareTo(NodeQ nq) { 
        if (cost < nq.cost) return -1; 
        if (cost > nq.cost) return +1;
	if (node < nq.node) return -1; 
	if (node > nq.node) return +1;
        return 0; 
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
	nodes[b].adj.add(new Edge(a,w));
    }

    void prim(int r){//r is the root node that starts prim's algorithm
	for(int i=1;i<=n;i++){
	    nodes[i].cost = Integer.MAX_VALUE;
	    nodes[i].visited = false;
	}
	nodes[r].cost = 0;
	
	TreeSet<NodeQ> set = new TreeSet<>();
	set.add(new NodeQ(0,r));
	int totalCost = 0;
	while(!set.isEmpty()){
	    //choose_best
	    NodeQ nq = set.pollFirst();// Method that returns the lowest element in the BST (works as a priority queue - operations are O(log(n))
	    int u = nq.node;// Node with the lowest cost
	    nodes[u].visited = true; // Marking current node as visited
	    char letter = (char) (u - 1 + 'a');
	    System.out.println(letter + " [cost=" + nodes[u].cost + "]");
	    totalCost+=nodes[u].cost;
	    
	    // Edge relaxation
	    for(Edge e : nodes[u].adj){
		int v = e.to;
		int w = e.weight;
		if(!nodes[v].visited && w < nodes[v].cost){
		    // Removing from TreeSet the key with distance v.cost
		    set.remove(new NodeQ(nodes[v].cost,v));
		    // Updating v.dist
		    nodes[v].cost = w;
		    // Adding back the node v with new distance
		    set.add(new NodeQ(nodes[v].cost,v));
		}
	    }
	}
	System.out.printf("total cost: %d \n",totalCost);
    }
}

class prim{
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);

	Graph g = new Graph(stdin.nextInt());
	int e = stdin.nextInt();
	for (int i=0; i<e; i++) 
	    g.addLink(stdin.nextInt(), stdin.nextInt(), stdin.nextInt());

	// Running Prim's algorithm starting on the first node of the graph
	g.prim(1);
    }
}
