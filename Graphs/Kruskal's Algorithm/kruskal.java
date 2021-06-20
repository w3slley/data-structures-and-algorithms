/*
  Implementation of Kruskal's algorithm for finding Minimum Spamming Trees (MST) on undirected and weighted graphs. A MST is a sub-set of edges in the graph that connects all the vertices together, without any cycles and with the minimum possible total edge weight.

  The Time Complexity of Kruskal's algoritm using a priority queue is O(|E|log(|V|)) using improvements such as Path Compression and Union by Rank, making the time complexity of Kruskal's algorithm dominated by the sorting of the edges of the graph.
  
*/
import java.util.*;

class Edge implements Comparable<Edge>{
    int from;
    int to;
    int weight;

    Edge(int from, int to, int w){
	this.from = from;
	this.to = to;
	this.weight = w;
    }

    public int compareTo(Edge e){
	if(this.weight==e.weight)
	    return this.to-e.to;
	return this.weight-e.weight;
    }

    public String toString(){
	return "w: "+weight;
    }
}

class Node{
    Node parent;
    int rank;

    Node(){
	//Instructions of MAKE_SET
	parent = this;// Represents the parent node in the node's set (used to distinguish between
	rank = 0; // Represents the height of the tree which represents the node's set
    }
}


class Graph{
    int n;
    Node[] nodes;
    TreeSet<Edge> edges;
    int totalWeight;
    
    Graph(int n){
	this.n = n;
	nodes = new Node[n+1];
	// Making individual set for each node in G by initializing node objects
	for(int i=1;i<=n;i++)
	    nodes[i] = new Node();
	
	edges = new TreeSet<>();
	totalWeight = 0;
    }
    //Adding edges to TreeSet (they will be sorted)
    void addEdges(int a, int b, int w){
	edges.add(new Edge(a,b,w));
    }
    
    //Method FIND(x) gets the root of a set's tree (Using "Path Compression")
    Node find(Node node){
	// What it's done essentially is to decrease the tree's height by point node's parent to root of set
	if(node.parent != node)
	    node.parent = find(node.parent);
	return node.parent;
    }

    //Method UNION(a,b) joins two sets so that they have a common root (Using "Union Rank")
    void union(Node a, Node b){
	Node rootA = find(a);
	Node rootB = find(b);
	if(rootA == rootB) return; // If both nodes have the same root, then they are already in the same set
	//Operations to ensure that set with the least # of nodes gets added to set with the most nodes (ensure log operations)
	if(rootA.rank < rootB.rank)// If B's set has more nodes, point root node of B to root node of A
	    rootA.parent = rootB;
	else if(rootA.rank > rootB.rank)// If A's set has more nodes, point root node of A
	    rootB.parent = rootA;
	else{// If both have the same height
	    rootB.parent = rootA;// Choose set of B to be pointed at root of A
	    rootA.rank++;// Increase number of nodes in set of A
	}
    }

    void kruskal(){
	while(!edges.isEmpty()){
	    Edge e = edges.pollFirst(); // Retreiving edge with the lowest cost from treeset
	    int from = e.from;
	    int to = e.to;
	    int w = e.weight;
	    if(find(nodes[from]) != find(nodes[to])){//FIND(a) != FIND(b) means two nodes are not from the same set
		union(nodes[from],nodes[to]);// Adding both nodes to the same set
		totalWeight += w;//adding weight to global variable
		System.out.printf("from: %c, to: %c, weight: %d%n",(char) (e.from-1+'a'),(char) (e.to-1+'a'),w);
	    }
	}
	System.out.println(totalWeight);
    }
    
}

class kruskal{
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	Graph g = new Graph(stdin.nextInt());
	int e = stdin.nextInt();
	for (int i=0; i<e; i++) 
	    g.addEdges(stdin.nextInt(), stdin.nextInt(), stdin.nextInt());
	//System.out.println(g.edges);
	g.kruskal();
    }
}
