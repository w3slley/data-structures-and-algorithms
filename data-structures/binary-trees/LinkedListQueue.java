class LinkedListQueue<T> implements MyQueue<T>{
    private DoublyLinkedList<T> list = new DoublyLinkedList<>();
    
    public void enqueue(T v){
	list.addLast(v);
    }
    public T dequeue(){
	T first = list.getFirst();
	list.removeFirst();
	return first;
    }
   
    public T first(){
	return list.getFirst();
    }
    public boolean isEmpty(){ return list.isEmpty(); }
    public int size() { return list.size(); }
    public String toString() {return list.toString(); }
}

