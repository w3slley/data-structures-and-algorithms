import java.util.Scanner;
import java.util.Arrays;
class lis{
    public static int n;
    public static int longest(int[] arr){
	int[] best = new int[n];
	best[n-1] = 1;
	for(int i=n-2;i>-1;i--){
	    best[i] = 1;
	    for(int j=i;j<n;j++)
		if(arr[i] < arr[j] && best[i] < best[j] + 1)
		    best[i] = 1 + best[j];
	}
	int max = 0;
	for(int i=0;i<n;i++) max = Math.max(max, best[i]);
	return max;
    }
    
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	n = stdin.nextInt();
	int[] nums = new int[n];
	for(int i=0;i<n;i++)
	    nums[i] = stdin.nextInt();
	System.out.println("Answer = "+longest(nums));
	
    }
}
