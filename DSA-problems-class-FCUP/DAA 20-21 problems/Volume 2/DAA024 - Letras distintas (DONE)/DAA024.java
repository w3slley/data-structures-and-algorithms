import java.util.*;
class LetterPosition{
    TreeSet<Integer> set;
    LetterPosition(){
	set = new TreeSet<>();
    }

    public String toString(){
	return set+"";
    }
}

class DAA024{
    public static String print(LetterPosition[] freq, int n){
	char[] word = new char[n];
	for(int i=0;i<26;i++){
	    for(int j: freq[i].set) word[j-1] = (char) (i+'a');
	}
	return new String(word);
    }
    
    public static void main(String[] args){
	FastScanner stdin = new FastScanner(System.in);
	char[] str = (stdin.next()).toCharArray();
	LetterPosition[] freq = new LetterPosition[26];
	for(int i=0;i<freq.length;i++) freq[i] = new LetterPosition();//inicializing object
	//filling sets with position of each letter
	for(int i=0;i<str.length;i++)//O(log|s|)
	    freq[str[i]-'a'].set.add(i+1);

	int Q = stdin.nextInt();
	while(Q-->0){//O(Q*log|s|)
	    int flag = stdin.nextInt();
	    if(flag == 1){//O(log|s|)
		int pos = stdin.nextInt();
		char letter =(stdin.next()).charAt(0);
		if(letter != str[pos-1]){
		    freq[letter - 'a'].set.add(pos);//add position
		    freq[str[pos-1] - 'a'].set.remove(pos);//remove position from the set of previous letter at pos
		}
		str[pos-1] = letter; //updating letter in str array
	    }
	    else if(flag == 2){//O(log|s|)
		int a = stdin.nextInt();
		int b = stdin.nextInt();
		int count = 0;
		for(int i=0;i<freq.length;i++){//O(26*log|s|)
		    Integer top = freq[i].set.floor(b);
		    if(top != null && freq[i].set.floor(b)>=a) count++;//log(|s|)
		}
		FastPrint.out.println(count);
	    }
	    //System.out.println(print(freq,str.length));
	    //System.out.println(Arrays.toString(freq));
	}
	FastPrint.out.close();
    }
}
