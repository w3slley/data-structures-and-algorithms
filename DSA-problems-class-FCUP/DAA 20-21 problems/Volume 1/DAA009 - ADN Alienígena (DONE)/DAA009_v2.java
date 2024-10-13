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

class DAA009_v2{
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	String letters = stdin.next();
        DNALetter[] dnas = new DNALetter[26];
	for(int i=0;i<dnas.length;i++)
	    dnas[i] = new DNALetter((char) ('A'+i),0,-1);
	    	
	for(int i=0;i<letters.length();i++){
	    char l = letters.charAt(i);
	    if(dnas[l-'A'].posFirstOcc==-1) dnas[l-'A'].posFirstOcc = i;
	    dnas[l-'A'].frequency++;
	}

	Arrays.sort(dnas);
	
	for(int i=0;i<dnas.length;i++)
	    if(dnas[i].frequency!=0) System.out.println(dnas[i]);
    }
}
