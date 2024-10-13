import java.util.*;

class Node{
    boolean visited;
    LinkedList<Integer> adj;

    Node(){
	adj = new LinkedList<>();
    }
}

class Graph{
    int n;
    Node[] nodes;
    int[][] distance;
    
    Graph(int n){
	this.n = n;
	nodes = new Node[n+1];
	distance = new int[n+1][n+1];
	for(int i=1;i<=n;i++) nodes[i] = new Node();
	
    }

    void addConnection(int n1, int n2){
	nodes[n1].adj.add(n2);
	nodes[n2].adj.add(n1);
    }

    void bfs(int node){
	Queue<Integer> queue = new LinkedList<>();
	for(int i=1;i<=n;i++) {
	    nodes[i].visited = false;
	}
	queue.add(node);
	nodes[node].visited = true;
	
	while(!queue.isEmpty()){
	    int curr = queue.poll();
	    //System.out.println("node: "+curr+", distance: "+distance[node][curr]);
	    for(int neighbor : nodes[curr].adj){
		if(!nodes[neighbor].visited){
		    queue.add(neighbor);
		    nodes[neighbor].visited = true;
		    distance[node][neighbor] = distance[node][curr] + 1;
		}
	    }
	}
    }

    int getEccentricity(int node){
	int max = distance[node][1];
	for(int i=2;i<=n;i++)
	    max = Math.max(max, distance[node][i]);

	return max;
    }

    int getDiameter(){
	int maxEcc = getEccentricity(1);
        for(int i=2;i<=n;i++){
	    maxEcc = Math.max(maxEcc, getEccentricity(i));
	}
	return maxEcc;
    }

    int getRadius(){
	int minEcc = getEccentricity(1);
        for(int i=2;i<=n;i++){
	    minEcc = Math.min(minEcc, getEccentricity(i));
	}
	return minEcc;
    }

    void getCentralNodes(){
	boolean first = true;
	int r = getRadius();
	for(int i=1;i<=n;i++){
	    if(getEccentricity(i) == r){
		if(first){
		    System.out.print(i);
		    first = false;
		}
		else
		    System.out.print(" "+i);
	    }
	}
	System.out.println();
    }

    void getPeripheralNodes(){
	int d = getDiameter();
	boolean first = true;
	for(int i=1;i<=n;i++){
	    for(int j=1;j<=n;j++){
		if(distance[i][j]==d){
		    if(first){
			System.out.print(i);
			first = false;
		    }
		    else
			System.out.print(" "+i);
		    break;
		}
	    }
	}
	System.out.println();
    }
    
}

class DAA030{
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	int n = stdin.nextInt();
	int e = stdin.nextInt();
	Graph graph = new Graph(n);
	for(int i=0;i<e;i++){
	    graph.addConnection(stdin.nextInt(),stdin.nextInt());
	}
	graph.bfs(1);
	
	for(int i=1;i<=n;i++)
	    graph.bfs(i);

	System.out.println(graph.getDiameter());
	System.out.println(graph.getRadius());
	graph.getCentralNodes();
	graph.getPeripheralNodes();
    }
}
