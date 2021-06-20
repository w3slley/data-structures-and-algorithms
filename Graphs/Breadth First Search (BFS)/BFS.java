import java.util.*;

class Node{
    boolean visited;
    LinkedList<Integer> adj;
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
	for(int i=1;i<=n;i++) nodes[i] = new Node();
    }

    void addConnection(int n1, int n2){
	nodes[n1].adj.add(n2);
	nodes[n2].adj.add(n1);
    }

    void bfs(int node){
	Queue<Integer> queue = new LinkedList<>();
	for(int i=1;i<=n;i++) nodes[i].visited = false;
	queue.add(node);
	nodes[node].visited = true;
	nodes[node].distance = 0;
	
	while(!queue.isEmpty()){
	    int curr = queue.poll();
	    System.out.println("node: "+(char)(curr-1+'A')+", distance: "+nodes[curr].distance);
	    for(int neighbor : nodes[curr].adj){
		if(!nodes[neighbor].visited){
		    queue.add(neighbor);
		    nodes[neighbor].visited = true;
		    nodes[neighbor].distance = nodes[curr].distance + 1;
		}
	    }
	}
    }
}

class BFS{
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	int numNodes = stdin.nextInt();
	int numEdges = stdin.nextInt();
	Graph graph = new Graph(numNodes);
	for(int i=0;i<numEdges;i++){
	    graph.addConnection(stdin.nextInt(),stdin.nextInt());
	}
	graph.bfs(1);
    }
}
