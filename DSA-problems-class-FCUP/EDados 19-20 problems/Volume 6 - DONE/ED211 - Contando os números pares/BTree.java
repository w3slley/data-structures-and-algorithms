class BTree<T>{
    private BTNode<T> root;

    BTree(){
	root = null;
    }

    public BTNode<T> getRoot(){ return root; }
    public void setRoot(BTNode<T> root) { this.root = root; }
    public boolean isEmpty(){ return root==null; }

    public int numberNodes(){
	return numberNodes(root);
    }

    private int numberNodes(BTNode<T> n){
	if(n==null) return 0;
	return 1 + numberNodes(n.getLeft()) + numberNodes(n.getRight());
    }
    
    public int depth(){
	return depth(root);
    }
    
    private int depth(BTNode<T> n){
	if(n == null) return -1;
	return 1 + Math.max(depth(n.getLeft()), depth(n.getRight()));
    }

    public boolean contains(T value){
	return contains(this.root, value);
    }
    private boolean contains(BTNode<T> n, T value){
	if(n == null) return false;
	if(n.getValue().equals(value)) return true;
	
	return contains(n.getLeft(),value) || contains(n.getRight(),value);
    }
    
}
