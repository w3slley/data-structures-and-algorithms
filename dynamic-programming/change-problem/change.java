import java.util.Scanner;
import java.util.Arrays;
class change{
    /*Explanation for self:*/
//first condition on line 12 makes sure to only compare in S with coins which we can use (for i=5 and S={1,5,8,11}, it will only enter the if statement for S[j]=1 and S[j]=5, because there is no way we can use the coins 8 and 11 to amount to 5 as a total result)
//left condition on line 12 makes sure that whenever we find a minimal coins[i], a future jth term in S doesn't change its value! For example, for i=10: one can take 10 coins with value 1 (coins[i]=10), or 2 coins with value 5 (coins[i]=2). When it enters for S[j]=8, coins[10-8=2]=2+1=3 which is greater than the value that was in coins[i] (2) and thus it won't enter the if statement
    public static void calculate(int[] coins, int[] use, int[] s, int k){
	coins[0] = 0;
	for(int i=1;i<=k;i++){
	    coins[i] = 1000000000;
	    for(int j=0;j<s.length;j++){
		if(s[j]<=i && 1+coins[i-s[j]] < coins[i]){
		    coins[i] = 1 + coins[i-s[j]];
		    use[i] = s[j];
		}
	    }
	}
    }

    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	int n = stdin.nextInt();
	int[] S = new int[n];
        for(int i=0;i<n;i++)
	    S[i] = stdin.nextInt();
	int M = stdin.nextInt();
	for(int i=0;i<M;i++){
	    int k = stdin.nextInt();
	    int[] coins = new int[k+1];
	    int[] use = new int[k+1];
	    calculate(coins,use,S,k);
	    System.out.print(k+": ["+coins[k]+"]");
	    int temp = k;
	    while(temp != 0){
		System.out.print(" "+use[temp]);
		temp = temp-use[temp];
	    }
	    System.out.println();
	}
    }
}
