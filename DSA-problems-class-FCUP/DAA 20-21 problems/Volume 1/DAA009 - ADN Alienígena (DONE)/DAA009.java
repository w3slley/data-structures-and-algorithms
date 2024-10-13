import java.util.Scanner;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.Set;

class DNALetter implements Comparable<DNALetter>{
    char letter;
    int frequency;
    int posFirstOcc;
    
    DNALetter(char l, int f, int p){
	this.letter = l;
	this.frequency = f;
	this.posFirstOcc = p;
    }
    
    public int compareTo(DNALetter d){
	if(d.frequency != this.frequency)
	    return d.frequency - this.frequency;

	return this.posFirstOcc - d.posFirstOcc;
    }

    public String toString(){
	return letter + " " + frequency;
    }
}


class DAA009{
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	String s = stdin.next();
	TreeMap<Character, Integer[]> dnas = new TreeMap<>();  
	for(int i=0;i<s.length();i++){
	    char letter = s.charAt(i); 
	    Integer[] count = dnas.get(letter);
	    if (count != null){
		count[0] += 1;//first element of array corresponds to frequency of char
		dnas.put(letter, count);
	    }
	    else{
		Integer[] arr = {1,i};//second element of array corresponds to first position of element
		dnas.put(letter,arr);
	    }
	}

	DNALetter[] dnaArray = new DNALetter[dnas.size()];
	int i=0;
	for(Character l : dnas.keySet()){
	    Integer[] result = dnas.get(l);
	    DNALetter d = new DNALetter(l, result[0], result[1]);
	    dnaArray[i] = d;
	    i++;
	}
	Arrays.sort(dnaArray);
	for(DNALetter d : dnaArray)
	    System.out.println(d);
	
    }
}
