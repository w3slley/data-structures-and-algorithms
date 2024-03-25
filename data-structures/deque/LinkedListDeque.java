class LinkedListDeque<T> implements MyDeque<T>{
    private DoublyLinkedList<T> list = new DoublyLinkedList<>();
    
    public void addFirst(T value){
	list.addFirst(value);
    }
    public void addLast(T value){
	list.addLast(value);
    }
    public T removeFirst(){
	T first = list.getFirst();
	list.removeFirst();
	return first;
    }
    public T removeLast(){
	T last = list.getLast();
	list.removeLast();
	return last;
    }

   
    public T first(){
	return list.getFirst();
    }
    public T last(){
	return list.getLast();
    }
    
    public boolean isEmpty(){ return list.isEmpty(); }
    public int size() { return list.size(); }
    public String toString() {return list.toString(); }
}

