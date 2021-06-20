/*
  Implementation of Dijkstra's algorithm for finding the minimum distance between nodes in a directed weighted graph without negative weights on a single-source shortest path problem (minimal distance from one node to another).

  The Time Complexity of the Dijkstra's algoritm using a priority queue is O(|E|log(|V|)) - remember that the naive Dijkstra's algorithm (searching linearly to find the node with lowest distance) has time complexity O(|V|²)
  
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
    int distance;
    Integer predecessor;

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
    }

    void dijkstra(int s, int f){//s is the starting node and f is the node we want to find the minimum distance to
	for(int i=1;i<=n;i++){
	    nodes[i].distance = Integer.MAX_VALUE;
	    nodes[i].visited = false;
	}
	nodes[s].distance = 0;
	
	TreeSet<NodeQ> set = new TreeSet<>();
	set.add(new NodeQ(0,s));
	while(!set.isEmpty()){
	    //choose_best
	    NodeQ nq = set.pollFirst();// Method that returns the lowest element in the BST (works as a priority queue - operations are O(log(n))
	    int u = nq.node;// Node with the lowest distance
	    nodes[u].visited = true; // Marking current node as visited
	    System.out.println((char) (u-1+'A') + " [dist=" + nodes[u].distance + "]");
	    
	    // Edge relaxation
	    for(Edge e : nodes[u].adj){
		int v = e.to;
		int w = e.weight;
		if(!nodes[v].visited && nodes[u].distance + w < nodes[v].distance){
		    // Removing from TreeSet the key with distance v.dist
		    set.remove(new NodeQ(nodes[v].distance,v));
		    // Updating v.dist
		    nodes[v].distance = nodes[u].distance + w;
		    // Adding back the node v with new distance
		    set.add(new NodeQ(nodes[v].distance,v));
		    // Adding predecessor to node
		    nodes[v].predecessor = u;
		}
	    }
	}
	//Printing path with shortest distance from node s to node f
	System.out.println("Minimum path (from target to origin): ");
	while(true){
	    System.out.println((char) (f-1+'A'));
	    if(nodes[f].predecessor==null) break;
	    f = nodes[f].predecessor;
	}
    }
}

class dijkstra{
    
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);

	Graph g = new Graph(stdin.nextInt());
	int e = stdin.nextInt();
	for (int i=0; i<e; i++) 
	    g.addLink(stdin.nextInt(), stdin.nextInt(), stdin.nextInt());

	// Running Dijkstra's algorithm to find the minimum distance between node 1 and all other nodes
	g.dijkstra(1,4);
    }
}
