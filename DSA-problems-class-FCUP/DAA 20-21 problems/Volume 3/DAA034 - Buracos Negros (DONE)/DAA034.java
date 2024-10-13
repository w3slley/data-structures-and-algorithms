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
	for(int i=1;i<=n;i++) nodes[i].distance = Integer.MAX_VALUE/2; // Setting all distance on all nodes to Infinity
	nodes[s].distance = 0;// Setting origin node distance to 0
	for(int i=1;i<n;i++)// O(|V|) Doing edge relaxation |V|-1 times
	    for(int u=1;u<=n;u++)// O(|E|) Doing edge relaxation on all the edges in the graph
		for(Edge e : nodes[u].adj){
		    int v = e.to;
		    int w = e.weight;
		    if(nodes[u].distance + w < nodes[v].distance) nodes[v].distance = nodes[u].distance + w;
		}
	
	boolean negativeCycle = false;
	for(int u=1;u<=n;u++)
	    for(Edge e : nodes[u].adj){
		int v = e.to;
		int w = e.weight;
		if(nodes[u].distance + w < nodes[v].distance) negativeCycle = true;
	    }
	System.out.println(negativeCycle?"possivel":"impossivel");
    }
}

    class DAA034{
	public static void main(String[] args){
	    Scanner stdin = new Scanner(System.in);
	    int t = stdin.nextInt();
	    while(t-->0){
		int n = stdin.nextInt();
		int m = stdin.nextInt();
		Graph graph = new Graph(n);
		for (int i=0; i<m; i++) 
		    graph.addLink(stdin.nextInt()+1, stdin.nextInt()+1, stdin.nextInt());
		graph.bellmanFord(1);
	    }
	}
    }
