import java.util.Scanner;
import java.util.Arrays;
class Sequence{
    public int[] s;

    public void read(Scanner stdin){
	int n = stdin.nextInt();
	s = new int[n];
	for(int i=0;i<n;i++)
	    s[i] = stdin.nextInt();
    }

    public void getResult(){
	int[] best = new int[s.length];
	best[0] = s[0];//base case
	for(int i=1;i<s.length;i++){
	    if(best[i-1]>0) //if positive, add sequence item to sum
		best[i] = best[i-1]+s[i];
	    else //if negative, the sum is less then sequence item, so don't add
		best[i] = s[i];
	}
	int maxSum = best[0];//initially assume the max sum is the first int on array best
        for(int i=1;i<best.length;i++){
	    if(best[i]>maxSum) maxSum=best[i];
	}
	System.out.println(maxSum);
    }
}

class ED198{
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	Sequence s = new Sequence();
	s.read(stdin);
	s.getResult();
    }
}
