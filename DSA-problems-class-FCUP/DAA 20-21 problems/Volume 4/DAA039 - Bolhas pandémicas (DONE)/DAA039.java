import java.util.*;

class Node{
    String name;
    Node parent;
    int rank;

    Node(String name){
	this.name = name;
	//Instructions of MAKE_SET
	parent = this;// Represents the parent node in the node's set (used to distinguish between
	rank = 0; // Represents the height of the tree which represents the node's set
    }

    public String toString(){
	return name;
    }
}

class DAA039{

    //Method FIND(x) gets the root of a set's tree (Using "Path Compression")
    static Node find(Node node){
	// What it's done essentially is to decrease the tree's height by point node's parent to root of set
	if(node.parent != node)
	    node.parent = find(node.parent);
	return node.parent;
    }

    //Method UNION(a,b) joins two sets so that they have a common root (Using "Union Rank")
    static void union(Node a, Node b){
	Node rootA = find(a);
	Node rootB = find(b);
	if(rootA == rootB) return; // If both nodes have the same root, then they are already in the same set
	//Operations to ensure that set with the least # of nodes gets added to set with the most nodes (ensure log operations)
	if(rootA.rank < rootB.rank)// If B's set has more nodes, point root node of B to root node of A
	    rootA.parent = rootB;
	else if(rootA.rank > rootB.rank)// If A's set has more nodes, point root node of A
	    rootB.parent = rootA;
	else{// If both have the same height
	    rootB.parent = rootA;// Choose set of B to be pointed at root of A
	    rootA.rank++;// Increase number of nodes in set of A
	}
    }
    
    public static void main(String[] args){
	FastScanner stdin = new FastScanner(System.in);
	int n = stdin.nextInt();
	int p = stdin.nextInt();
	Hashtable<String,Integer> people = new Hashtable<>();
	int id = 1;
	Node[] nodes = new Node[p+1];

	//obtaining id for each person
	for(int i=0;i<n;i++){//O(n)
	    int m = stdin.nextInt();
	    Node[] peopleArr = new Node[m];
	    for(int j=0;j<m;j++){//O(log(m))
		String person =stdin.next(); 
		people.put(person,id);
		nodes[id] = new Node(person);//adding people nodes to arr
		peopleArr[j] = nodes[id++];
		//System.out.printf("person: %s%n",peopleArr[i]);
	    }
	    if(m>1){
		// performing union between people of the same bubble
		for(int k=0;k<m-1;k++)
		    union(peopleArr[k],peopleArr[k+1]);
		
	    }
	}
	int numBubbles = n;
	int q = stdin.nextInt();
	for(int i=0;i<q;i++){//O(q)
	    char flag = (stdin.next()).charAt(0);
	    int p1 = people.get(stdin.next());
	    int p2 = people.get(stdin.next());
	    
	    if(flag == 'P'){
		FastPrint.out.println((find(nodes[p1]) == find(nodes[p2]))?"sim":"nao");
	    }
	    else if(flag == 'E'){
		if(find(nodes[p1]) != find(nodes[p2])) numBubbles--;
		union(nodes[p1],nodes[p2]);
		FastPrint.out.println(numBubbles);
	    }
	    // System.out.printf("p1.parent: %s, p2.parent: %s %n", nodes[p1].parent,nodes[p2].parent);
	}
	FastPrint.out.close();
    }
}
