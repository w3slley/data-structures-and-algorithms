# Dictionary
A dictionary ADT stores pairs (key,value). A key is only present once and has associated to itself a value.

Tipical operations on dictionaries:

- Add a pair to the dictionary (key and value);
- Remove a pair from the dictionary (given a key);
- Modify a pair in the dictionary (given a key and a new value);
- Get a value from a key.

It's possible to use binary search trees to implement dicionaries: each node will have as atributes a key and a node. Here's the implementation of a node for a binary search tree on dictionaries.

```java
public class BSTMapNode <K extends Comparable <? super K>, V> {
    private K key;
    // chave
    private V value ;
    // valor
    private BSTMapNode <K,V> left; // Filho esquerdo
    private BSTMapNode <K,V> right ; // Filho direito
    // Construtor
    BSTMapNode (K k, V v, BSTMapNode <K,V> l, BSTMapNode <K,V> r) {
    key = k;
    value = v;
    left = l;
    right = r;
    }
}
```

The rest of the implementation is on the directory `java-EDados2020/Important Concepts/Dictionary(Map)`. Go there take a look at it!
