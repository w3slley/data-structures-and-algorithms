class TestLinkedList{
    public static void main(String[] args){
	SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
	list.addFirst(1);
	list.addLast(2);
	list.addLast(3);
	list.addFirst(100);
	list.addLast(2);
	System.out.println(list);
	list.remove(0);
	list.remove(2);
	list.remove(1);
	list.remove(0);
	list.remove(0);
	list.remove(0);
	System.out.println(list);
	
    }
}
