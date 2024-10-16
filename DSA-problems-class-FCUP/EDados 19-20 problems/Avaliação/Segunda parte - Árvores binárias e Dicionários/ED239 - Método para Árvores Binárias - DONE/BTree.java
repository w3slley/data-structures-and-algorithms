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


    //---------------------------------------
    //ED239
    public int count(){
	return count(root);
    }

    private int count(BTNode<T> n){
	if(n == null) return 0;
	int c = 0;
        if((n.getLeft() != null && n.getRight() == null)  || (n.getLeft() == null && n.getRight() != null))
	    c++;
	return c + count(n.getLeft()) + count(n.getRight());
    }

    public int level(T v){
	int d = depth();
	int res = level(root, v, 0, d);
	if(res == d+1) return -1;

	return res;
    }
    //figure out a more "clean" way to solve this problem later
    private int level(BTNode<T> n, T v, int l, int depth){
	if(n == null) return depth+1;
	if(v.equals(n.getValue()))
	    return l;
	
	return Math.min(level(n.getLeft(),v,l+1,depth),level(n.getRight(),v,l+1,depth));
	
    }
    
    //--------------------------------------
    
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
    
    public void printBFS(){
	System.out.print("BFS: ");
	MyQueue<BTNode<T>> q = new LinkedListQueue<>();
	q.enqueue(this.root);
	while(!q.isEmpty()){
	    BTNode<T> curr = q.dequeue();
	    if(curr != null){
		System.out.print(curr.getValue() + " ");
		q.enqueue(curr.getLeft());
		q.enqueue(curr.getRight());
	    }
	}
	System.out.println();
    }
    
    //The only difference (apart from the functionality of course) is that DFS uses a stack instead of a queue!
    public void printDFS(){
	System.out.print("DFS: ");
	MyStack<BTNode<T>> q = new LinkedListStack<>();
	q.push(this.root);
	while(!q.isEmpty()){
	    BTNode<T> curr = q.pop();
	    if(curr != null){
		System.out.print(curr.getValue() + " ");
		q.push(curr.getLeft());
		q.push(curr.getRight());
	    }
	}
	System.out.println();
    }
}
