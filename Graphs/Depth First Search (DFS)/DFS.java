import java.util.*;
import java.io.*;

public class DFS {
    static int n;              
    static boolean adj[][];    
    static boolean visited[];

    static void dfs(int v) {
	visited[v] = true;
	System.out.println((char)(v-1+'a'));
	for (int i=1; i<=n; i++)
	    if (adj[v][i] && !visited[i])
		dfs(i);
    }
    
    public static void main(String args[]) {
	Scanner stdin = new Scanner(System.in);
	n = stdin.nextInt();
	adj = new boolean[n+1][n+1];
	visited = new boolean[n+1];
	
	int edges = stdin.nextInt();	
	for (int i=0; i<edges; i++) {
	    int a = stdin.nextInt();
	    int b = stdin.nextInt();
	    adj[a][b] = adj[b][a] = true;
	}
        dfs(1);
    }
}
