class Test{
    public static void main(String[] args){
	SinglyLinkedList<Character> list = new SinglyLinkedList<>();
	list.addLast('a');
	list.addLast('b');
	list.addLast('c');
	list.addLast('d');
	list.addLast('e');
	//System.out.println(list);
	//System.out.println(list.cut(2,3));

	list.shift(3);
	System.out.println(list);
    }
}
