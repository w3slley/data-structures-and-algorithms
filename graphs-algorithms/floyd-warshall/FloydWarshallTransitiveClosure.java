/*
  Implementation of Floyd-Warshall's algorithm for finding the minimum distance between all nodes in a directed weighted graph with/without negative weights on a all-pairs shortest path problem (minimal distance from all nodes to each other).

  Time Complexity of the Floyd-Warshall's algoritm: O(|V|³)
 */
import java.util.*;

class Graph{
    int n;
    boolean[][] hasConnection;

    Graph(int n){
	this.n = n;
	this.hasConnection = new boolean[n+1][n+1];

	// Filling hasConnection matrix
	for(int i=1;i<=n;i++)
	    for(int j=1;j<=n;j++)
		if(i == j) hasConnection[i][j] = true;
    }

    void addLinks(int u, int v, int w){
	hasConnection[u][v] = true;
    }

    void floydWarshall(int from, int to){
	for(int k=1;k<=n;k++){
	    for(int i=1;i<=n;i++){
		for(int j=1;j<=n;j++){
		    // If node i and k are connected and node k and j are connected, than node i and j are connected (using node k as a middle point).
		    if(hasConnection[i][k] && hasConnection[k][j])
			hasConnection[i][j] = true;
		}
	    }
	}
	//System.out.println(Arrays.deepToString(hasConnection));
	//hasConnection[from][to] returns true if there is a connection between node 'from' and 'to' and false otherwise
	System.out.println(hasConnection[from][to]);
    }
}


class FloydWarshallTransitiveClosure{
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	int n = stdin.nextInt();
	Graph g = new Graph(n);
	int numEdges = stdin.nextInt();
	for (int i=0; i<numEdges; i++) {
	    g.addLinks(stdin.nextInt(),stdin.nextInt(),stdin.nextInt());
	}
	g.floydWarshall(4,1);
    }
}
