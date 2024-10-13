import java.util.Scanner;
import java.util.Arrays;
class DAA019{
    public static int count(String num, int l, int r, int[][] c){
	if (c[l][r] != -1) return c[l][r]; //if there is a valid value on matrix c for position l and r, return it
	if(l >= r) return 0;//r is always greater than l. When that's not the case, get out of stack
	//System.out.println("num: "+num.substring(l,r+1)+", l: "+l+", r: "+r);
	int  ans;
	if(num.charAt(l) == num.charAt(r))//when first and last digits are the same
	    ans = 0 + count(num,l+1,r-1,c);  //no digit needs to be added
	else//when they are different, we need to add one digit, but there're two ways we could do this: add a digit to the left or to the right
	    ans = 1 + Math.min(count(num,l+1,r,c), count(num,l,r-1,c));//so we use the way that uses the least number of digits
	c[l][r] = ans;//store answer into the matrix for future use
	return ans;
    }
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	int n = stdin.nextInt();
	for(int i=0;i<n;i++){
	    String num = stdin.next();
	    int L = num.length();
	    //matrix that will store number of digits to add to number from position l to r
	    int[][] c = new int[L][L];
	    //initializing matrix with unused values
	    for(int k=0;k<L;k++)
		for(int m=0;m<L;m++)
		    c[k][m] = -1;
	    System.out.println(count(num,0,L-1,c));
	    //System.out.println(Arrays.deepToString(c));
	}
    }
}
