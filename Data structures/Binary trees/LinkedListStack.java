class LinkedListStack<T> implements MyStack<T>{
    private DoublyLinkedList<T> list;

    LinkedListStack(){
	list = new DoublyLinkedList<T>();
    }
    public void push(T value){
	list.addFirst(value);
    }
    public T pop(){
	T first = list.getFirst();
	list.removeFirst();
	return first;
    }
    public T top(){ return list.getFirst(); }
    public boolean isEmpty(){ return list.isEmpty(); }
    public int size(){ return list.size(); }
    public String toString(){ return list.toString(); }
}
