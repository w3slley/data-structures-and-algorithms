class SinglyLinkedList<T> {
    private Node<T> first;
    private int size;

    SinglyLinkedList(){
	size = 0;
	first = null;
    }
    public int size(){ return size; }

    public boolean isEmpty(){
	return (size == 0);
    }
    //down side: algorith has to traverse the list -> O(n);
    public T get(int pos){
	if(pos>size-1 || pos < 0) return null;
	Node<T> curr = first;
	for(int i=0;i<pos;i++){
	    curr = curr.getNext();
	}
	return curr.getValue();
    }
    public void addFirst(T value){
	Node<T> n = new Node<>(value, first);
	first = n;
	size++;
    }

    public void addLast(T value){
	Node<T> n = new Node<>(value, null);
	if(isEmpty()) first = n;
	else{
	    Node<T> curr = first;
	    while(curr.getNext() != null)
		curr = curr.getNext();
	    curr.setNext(n);
	}
	size++;
    }
    public T getFirst(){
	if(isEmpty()) return null;
	return first.getValue();
    }
    
    public T getLast(){
	if(isEmpty()) return null;
	Node<T> curr = first;
	while(curr.getNext() != null)
	    curr = curr.getNext();
	return curr.getValue();
    }

    public void removeFirst(){
	if(isEmpty()) return;
	first = first.getNext();
	size--;
    }

    public void removeLast(){
	if(isEmpty()) return;
	if(size == 1) first = null;
	else{
	    Node<T> curr = first;
	    while(curr.getNext().getNext() != null)
		curr = curr.getNext();
	    curr.setNext(null);
	}
	size--;
	    
    }

    public String toString(){
	String answer = "{";
	Node<T> curr = first;
	for(int i=0;i<size;i++){
	    if(i!=0) answer+=",";
	    answer+= curr.getValue();
	    curr = curr.getNext();
	}
	answer += "}";
	return answer;
    }
