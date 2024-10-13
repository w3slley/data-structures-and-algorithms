// Codigo inicial para o problema [DAA 022] Arvores Red-Black
// Pedro Ribeiro (DCC/FCUP)

import java.util.Scanner;

// Estrutura para representar um no da arvore
class Node {
    boolean isBlack;  // No preto?
    boolean isNull;   // No nulo?
    int value;        // Valor
    Node left, right; // Filhos

    Node(int v) {
	isNull  = (v==0);
	isBlack = (v>=0);
	value   = Math.abs(v);
    }
}

public class daa022 {

    // Ler input em preorder
    static Node readPreOrder(Scanner in) {
	int v = in.nextInt();
	Node aux = new Node(v);
	if (v!=0) {
	    aux.left  = readPreOrder(in);
	    aux.right = readPreOrder(in);
	}
	return aux;
    }
    //is binary tree?
    static boolean isBinaryTree(Node t){//O(n log(n))
	if(t.isNull) return true;	//if node is null, return true (case base)
	if(maximum(t.left) > t.value || minimum(t.right) < t.value) //if current node isn't a leaf, compare the values from its left and right subtrees
	    return false;
	
	return isBinaryTree(t.left) && isBinaryTree(t.right);
    }

    //root property
    static boolean rootProperty(Node t){
	return t.isBlack;
    }

    //red property
    static boolean redProperty(Node t){
	if(t.isNull) return true;
	//if node is red and its child nodes are not black, return false
	if(!t.isBlack && (!t.left.isBlack || !t.right.isBlack)) return false;
	
	return redProperty(t.left) && redProperty(t.right);
    }
    
    //calculate black height
    static int blackHeight(Node t){
	if(t.isNull) return 0;
	int val = t.isBlack?1:0;
	return val + blackHeight(t.left);
    }
    
    //black property
    static boolean blackProperty(Node t, int numBlackSoFar, int bh){
	if(t.isNull)
	    return numBlackSoFar == bh;

	int val = t.isBlack?1:0;
	return blackProperty(t.left, numBlackSoFar+val, bh) && blackProperty(t.right, numBlackSoFar+val, bh);
    }

    // Menor valor da arvore
    static int minimum(Node t) {
	if (t.isNull) return Integer.MAX_VALUE;
	int minLeft  = minimum(t.left);
	int minRight = minimum(t.right);
	return Math.min(t.value, Math.min(minLeft, minRight));
    }

    // Maior valor da arvore
    static int maximum(Node t) {
	if (t.isNull) return Integer.MIN_VALUE;
	int minLeft  = maximum(t.left);
	int minRight = maximum(t.right);
	return Math.max(t.value, Math.max(minLeft, minRight));
    }

    // Quantidade de nos (internos)
    static int size(Node t) {
	if (t.isNull) return 0;
	return 1 + size(t.left) + size(t.right);
    }

    // ---------------------------------------------------
    
    public static void main(String args[]) {
	Scanner in = new Scanner(System.in);
	
	int n =  in.nextInt();
	for (int i=0; i<n; i++) {
	    Node r = readPreOrder(in);
	    int bh = blackHeight(r);
	    //System.out.println("black height: "+bh);
	    if(rootProperty(r) && redProperty(r) && blackProperty(r,0,bh) && isBinaryTree(r)) System.out.println("SIM");
	    else
		System.out.println("NAO");
	    
	    //System.out.printf("Tree with %d nodes (min=%d, max=%d)\n", size(root), minimum(root), maximum(root));
	}	
    }
}
