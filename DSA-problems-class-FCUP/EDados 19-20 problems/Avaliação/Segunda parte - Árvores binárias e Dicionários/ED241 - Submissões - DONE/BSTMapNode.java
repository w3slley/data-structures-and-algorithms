class BSTMapNode<K extends Comparable<? super K>, V>{
    K key;
    V value;
    BSTMapNode<K,V> left;
    BSTMapNode<K,V> right;

    BSTMapNode(K k, V v, BSTMapNode<K,V> l, BSTMapNode<K,V> r ){
	key = k;
	value = v;
	left = l;
	right = r;
    }
}
