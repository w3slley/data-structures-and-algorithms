import java.util.*;
class DAA024{
    public static void main(String[] args){//O(|s|+Q*|s|)
	FastScanner stdin = new FastScanner(System.in);
	String str = stdin.next();
	int n = str.length();
	int[][] uniqueChars = new int[n][n];
	//to get the unique letters from a to b, use a 2D array - operation in O(1)
	//when you need to update a letter at a position i, 

	// Fill 2D matrix
	for(int i=0;i<n;i++){
	    HashSet<Integer> set = new HashSet<>();
	    for(int j=i;j<n;j++){
		if(i==j) uniqueChars[i][j] = 1;
		else{
		    set.add(str.charAt(i));// O(1)
		    uniqueChars[i][j] = set.size();//O(1)
		}
	    }
	}
	
	int Q = stdin.nextInt();
	while(Q-->0){//O(Q)
	    int flag = stdin.nextInt();
	    if(flag == 1){//O( )
		int pos = stdin.nextInt()-1;
		String letter = stdin.next();
		
	    }
	    else if(flag == 2){//O(1)
		int a = stdin.nextInt()-1;
		int b = stdin.nextInt()-1;
		System.out.println(uniqueChars[a][b]);
	    }
	}
	FastPrint.out.close();
    }
}
