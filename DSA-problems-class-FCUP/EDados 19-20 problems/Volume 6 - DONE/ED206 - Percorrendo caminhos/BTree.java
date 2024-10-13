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
    //METHOD FOR EXERCISE ED204
    public int numberLeafs(){
	return numberLeafs(this.root);
    }
    private int numberLeafs(BTNode<T> n){
	if(n == null) return 0;
	if(n.getLeft() == null && n.getRight()==null) return 1;
	return numberLeafs(n.getLeft()) + numberLeafs(n.getRight());
    }
    //

    //METHOD FOR EXERCISE ED205
    //O(n)
    public int numChild(){
	return numChild(this.root);
    }
    private int numChild(BTNode<T> n){
	if(n==null) return 0;
	return 1 + numChild(n.getLeft()) + numChild(n.getRight());
    }
    //Worste case: O(n)
    public boolean strict(){
	return strict(this.root);
    }
    private boolean strict(BTNode<T> n){
	if(numChild(n)==0) return false;
	if(n.getLeft() == null && n.getRight() == null) return true;

	
	return strict(n.getLeft()) && strict(n.getRight());
    }
    //

    //METHOD FOR EXERCISE ED206
    //recursive method
    public T path(String s){
	if(s.equals("R")) return this.root.getValue();
	return path(this.root, s, 0);
    }
    private T path(BTNode<T> n, String s, int pos){
	if(pos == s.length()) return n.getValue();
	if(s.charAt(pos) == 'E') return path(n.getLeft(), s, pos+1);
	if(s.charAt(pos) == 'D') return path(n.getRight(), s, pos+1);

	return null;
    }
    /*//iterative method
    public T path(String s){
	if(s.equals("R")) return this.root.getValue();
	BTNode<T> curr = this.root;
	for(int i=0;i<s.length();i++){
	    if(curr == null) return null;
	    if(s.charAt(i)=='D')
		curr = curr.getRight();
	    if(s.charAt(i)=='E')
		curr = curr.getLeft();
	}
	return curr.getValue();
	}*/
    //
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

    public void printPreOrder(){
	System.out.print("Preorder: ");
	printPreOrder(this.root);
	System.out.println();
    }
    
    private void printPreOrder(BTNode<T> n){
	if(n == null) return;
	System.out.print(n.getValue()+" ");
	printPreOrder(n.getLeft());
	printPreOrder(n.getRight());

    }

    public void printInOrder(){
	System.out.print("Inorder: ");
	printInOrder(this.root);
	System.out.println();
    }
    
    private void printInOrder(BTNode<T> n){
	if(n == null) return;
	printInOrder(n.getLeft());
	System.out.print(n.getValue()+" ");
	printInOrder(n.getRight());

    }

    public void printPostOrder(){
	System.out.print("Postorder: ");
	printPostOrder(this.root);
	System.out.println();
    }
    
    private void printPostOrder(BTNode<T> n){
	if(n == null) return;
	printPostOrder(n.getLeft());
	printPostOrder(n.getRight());
	System.out.print(n.getValue()+" ");
    }
    
}



