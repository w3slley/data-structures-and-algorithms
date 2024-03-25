class BSTNode<T extends Comparable<? super T>>{
    private T value;
    private BSTNode<T> left;
    private BSTNode<T> right;
    
    BSTNode(T value, BSTNode<T> left, BSTNode<T> right){
	this.value = value;
	this.left = left;
	this.right = right;
    }
    
    public T getValue(){ return value; }
    public BSTNode<T> getLeft(){ return this.left; }
    public BSTNode<T> getRight(){ return this.right; }
    public void setValue(T value){ this.value = value; }
    public void setLeft(BSTNode<T> left){ this.left = left; }
    public void setRight(BSTNode<T> right){ this.right = right; }
}
