class ED197{
    public static MyQueue<Integer> merge(MyQueue<Integer> a, MyQueue<Integer> b){
	MyQueue<Integer> newQueue = new LinkedListQueue<Integer>();
	while(true){
	    if(a.isEmpty() && b.isEmpty()) break;
	   
	    if(a.isEmpty()) {
		newQueue.enqueue(b.dequeue());
		continue;
	    }
	    if(b.isEmpty()){
		newQueue.enqueue(a.dequeue());
		continue;
	    }
	    
	    if(a.first() > b.first()) newQueue.enqueue(b.dequeue());
	    else newQueue.enqueue(a.dequeue());
	    
	}
	return newQueue;
    }
}

class Test{
    public static void main(String[] args){
	MyQueue<Integer> a = new LinkedListQueue<Integer>();
	MyQueue<Integer> b = new LinkedListQueue<Integer>();
	a.enqueue(1);
	a.enqueue(2);
	a.enqueue(4);
	a.enqueue(5);
	b.enqueue(2);
	b.enqueue(3);
	b.enqueue(5);
	b.enqueue(6);
	b.enqueue(8);
	System.out.println(a);
	System.out.println(b);
	System.out.println(ED197.merge(a, b));
	
    }
}
