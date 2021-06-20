import java.util.*;
import java.io.*;

public class CycleDetection {
    static int n;              
    static boolean adj[][];    
    static char color[];//'W' is white (didn't visited yet), 'G' is gray (node was visited and is in stack) and 'B' is black (visited and out of stack)

    static void dfs(int v) {
	System.out.println(v);
        color[v] = 'G';
	for (int i=1; i<=n; i++){
	    if (adj[v][i]){//if there is a connection between node v and i
		if(color[i] == 'G') System.out.println("Found a cycle at ("+v+","+i+")");
		else if(color[i] == 'W') dfs(i);
	    }
	}
	color[v] = 'B';//when there are no more nodes left to go, mark node as black
    }
    
    public static void main(String args[]) {
	Scanner stdin = new Scanner(System.in);
	n = stdin.nextInt();
	adj = new boolean[n+1][n+1];
	color = new char[n+1];
	Arrays.fill(color,'W');
	
	int edges = stdin.nextInt();	
	for (int i=0; i<edges; i++) {
	    int a = stdin.nextInt();
	    int b = stdin.nextInt();
	    adj[a][b] = true;
	}
	dfs(1);
    }
}
