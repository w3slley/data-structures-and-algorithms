import java.util.*;
class DAA029{
    static boolean adj[][]; 
    static boolean visited[];
    static LinkedList<Character> nodes;
    static LinkedList<Character> list;

    public static void processWords(String s1, String s2){
	int pos = 0;
	while(pos<s1.length() && pos<s2.length()){
	    char c1 = s1.charAt(pos);
	    char c2 = s2.charAt(pos);
	    if(c1 != c2){
		adj[c1-'A'][c2-'A'] = true;
		//adding chars to list
		if(!nodes.contains(c1)) nodes.add(c1);
		if(!nodes.contains(c2)) nodes.add(c2);
		break;
	    }
	    pos++;
	}
    }
	
    public static void dfs(int c){
	char ch = (char) (c + 'A');
	visited[c] = true;
	for(int i=0;i<26;i++){
	    if(adj[c][i] && !visited[i])
		dfs(i);
	}
	list.addFirst(ch);
    }
    
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	int n = stdin.nextInt();
	adj = new boolean[26][26];
	visited = new boolean[26];
	list = new LinkedList<>();
	nodes = new LinkedList<>();
	String[] words = new String[n];
	//populating array 
	for(int i=0;i<n;i++)
	    words[i] = stdin.next();
	//processing each word to find order of letters
	for(int i=0;i<n-1;i++)
	    processWords(words[i],words[i+1]);
	//looping through each unvisited node and doing a dfs starting from it
	for(Character c : nodes){
	    if(!visited[c-'A'])
		dfs(c-'A');
	}
	//printing nodes in topological order
	for(Character c : list)
	    System.out.print(c);

	System.out.println();
    }
}
