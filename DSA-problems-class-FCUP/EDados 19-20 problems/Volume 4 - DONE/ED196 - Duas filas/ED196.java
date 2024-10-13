class ED196{
    public static void process(MyQueue<String> q, MyQueue<String> a, MyQueue<String> b){
	while(q.first() != null){
	    String person = q.dequeue();
	    if(q.first().equals("X")){
		if(a.size() > b.size()) b.enqueue(person);
		else if(b.size() > a.size()) a.enqueue(person); 
	    }
	    if(q.first().equals("A"))
		a.enqueue(person);
	    
	    if(q.first().equals("B"))
		b.enqueue(person);
	    q.dequeue(); //removing letters for queues
	}
    }
}
