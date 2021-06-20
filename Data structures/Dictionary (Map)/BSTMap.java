import java.util.LinkedList;

public class BSTMap<K extends Comparable <? super K>,V>{
    private BSTMapNode<K,V> root;

    BSTMap(){ this.root = null; }
    public boolean isEmpty(){ return this.root == null; }
    public void clear(){ this.root = null; }
    
    //------------------------------------------------------
    //Size of dictionary
    public int size(){
	return size(this.root);
    }
    private int size(BSTMapNode<K,V> n){
	if(n == null) return 0;
	return 1 + size(n.getLeft()) + size(n.getRight());
    }

    //------------------------------------------------------
    //Get value given key
    public V get(K key){
	return get(this.root, key);
    }
    private V get(BSTMapNode<K,V> n, K key){
	if(n == null) return null;//if there is no key in the tree, the get() method returns null
	if(key.compareTo(n.getKey())<0)
	    return get(n.getLeft(), key);
	if(key.compareTo(n.getKey())>0)
	    return get(n.getRight(),key);

	return n.getValue();
    }
    
    //------------------------------------------------------
    //Insert key value pair into dictionary
    public void put(K key, V value){
	this.root = put(this.root, key, value);
    }

    private BSTMapNode<K,V> put(BSTMapNode<K,V> n, K key, V value){
	if (n == null) return new BSTMapNode<K,V>(key,value,null,null);
	else if (key.compareTo(n.getKey()) < 0)
	    n.setLeft(put(n.getLeft(), key, value));
	else if (key.compareTo(n.getKey()) > 0)
	    n.setRight(put(n.getRight(), key, value));
	else
	    n.setValue(value);
	
	return n;
    }

    //------------------------------------------------------
    //Remove key value pair from  dictionary
    public boolean remove(K key){
	if(get(key)==null) return false;
	root = remove(this.root, key);
	return true;
    }

    private BSTMapNode<K,V> remove(BSTMapNode<K,V> n, K key){
	if(key.compareTo(n.getKey())<0)
	    n.setLeft(remove(n.getLeft(), key));
	else if(key.compareTo(n.getKey())>0)
	    n.setRight(remove(n.getRight(), key));
	else if(n.getLeft() == null) n = n.getRight();
	else if(n.getRight() == null) n = n.getLeft();
	else{//getting greatest value on left subtree
	    BSTMapNode<K,V> max = n.getLeft();//getting left subtree
	    while(max.getRight() != null) max = max.getRight(); // finding most right node on left subtree
	    n.setValue(max.getValue());
	    n.setKey(max.getKey());//setting node's key to max's
	    n.setLeft(remove(n.getLeft(), max.getKey()));//deleting greatest key on left subtree
	}
	return n;
		
    }
    
    //------------------------------------------------------
    //Return keys on linked lists
    public LinkedList<K> keys(){
	LinkedList<K> list = new LinkedList<>();
	keys(this.root, list);
	return list;
    }
    //Basically an in order traversal (added to a linked list)
    private void keys(BSTMapNode<K,V> n, LinkedList<K> l){
	if(n == null) return;

	keys(n.getLeft(), l);
	l.addLast(n.getKey());
	keys(n.getRight(), l);
    }
}
