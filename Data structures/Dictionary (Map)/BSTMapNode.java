public class BSTMapNode<K extends Comparable <? super K>, V>{
    private K key;
    private V value;
    private BSTMapNode<K,V> left;
    private BSTMapNode<K,V> right;

    BSTMapNode(K key, V value, BSTMapNode<K,V> left, BSTMapNode<K,V> right){
	this.key = key;
	this.value = value;
	this.left = left;
	this.right = right;
    }

    public K getKey(){ return this.key; }
    public V getValue(){ return this.value; }
    public BSTMapNode<K,V> getLeft() {return this.left;}
    public BSTMapNode<K,V> getRight() {return this.right;}
    
    public void setKey(K key){ this.key = key; }
    public void setValue(V value){ this.value = value; }
    public void setLeft(BSTMapNode<K,V> left) {this.left = left;}
    public void setRight(BSTMapNode<K,V> right) {this.right = right;}
    
}
