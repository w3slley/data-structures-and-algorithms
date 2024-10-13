import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

class Word{
    public void process(Scanner stdin){
	TreeMap<String, Integer> map = new TreeMap<>();
	while(stdin.hasNext()){
	    String word = stdin.next();
	    Integer i = map.get(word);
	    if(i == null) map.put(word,1);
	    else map.put(word, i+1);
	}

	Set<String> list = map.keySet();
	for(String word : list){
	    System.out.println(word + ": " + map.get(word));
	}
    }
}

class ED172 {
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	Word w = new Word();
	w.process(stdin);
    }
}
