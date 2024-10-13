class Test{
    public static void main(String[] args){
	SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
	list.addLast(1);
	list.addLast(1);
	list.addLast(1);
	list.addLast(1);
	list.addLast(1);
	list.addLast(1);
	list.addLast(1);
	list.addLast(2);
	System.out.println(list);
	list.removeAll(1);
	System.out.println(list);
    }
}
