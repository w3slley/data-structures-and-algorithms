/*
  Implementation of Floyd-Warshall's algorithm for finding the minimum distance between all nodes in a directed weighted graph with/without negative weights on a all-pairs shortest path problem (minimal distance from all nodes to each other).

  Time Complexity of the Floyd-Warshall's algoritm: O(|V|³)
 */
import java.util.*;

class Graph{
    int n;
    int[][] distances;

    Graph(int n){
	this.n = n;
	this.distances = new int[n+1][n+1];

	// Filling distance matrix
	for(int i=1;i<=n;i++){
	    for(int j=1;j<=n;j++){
		if(i == j) distances[i][j] = 0;
		else distances[i][j] = Integer.MAX_VALUE/2;// Divide by two to prevent overflow when adding values to it
	    }
	}
    }

    void addLinks(int u, int v, int w){
	distances[u][v] = w;
    }

    void floydWarshall(int from, int to){
	for(int k=1;k<=n;k++){
	    for(int i=1;i<=n;i++){
		for(int j=1;j<=n;j++){
		    // If distance from node i to k + node k + j is greater than the distance from i to j, update distance from i to j!
		    if(distances[i][k] + distances[k][j] < distances[i][j]){
			distances[i][j] = distances[i][k] + distances[k][j];
		    }
		}
	    }
	}
	System.out.println(distances[from][to]);
    }
}


class FloydWarshall{
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
