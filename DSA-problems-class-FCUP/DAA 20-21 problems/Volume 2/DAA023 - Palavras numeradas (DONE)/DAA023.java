import java.util.*;
class DAA023{
    static Integer p = 1; //Keeps track of the order of the words that will be generated 
    static TreeMap<String, Integer> map = new TreeMap<>(); //Map that stores pair (word, p), where p is the position of the word in the ordered list

    //Recursive method that generates all the words from a (p = 1) to vwxyz (p = 83681)
    public static void generate(int size, String str, int pos){
	if(pos == size){//when we get to the size of the word we want, add (word,p) pair to map and increase p
	    map.put(str,p);
	    //System.out.println("str: "+str+", p: "+p);
	    p++;
	    return;
	}
	char startingPoint = 'a';//start loop with the char 'a' in the beginning (pos = 0)
	if(pos>0) startingPoint = (char) (str.charAt(pos-1)+1); //for pos > 0, we have to start not from 'a' but from the letter after the last one (ex: if we are on pos = 2 in the word "ab", the next starting point will be 'c' ('b' + 1)
	
	//loop through all the letters of the alphabet and call recursively increasing the position we are in the string and also concatenating the current letter with the word we are forming
	for(char word=startingPoint;word<='z';word++){
	    generate(size,str+word,pos+1);
	}
    }
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	int n = stdin.nextInt();
	
	//generate all numbers in the ordered list of words!
	for(int i=1;i<=5;i++)
	    generate(i,"",0);

	for(int k=0;k<n;k++){//O(n)
	    String str = stdin.next();
	    if(str.length() <= 5){//testing if word is valid
		Integer val = map.get(str); //if the order of the letters are wrong, val will be null since there is no such word in the ordered list
		if(val==null)
		    System.out.println("0");
		else
		    System.out.println(val);
	    }
	}
    }
}
