class Test{
    public static void main(String[] args){
	MyDeque<Integer> deque = new LinkedListDeque<Integer>();

	deque.addFirst(1);
	deque.addLast(2);
	deque.addLast(3);
	deque.addFirst(4);
	deque.addLast(5);

	System.out.println(deque);
	deque.removeFirst();
	deque.removeFirst();
	deque.removeLast();
	System.out.println(deque);
    }
}
