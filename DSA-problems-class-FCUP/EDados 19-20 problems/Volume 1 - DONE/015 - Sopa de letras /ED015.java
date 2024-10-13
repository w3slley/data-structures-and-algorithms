import java.util.Scanner;
class WordSearch{
    private int lines, cols, numWordsWanted;
    private char[][] data;//array that stores input
    private char[][] dataHighlited;//empty array that will be returned with correct words
    private String[] words;
    //private int minLengthWords=0;
    
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
	    /* if(i==0) minLengthWords = words[0].length();
	    else if(words[i].length()<minLengthWords){
		minLengthWords = words[i].length();
		}*/
	}
    }
    public Boolean checkWord(char chr){
	for(int i=0;i<words.length;i++){
	    for(int j=0;i<words[i].length();j++){
		if(words[i].charAt(j)!=chr) break;
	    }
	}
	return true;
    }
    
    public void verifyWords(int xx, int yy, int incx, int incy){
	/*for(int n=x;n<cols;n++){
	    System.out.println(data[y][n]);
	    dataHihglited[y][n] = data[y][n];
	    }*/

	for(int m=y;m<lines;m++){
	    if(!checkWord(data[m][x])) break;
	    System.out.println(data[m][x]);
	    dataHighlited[m][x] = data[m][x];//what goes through here will be added to the dataHighlited array
	}
    }
    //perhaps the problem is here. if i could get rid of one of those loops...
    public void findWords(){
	for(int i=0;i<lines;i++){
	    for(int j=0;j<cols;j++){
		verifyWords(j,i, 0,1);//horizontal
		verifyWords(j,i,1,0);//vertical
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
class ED015{
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
