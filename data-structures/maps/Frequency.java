import java.util.Scanner;
import java.util.LinkedList;
class Frequency{
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	BSTMap<String, Integer> map = new BSTMap<>();
	while(stdin.hasNextLine()){
	    String line = stdin.nextLine();
	    String[] names = line.split(" ");
	    Integer i = map.get(names[0]);
	    if (i == null) map.put(names[0],1);//if there's no name in the map, add it and set value to 1
	    else map.put(names[0], i+1);//if there is, add 1 to its value
	}

	LinkedList<String> names = map.keys();
	for (String s : names)
	    System.out.println(map.get(s) + " " + s);
    }
}
