import java.util.*;

class Graph{
    int n;
    int[][] hasConnection;

    Graph(int n){
	this.n = n;
	this.hasConnection = new int[n][n];

	// Filling hasConnection matrix
	for(int i=0;i<n;i++)
	    for(int j=0;j<n;j++)
		if(i == j) hasConnection[i][j] = 1;
    }

    void addLinks(int u, int v){
	hasConnection[u][v] = 1;
    }

    void floydWarshall(){
	for(int k=0;k<n;k++){
	    for(int i=0;i<n;i++){
		for(int j=0;j<n;j++){
		    // If node i and k are connected and node k and j are connected, than node i and j are connected (using node k as a middle point).
		    if(hasConnection[i][k]==1 && hasConnection[k][j]==1)
			hasConnection[i][j] = 1;
		}
	    }
	}
    }

    void printMatrix(){
	System.out.print("  ");
	for(int i=0;i<n;i++){
	    char c = (char) (65 + i);
	    if(i == n-1) System.out.println(c);
	    else System.out.print(c+ " ");
	}
	for(int i=0;i<n;i++){
	    char c = (char) (65 + i);
	    System.out.print(c+" ");
	    for(int j=0;j<n;j++){
		if(j==n-1) System.out.print(hasConnection[i][j]+"\n");
		else System.out.print(hasConnection[i][j]+" ");
	    }
	}

    }
}


class DAA035{
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	int n = stdin.nextInt();
	Graph g = new Graph(n);
	while(n-->0){
	    //int u = stdin.next();
	    int origin = stdin.next().charAt(0) - 'A';
	    int connections = stdin.nextInt();
	    for(int i=0;i<connections;i++){
		int destination = stdin.next().charAt(0) - 'A';
		g.addLinks(origin, destination);
	    }
	}
	g.floydWarshall();
	g.printMatrix();
    }
}
