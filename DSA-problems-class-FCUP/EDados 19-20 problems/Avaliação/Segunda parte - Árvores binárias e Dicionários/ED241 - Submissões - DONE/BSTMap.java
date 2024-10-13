import java.util.LinkedList;

class BSTMap<K extends Comparable<? super K>,V>{
    private BSTMapNode<K,V> root;

    BSTMap(){
	root = null;
    }
    
    //size
    public int size(){
	return size(root);
    }

    private int size(BSTMapNode<K,V> n){
	if(n == null) return 0;

	return 1 + size(n.left) + size(n.right);
    }
    
    //get
    public V get(K key){
	return get(root, key);
    }

    private V get(BSTMapNode<K,V> n, K key){
	if(n == null) return null;
	
	if(key.compareTo(n.key) > 0)
	    return get(n.right,key);
	if(key.compareTo(n.key) < 0)
	    return get(n.left,key);

	return n.value;
    }
    
    //put
    public void put(K key, V value){
	root = put(root, key, value);
    }

    private BSTMapNode<K,V> put(BSTMapNode<K,V> n, K key, V value){
	if(n == null)
	    return new BSTMapNode<K,V>(key,value, null, null);
	else if(key.compareTo(n.key) > 0)
	    n.right = put(n.right,key,value);
	else if(key.compareTo(n.key) < 0)
	    n.left = put(n.left,key,value);
	else
	    n.value = value;
	
	return n;
    }
    
    //remove
    public boolean remove(K key){
	if(get(key) == null) return false;
	root = remove(root, key);
	return true;
    }

    private BSTMapNode<K,V> remove(BSTMapNode<K,V> n, K key){
	if(key.compareTo(n.key) > 0)
	    n.right = remove(n.right,key);
	else if(key.compareTo(n.key) < 0)
	    n.left = remove(n.left,key);
	else if(n.left == null)
	    n = n.right;
	else if(n.right == null)
	    n = n.left;
	else{//if it's equal and it has nodes on both left and right subtrees
	    BSTMapNode<K,V> maxLeft = n.left;
	    while(maxLeft.right != null) maxLeft = maxLeft.right;
	    n.value = maxLeft.value;
	    n.key = maxLeft.key;
	    n.left = remove(n.left, maxLeft.key);
	}

	return n;
    }
    
    //keys
    public LinkedList<K> keys(){
	LinkedList<K> l = new LinkedList<>();
	keys(root,l);
	return l;
    }

    private void keys(BSTMapNode<K,V> n, LinkedList<K> l){
	if(n == null) return;
	
	keys(n.left,l);
	l.addLast(n.key);
	keys(n.right,l);
    }
}
