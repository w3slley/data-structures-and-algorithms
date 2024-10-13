import java.util.Scanner;
class WordSearch{
    private int lines, cols, numWordsWanted;
    private char[][] data;//array that stores input
    private char[][] dataHighlited;//empty array that will be returned with correct words
    private String[] words;
    
    WordSearch(int l, int c){
	lines = l;
	cols = c;
	data = new char[l][c];
	dataHighlited = new char[l][c];
	for (int i=0; i<lines; i++){
	    for (int j=0; j<cols; j++)
		dataHighlited[i][j] = '.';
	}
    }
    
    //reads set of data from input to the multidimensional array data
    public void read(Scanner in){
	for(int i=0;i<lines;i++)
	    data[i] = in.next().toCharArray();
	int n = in.nextInt();
        words = new String[n];
	for(int i=0;i<n;i++){
	    words[i] = in.next();
	}
    }
    public Boolean startsWith(int pos, char character){
	for(int i=0;i<words.length;i++){
	    if(words[i].charAt(pos)==character || words[i].charAt(words[i].length()-1-pos)==character) return true;
	}
	return false;
    }
    public Boolean notWord(String str){
	int n = str.length();
	for(int k=0;k<words.length;k++){
	    if(n<=words[k].length()){
		if(words[k].substring(0,n).equals(str) || words[k].substring(0,n).equals(new StringBuilder(str).reverse().toString())){
		    if(n==words[k].length()) return false;
		}
	    }
	}
	return true;
    }
    
    public void verifyWords(int x, int y, int incx, int incy){
	if(!startsWith(0, data[y][x])) return;//if str doesn't start with any of words' characters, then quit already
	String str = ""+data[y][x];
	//System.out.println(str);
	for(int xx = x, yy = y; yy<lines && xx<cols; xx+=incx, yy+=incy){
	    if(xx==x && yy==y) continue; //ignore case for current (x,y) char
	    if(xx==x+1 || yy==y+1)
		if(!startsWith(1, data[yy][xx])) return;
	    str+=data[yy][xx];
	    if(notWord(str)) continue; //checks if there are words that start with str.
	    
	    //go through position of correct words and put them into the dataHighlited array.
	    for(int a = x, b = y; a<=xx && b<=yy; a+=incx, b+=incy){
		dataHighlited[b][a] = data[b][a];
	    }
	    
	}
    }
    //perhaps the problem is here. if i could get rid of one of those loops...
    public void findWords(){
	for (int i=0; i<lines; i++){
	    for (int j=0; j<cols; j++){
		//vertical (ignore when at the right border - there is no more to the right)
		if(i!=cols-1) verifyWords(j, i, 0, 1);
		//horizontal (ignore when at the last line - there is no more words down)
		if(j!=lines-1) verifyWords(j, i, 1, 0);
	    }
	}
    }
    
    public String toString(){
	String answ = "";
        for (int i=0; i<lines; i++){
	    for (int j=0; j<cols; j++){
	        answ+=dataHighlited[i][j];
	     }
	    if(i!=lines-1) answ+="\n";
	}
	return answ;
    }			
}
class ED015Solved{
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	int n = 1;
	while(stdin.hasNext()){
	    int l = stdin.nextInt();
	    int c = stdin.nextInt();
	    if(l==0 && c==0) break;
	    WordSearch ws = new WordSearch(l,c);
	    ws.read(stdin);
	    ws.findWords();
	    System.out.println("Input #"+n);
	    System.out.println(ws);
	    n++;
	}
	
    }
}
