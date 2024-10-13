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
    //I have to implement a copy() function that doesn't create new nodes, but only points to original linked list references
    public SinglyLinkedList<T> copy(){
	SinglyLinkedList<T> newList = new SinglyLinkedList<>();
	Node<T> curr = first;
	for(int i=0;i<size;i++){
	    newList.addLast(curr.getValue());
	    curr = curr.getNext();
	}
	return newList;
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
    public T remove(int pos){
	if(pos < 0 || pos >= size) return null;
	if(pos == 0){
	    T initValue = get(0);
	    removeFirst();
	    return initValue;
	}
	if(pos == size-1){
	    T lastValue = get(size-1);
	    removeLast();
	    return lastValue;
	}
	Node<T> curr = first;
	for(int i=0;i<pos-1;i++){//go to node prior to the one you want to delete
	    curr = curr.getNext();
	}
	T valueRemoved = curr.getNext().getValue();//get the value from deleted node
	curr.setNext(curr.getNext().getNext());	//set reference to node after the one deleted
	size--;
        return valueRemoved;
    }

    public void removeAll(T item){
	Node<T> curr = first;
	int i = 0;
	do{
	    if(curr.getValue().equals(item)){
		remove(i);
		i--;
	    }
	    curr = curr.getNext();
	    i++;
	}
	while(curr.getNext()!=null);
    }

    public void duplicate(){
	return;
    }
    public int count(T item){
	Node<T> curr = first;
	int numCount = 0;
	for(int i=0;i<size;i++){
	    if(curr.getValue().equals(item)) numCount++;
	    curr = curr.getNext();
	}
	return numCount;
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

}
