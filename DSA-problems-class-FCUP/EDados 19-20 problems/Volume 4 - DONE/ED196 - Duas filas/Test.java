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

class Test{
    public static void main(String[] args){
	MyQueue<String> q = new LinkedListQueue<String>();
	MyQueue<String> a = new LinkedListQueue<String>();
	MyQueue<String> b = new LinkedListQueue<String>();
	q.enqueue("Luis");
	q.enqueue("B");
	q.enqueue("Pedro");
	q.enqueue("B");
	q.enqueue("Luisa");
	q.enqueue("X");
	q.enqueue("Joao");
	q.enqueue("X");
	//q.enqueue("Miguel");
	//q.enqueue("B");
	System.out.println("q = "+q);
	System.out.println("a = "+a);
	System.out.println("b = "+b);
	ED196.process(q,a,b);
        System.out.println("q = "+q);
	System.out.println("a = "+a);
	System.out.println("b = "+b);
    }
}
