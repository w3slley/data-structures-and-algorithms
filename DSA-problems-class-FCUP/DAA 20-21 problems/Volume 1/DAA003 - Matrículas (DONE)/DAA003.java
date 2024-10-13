import java.util.Scanner;
import java.util.Arrays;
class Plate{
    int number = 0;
    int generation;
    String code;
    
    Plate(String str){
	this.code = str;
	setGeneration(str);
	setNumber();
    }

    int getDistance(Plate p2){
	return Math.abs(this.number - p2.number);
    }

    int fixAlphabet(char c){
	int num = c - 'A';
	if(c > 'K' && c < 'W') num-=1;
	else if(c > 'W' && c < 'Y') num-=2;
	else if(c > 'Y') num-=3;
	return num;
    }

    void setNumber(){
	//integers between 0 and 22 based on position of letter in the alphabet (A is 0, B is 1, ..., Z is 22) 
	int letterLeft = -1;
	int letterRight = -1;
	//initial position for each number in a given generation. If the plate if from the 2nd generation, every number on them has to be shifted initPos = 5290000 because the 1rst that is the amount of plates possible in the 1rst generation
	int initPos = 0;
	if(this.generation == 1){// XX-NN-NN, generation 1 plate numbers go from 1 to 5,290,000
	    letterLeft = fixAlphabet(this.code.charAt(0));
	    letterRight = fixAlphabet(this.code.charAt(1));
	}
	else if(this.generation == 2){// NN-NN-XX, generation 2 plate numbers go from 5,290,001 to 10,580,000
	    letterLeft = fixAlphabet(this.code.charAt(code.length()-2));
	    letterRight = fixAlphabet(this.code.charAt(code.length()-1));
	    initPos = 5290000;
	}
	else if(this.generation == 3){// NN-XX-NN, generation 3 plate number goes from 10580001 to 15870000
	    letterLeft = fixAlphabet(this.code.charAt(3));
	    letterRight = fixAlphabet(this.code.charAt(4));
	    initPos = 10580000;
	}
	//assigning number to plate based on each parameter (which depend on each generation)
	this.number = initPos + letterLeft*230000 + letterRight*10000 + getNumbersFromCode() + 1;

	//If the plate is from the 4th generation, do this instead
	if(this.generation == 4){//XX-NN-XX
	    char[] letters = getLettersFromCode();
	    int[] vals = new int[4];
	    for(int i=0;i<vals.length;i++){
		vals[i] = fixAlphabet(letters[i]);
	    }
	    this.number = 15870000 + vals[0]*1216700 +vals[1]*52900 + vals[2]*2300+ vals[3]*100 + getNumbersFromCode() + 1;
	}
    }
    
    void setGeneration(String str){
	if(isLetter(str.charAt(0)) && isNumber(str.charAt(str.length()-1))){
	    this.generation = 1;
	}	
	else if(isNumber(str.charAt(0)) && isLetter(str.charAt(str.length()-1))){
	    this.generation = 2;
	}	
	else if(isNumber(str.charAt(0)) && isNumber(str.charAt(str.length()-1))){
	    this.generation = 3;
	}	
	else{
	    this.generation = 4;
	}
    }
    
    boolean isNumber(char c){
	return c >='0' && c<='9';
    }

    boolean isLetter(char c){
	return c>='A' && c<='Z';
    }

    int getNumbersFromCode(){
	int num = 0;
	int cumul;
	if(this.generation == 4)
	    cumul = 10;
	else
	    cumul = 1000;
	for(int i=0;i<this.code.length();i++){
	    if(isNumber(this.code.charAt(i))){
		num += (this.code.charAt(i) - '0') * cumul;
		cumul /= 10;
	    }
	}
	return num;
    }

    char[] getLettersFromCode(){
	char[] letters;
	if(this.generation == 4) letters = new char[4];
	else letters = new char[2];
	int pos = 0;
	for(int i=0;i<this.code.length();i++){
	    char l = this.code.charAt(i);
	    if(isLetter(l))
		letters[pos++] = l;
	}
	return letters;
    }

    public String toString(){
	return this.code;
    }	
}

class DAA003{
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	int n = stdin.nextInt();
	for(int i=0;i<n;i++){
	    Plate p1 = new Plate(stdin.next());
	    Plate p2 = new Plate(stdin.next());
	    System.out.println(p1.getDistance(p2));
	}
    }
}
