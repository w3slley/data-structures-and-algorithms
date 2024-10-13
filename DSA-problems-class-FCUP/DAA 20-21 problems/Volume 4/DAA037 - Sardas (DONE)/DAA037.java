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
    double cost;
    int x;
    int y;

    Node(int x, int y){
	this.x = x;
	this.y = y;
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

    Graph(Scanner stdin){
	this.n = stdin.nextInt();
	nodes = new Node[n+1];
	// Adding nodes to graph (each node has position (x,y))
	for(int i=1;i<=n;i++)
	    nodes[i] = new Node(stdin.nextInt(), stdin.nextInt());
	
	//Adding links (there is an edge from each node to all others at first)
	for(int a=1;a<=n;a++){//O(n²)
	    for(int b=a;b<=n;b++){
		if(a!=b){
		    //System.out.printf("nodes[a].x: %d, nodes[a].y: %d ",nodes[a].x, nodes[a].y);
		    double w = Math.sqrt(Math.pow(nodes[a].x-nodes[b].x,2)+Math.pow(nodes[a].y-nodes[b].y,2));
		    //System.out.printf("a: %d, b:%d, w:%.2f \n",a,b,w);
		    addLink(a,b,w);
		}
	    }
	}
    }

    void addLink(int a, int b, double w){
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
	double totalCost = 0;
	while(!set.isEmpty()){
	    //choose_best
	    NodeQ nq = set.pollFirst();// Method that returns the lowest element in the BST (works as a priority queue - operations are O(log(n))
	    int u = nq.node;// Node with the lowest cost
	    nodes[u].visited = true; // Marking current node as visited
	    char letter = (char) (u - 1 + 'a');
	    //System.out.printf("%c: [cost=%.3f] %n", letter, nodes[u].cost);
	    totalCost+=nodes[u].cost;
	    
	    // Edge relaxation
	    for(Edge e : nodes[u].adj){
		int v = e.to;
		double w = e.weight;
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
	System.out.printf("%.5f\n",totalCost);
    }
}

class DAA037{
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);

	Graph g = new Graph(stdin);
	// Running Prim's algorithm starting on the first node of the graph
	g.prim(1);
    }
}
