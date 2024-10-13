import java.util.Scanner;
import java.util.Arrays;

class DAA015{
    public static int max(int[] balloons){
	int max = 0;
	for(int i=0;i<balloons.length;i++)
	    max = Math.max(max,balloons[i]);
	return max;
    }

    public static int sum(int[] arr){
	int total = 0;
	for(int i=0;i<arr.length;i++)
	    total+=arr[i];
	return total;
    }
    
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	int n = stdin.nextInt();
	int[] balloons = new int[n];
	for(int i=0;i<n;i++){
	    balloons[i] = stdin.nextInt();
	}
	int maxHeights = max(balloons);

	int[] hs = new int[maxHeights+1];
	//System.out.println(Arrays.toString(balloons));
	int numArrows = 0;
	//loop throught heights from end to beginning
	for(int i=n-1;i>-1;i--){
	    //System.out.println(i);
	    hs[balloons[i]]++;
	    if(hs[balloons[i]-1] != 0 && balloons[i]!=1){
		hs[balloons[i]-1]--;
	    }
	}
	System.out.println(sum(hs));
    }
}
