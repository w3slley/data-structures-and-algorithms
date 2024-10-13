class DoublyLinkedList<T> {
    private DNode<T> first;
    private DNode<T> last;
    private int size;

    DoublyLinkedList(){
        first = new DNode<>(null, null, null);
        last = new DNode<>(null, first, null);
	first.setNext(last);
	size = 0;
    }
    public int size(){ return size; }

    public boolean isEmpty(){
	return (size == 0);
    }
    public T getFirst(){
	if(isEmpty()) return null;
	return first.getNext().getValue();
    }
    
    public T getLast(){
	if(isEmpty()) return null;
	return last.getPrev().getValue();
    }
    
    public void addFirst(T value){
	addBetween(value, first, first.getNext());
    }

    public void addLast(T value){
	addBetween(value, last.getPrev(), last);
    }
    public void addBetween(T v, DNode<T> n1, DNode<T> n2){
	DNode<T> newNode = new DNode<>(v, n1, n2);
	n1.setNext(newNode);
	n2.setPrev(newNode);
	size++;
    }

    public void removeFirst(){
	if(isEmpty()) return;
	remove(first.getNext());
    }

    public void removeLast(){	    
	if(isEmpty()) return;
	remove(last.getPrev());
    }
    public void remove(DNode<T> n){
        DNode<T> prev = n.getPrev();
	DNode<T> next = n.getNext();
	prev.setNext(next);
	next.setPrev(prev);
	size--;
    }	
    public String toString(){
	if(isEmpty()) return "{}";
	String answer = "{";
	DNode<T> curr = first.getNext();
	for(int i=0;i<size;i++){
	    if(i!=0) answer+=",";
	    answer+= curr.getValue();
	    curr = curr.getNext();
	}
	answer += "}";
	return answer;
    }

}
