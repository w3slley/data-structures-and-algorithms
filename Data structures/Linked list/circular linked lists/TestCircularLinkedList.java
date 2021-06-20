class TestCircularLinkedList{
    public static void main(String[] args){
	CircularLinkedList<String> circList = new CircularLinkedList<>();
	circList.addLast("A");
	circList.addLast("B");
	circList.addLast("C");
	circList.addLast("D");
	circList.addLast("E");
	circList.addLast("F");
	circList.addLast("G");
	System.out.println(circList);
	for(int i=0;i<circList.size();i++){
	    System.out.println(circList.getFirst());
	    circList.rotate();
	}

    }
}
