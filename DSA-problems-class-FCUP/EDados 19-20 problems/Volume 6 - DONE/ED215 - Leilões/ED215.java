import java.util.Scanner;
import java.util.LinkedList;

class Offer implements Comparable<Offer>{
    public String type;
    public String name;
    public Integer value;

    Offer(String type, String name, int value){
	this.type = type;
	this.name = name;
	this.value = value;
    }

    public int compareTo(Offer o){
	return -value.compareTo(o.value);//what I did was just add a minus sign to invert how the offers are compared (the priority now is based on how big the value is)
    }
    
    public String toString(){
	return type + " " + name + " " + value;
    }
}

class Auction{
    MinHeap<Offer> heap;
    LinkedList<Offer> list;
    Auction(){
	heap = new MinHeap<>(10000);
	list = new LinkedList<>();
    }
    public void process(Scanner stdin){
	int n = stdin.nextInt();
	stdin.nextLine();
	for(int i=0;i<n;i++){
	    String line = stdin.nextLine();
	    if(line.equals("VENDA")){
	        list.addLast(heap.removeMin());
		continue;
	    }
	    String[] l = line.split(" ");
	    String type = l[0];
	    String name = l[1];
	    int value = Integer.parseInt(l[2]);
	    Offer o = new Offer(type, name, value);
	    heap.insert(o);
	}
	for (Offer o : list)
	    System.out.println(o.value+" "+o.name);
    }
}

class ED215{
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	Auction a = new Auction();
	a.process(stdin);
    }
}
