class BTNode<T>{
    private T value;
    private BTNode<T> left;
    private BTNode<T> right;

    BTNode(T value, BTNode<T> left, BTNode<T> right){
	this.value = value;
	this.left = left;
	this.right = right;
    }

    //Getters and setters
    public T getValue(){ return value; }

    public BTNode<T> getLeft(){ return left; }

    public BTNode<T> getRight(){return right; }

    public void setValue(T value){ this.value = value; }

    public void setLeft(BTNode<T> left){ this.left = left; }

    public void setRight(BTNode<T> right){ this.right = right;  }

    public String toString(){
	return value+"";
    }
}
