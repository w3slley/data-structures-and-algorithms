import java.util.*;
import java.io.*;

public class DFS {
    static int n;              
    static boolean adj[][];    
    static boolean visited[];
    static LinkedList<Integer> list;

    static void dfs(int v) {
	visited[v] = true;
	for (int i=1; i<=n; i++)
	    if (adj[v][i] && !visited[i])
		dfs(i);
	list.addFirst(v);
	//System.out.print(v+" ");
    }
    
    public static void main(String args[]) {
	Scanner stdin = new Scanner(System.in);
	n = stdin.nextInt();
	adj = new boolean[n+1][n+1];
	visited = new boolean[n+1];
	list = new LinkedList<>();
	
	int edges = stdin.nextInt();	
	for (int i=0; i<edges; i++) {
	    int a = stdin.nextInt();
	    int b = stdin.nextInt();
	    adj[a][b] = true;
	}
	for(int i=1;i<=n;i++)
	    if(!visited[i])
		dfs(i);
	System.out.println(list);
    }
}
