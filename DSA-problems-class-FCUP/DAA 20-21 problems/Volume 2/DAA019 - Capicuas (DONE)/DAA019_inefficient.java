import java.util.Scanner;
import java.util.Arrays;
class DAA019_inefficient{
    public static int count(String num, int l, int r){
	if(l >= r) return 0;
	int val;
	System.out.println("num: "+num.substring(l,r+1)+", l: "+l+", r: "+r);
	if(num.charAt(l) == num.charAt(r)){
	    val = 0;    
	    return val + count(num,l+1,r-1);
	}
	else{
	    val = 1;
	    return val + Math.min(count(num,l+1,r), count(num,l,r-1));
	}
    }
    
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	int n = stdin.nextInt();
	for(int i=0;i<n;i++){
	    String num = stdin.next();
	    int L = num.length();
	    
	    System.out.println(count(num,0,L-1));
	}
    }
}
