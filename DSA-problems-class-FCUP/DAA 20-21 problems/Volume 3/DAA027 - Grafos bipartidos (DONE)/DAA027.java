// Exemplo de pesquisa em profundidade (DFS) para num grafo bipartido nao dirigido

import java.util.*;
import java.io.*;

public class DAA027 {
    static int n;              // Numero de nos do grafo
    static boolean adj[][];    // Matriz de adjacencias
    static boolean visited[];  // Que nos ja foram visitados?
    static boolean isGreen[];  // Indica se nó na posição i é verde ou não

    static boolean dfs(int v, boolean prevColor) {
	visited[v] = true;
	isGreen[v] = !prevColor;//setting color of node to be the opposite of the one which called dfs
	for(int i=1;i<=n;i++){
	    if(adj[v][i] && visited[i] && isGreen[v] == isGreen[i]){
		//System.out.println("False -> ("+v+","+i+")");
		return false;
	    }
	    if(adj[v][i] && !visited[i]){
		//System.out.println("("+v+","+i+")");
		return dfs(i, isGreen[v]);
	    }
	}
	return true;
    }
    
    public static void main(String args[]) {
	Scanner stdin = new Scanner(System.in);
	int t = stdin.nextInt();
	for(int k=0;k<t;k++){
	    n = stdin.nextInt();
	    adj = new boolean[n+1][n+1];
	    visited = new boolean[n+1];
	    isGreen = new boolean[n+1];
	    int edges = stdin.nextInt();	
	    for (int i=0; i<edges; i++) {
		int a = stdin.nextInt();
		int b = stdin.nextInt();
		adj[a][b] = adj[b][a] = true;
	    }
	    System.out.println(dfs(1,true)?"sim":"nao");
	    // System.out.println("adj[][]: "+Arrays.deepToString(adj));
	    //System.out.println("visited: "+Arrays.toString(visited));
	    //System.out.println("isGreen: "+Arrays.toString(isGreen));
	}
    }
}
