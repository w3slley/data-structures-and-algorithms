class CircularLinkedList<T>{
    private int size;
    private Node<T> last;


    CircularLinkedList(){
	size = 0;
	last = null;
    }

    public int size(){ return size; }
    public boolean isEmpty() { return (size==0); }

    public T getFirst(){
	if(isEmpty()) return null;
	return last.getNext().getValue();
    }
    
    public T getLast(){
	if(isEmpty()) return null;
	return last.getValue();
    }

    public void addFirst(T value){
	if(isEmpty()){
	    last = new Node<>(value, null);
	    last.setNext(last);
	}
	else{
	    Node<T> n = new Node<>(value, last.getNext());
	    last.setNext(n);
	}
	size++;
    }

    public void addLast(T value){
	addFirst(value);
	last = last.getNext();
    }

    public void removeFirst(){
	if(isEmpty()) return;
	if(size == 1) last = null;
	else last.setNext(last.getNext().getNext());
	size--;
    }

    public void removeLast(){
	if(isEmpty()) return;
	if(size == 1) last = null;
	else{
	    Node<T> curr = last;
	    while(curr.getNext()!=last)	
		curr = curr.getNext();
	    last = curr;
	    curr.setNext(last.getNext().getNext());
	    size--;
	}	
    }
    
    public void rotate(){
	if(!isEmpty())
	    last = last.getNext();
    }

    public String toString(){
	if(last==null) return "{}";
	String answer = "{";
	Node<T> curr = last.getNext();
	for(int i=0;i<size;i++){
	    answer+=curr.getValue();
	    if(curr != last) answer+=",";
	    curr = curr.getNext();
	}
	answer +="}";
	return answer;
    }
}
