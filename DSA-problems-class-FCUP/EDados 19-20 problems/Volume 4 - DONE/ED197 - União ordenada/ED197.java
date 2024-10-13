class ED197{
    public static MyQueue<Integer> merge(MyQueue<Integer> a, MyQueue<Integer> b){
	MyQueue<Integer> n = new LinkedListQueue<Integer>();
	while(true){
	    if(a.isEmpty() && b.isEmpty()) break;
	   
	    if(a.isEmpty()) {
		n.enqueue(b.dequeue());
		continue;
	    }
	    if(b.isEmpty()){
		n.enqueue(a.dequeue());
		continue;
	    }
	    
	    if(a.first() > b.first()) n.enqueue(b.dequeue());
	    else n.enqueue(a.dequeue());
	    
	}
	return n;
    }
}
