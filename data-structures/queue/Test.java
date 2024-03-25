class Test{
    public static void main(String[] args){
	MyQueue<Integer> q = new LinkedListQueue<Integer>();
	q.enqueue(1);
	q.enqueue(2);
	q.enqueue(3);
	q.enqueue(4);
	q.enqueue(5);
	System.out.println(q);
	System.out.println(q.dequeue());
	q.dequeue();
	System.out.println(q);
    }
}

