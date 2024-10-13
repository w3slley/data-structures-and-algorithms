/*
  Implementation of Dijkstra's algorithm for a undirected weighted graph without negative weights for the problem DAA033
*/
import java.util.*;

class Edge{
    int to;
    double weight;

    Edge(int t, double w){
	this.to = t;
	this.weight = w;
    }
}

class Node{
    LinkedList<Edge> adj;
    boolean visited;
    double distance;

    Node(){
	adj = new LinkedList<>();
    }
}

//class that represents node which will be added to the priority queue
class NodeQ implements Comparable<NodeQ>{
    public double cost;
    public int node;

    NodeQ(double c, int n) {
	this.cost = c;
	this.node = n;
    }

    //method compareTo has to be implemented since objects of this class will be inserted into a TreeSet
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

    void addLink(int a, int b, double w){// On this problem the graph is undirected
	nodes[a].adj.add(new Edge(b,w));
	nodes[b].adj.add(new Edge(a,w));
    }

    void dijkstra(int s, int f){// s is the starting node and f is the node we want to find the minimum distance to
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
	    
	    // Edge relaxation
	    for(Edge e : nodes[u].adj){
		int v = e.to;
		double w = e.weight;
		if(!nodes[v].visited && nodes[u].distance + w < nodes[v].distance){
		    // Removing from TreeSet the key with distance v.dist
		    set.remove(new NodeQ(nodes[v].distance,v));
		    // Updating v.dist
		    nodes[v].distance = nodes[u].distance + w;
		    // Adding back the node v with new distance
		    set.add(new NodeQ(nodes[v].distance,v));
		}
	    }
	}
	System.out.printf("%.1f\n",nodes[f].distance);//printing the minimal distance from node s to node f
    }
}

class DAA033{
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	int numNodes = stdin.nextInt();
	int numEdges = stdin.nextInt();
	Graph graph = new Graph(numNodes);

	TreeMap<String,Integer> map = new TreeMap<>();// Mapping the name of the places to an integer (used in the graph)
	map.put(stdin.next(),1);
	map.put(stdin.next(),2);
	int num = 3;//integer that each string maps to	
	for (int i=0;i<numEdges;i++){
	    String place1 = stdin.next();
	    String place2 = stdin.next();
	    if(map.get(place1) == null) map.put(place1,num++);
	    if(map.get(place2)==null) map.put(place2,num++);
	    graph.addLink(map.get(place1), map.get(place2),stdin.nextDouble());
	}

	graph.dijkstra(1,2);
    }
}
