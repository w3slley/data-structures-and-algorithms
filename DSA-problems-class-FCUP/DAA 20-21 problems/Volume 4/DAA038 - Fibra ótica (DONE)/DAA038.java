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

    Graph(int A, int B){
	this.n = A+B;
	nodes = new Node[n+1];
	for(int i=1;i<=n;i++)
	    nodes[i] = new Node();

	// Creating connected components for nodes between 1 and A
	for(int i=1;i<A;i++)
	    addLink(i,i+1,0);

    }

    void addLink(int a, int b, int w){
	nodes[a].adj.add(new Edge(b,w));
	nodes[b].adj.add(new Edge(a,w));
    }

    int[] prim(int r, int B){//r is the root node that starts prim's algorithm
        int[] arr = new int[B];
	int pos = 0;
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
	    //System.out.printf("%d [cost= %d]%n",u,nodes[u].cost);// Printing node and its cost
	    // Adding cost to array if it's not equal to 0 (that means jump between nodes in the initial connected component
	    if(nodes[u].cost != 0)
	        arr[pos++] = nodes[u].cost;
		    
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
	FastPrint.out.println(totalCost);
        return arr;
    }
}

class DAA038{
    public static void main(String[] args){
	FastScanner stdin = new FastScanner(System.in);
	int A = stdin.nextInt();int B = stdin.nextInt();int C = stdin.nextInt();
	Graph g = new Graph(A,B);
	for (int i=0; i<C; i++) 
	    g.addLink(stdin.nextInt(), stdin.nextInt(), stdin.nextInt());

	// Running Prim's algorithm starting on the first node of the graph
	int[] arr = g.prim(1, B);
	Arrays.sort(arr);
	for(int i=0;i<B;i++){
	    if(i==0) FastPrint.out.print(arr[i]);
	    else FastPrint.out.print(" "+arr[i]);
	}
	FastPrint.out.println();
	FastPrint.out.close();
    }
}
