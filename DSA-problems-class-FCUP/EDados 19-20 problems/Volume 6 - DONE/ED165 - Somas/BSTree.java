public class BSTree<T extends Comparable<? super T>>{
    BSTNode<T> root;

    BSTree(){
	this.root = null;
    }

    public boolean isEmpty(){
	return this.root == null;
    }

    public void clear(){
	this.root = null;
    }
    //------------------------------
    //Number of nodes on binary tree
    public int numberNodes(){
	return numberNodes(root);
    }

    private int numberNodes(BSTNode<T> node){
	if(node==null) return 0;
	return 1 + numberNodes(node.getLeft()) + numberNodes(node.getRight());
    }
    
    //------------------------------
    //Depth of binary tree
    public int depth(){
	return depth(root);
    }

    private int depth(BSTNode<T> node){
	if(node==null) return -1;
	return 1 + Math.max(depth(node.getLeft()),depth(node.getRight()));
    }

    //------------------------------
    //Checking if value is contained in binary tree    
    public boolean contains(T value){
	return contains(root,value);
    }
    
    private boolean contains(BSTNode<T> node, T value){
	//base case
	if(node==null) return false;
	if(value.compareTo(node.getValue()) < 0)
	    return contains(node.getLeft(),value);
	if(value.compareTo(node.getValue()) > 0)
	    return contains(node.getRight(),value);
	return true;
    }
    //------------------------------
    //Inserting value into binary tree
    public boolean insert(T value){
	if(contains(value)) return false;
	root = insert(root,value);
	return true;
    }

    private BSTNode<T> insert(BSTNode<T> n, T value){
	if(n == null)//when arrived at position to insert, add new node with null left and right subtrees
	    return new BSTNode<T>(value,null,null);//
	else if(value.compareTo(n.getValue()) < 0)//if current node's value is less then value, go to left subtree
	    n.setLeft(insert(n.getLeft(),value));
	else if(value.compareTo(n.getValue()) > 0)//if it's greater then, go to right subtree
	    n.setRight(insert(n.getRight(),value));
	return n;//return root node at the end
    }

    //----------------------------
    //Pre order
    public void printPreOrder(){
	System.out.print("Pre order: ");
	printPreOrder(root);
	System.out.println();
    }
    private void printPreOrder(BSTNode<T> node){
	if(node == null) return;
	System.out.print(node.getValue()+" ");
	printPreOrder(node.getLeft());
	printPreOrder(node.getRight());
    }

    //----------------------------
    //In order
    public void printInOrder(){
	System.out.print("In order: ");
	printInOrder(root);
	System.out.println();
    }

    private void printInOrder(BSTNode<T> node){
	if(node == null) return;
	printInOrder(node.getLeft());
	System.out.print(node.getValue()+" ");
	printInOrder(node.getRight());
    }

    //----------------------------
    //Post order
    public void printPostOrder(){
	System.out.print("Post order: ");
	printPostOrder(root);
	System.out.println();
    }

    private void printPostOrder(BSTNode<T> node){
	if(node == null) return;
	printPostOrder(node.getLeft());
	printPostOrder(node.getRight());
	System.out.print(node.getValue()+" ");
    }
}
