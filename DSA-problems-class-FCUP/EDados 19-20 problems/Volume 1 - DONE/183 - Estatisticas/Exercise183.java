import java.util.Scanner;

class Exercise183{
	static int amplitude(int[] arr){
		int max = 0;
		int min = arr[0];
		for(int i=0;i<arr.length;i++){
			if(arr[i] >= max){
				max = arr[i];
			}
			if(arr[i]<=min){
				min = arr[i];
			}
		}
		return max-min;
	}
	static float average(int[] arr){
		int sum = 0;
		for(int i=0;i<arr.length;i++){
			sum+=arr[i];
		}
		return (float) sum/arr.length;
	}
	public static void main(String[] args){
		Scanner stdin = new Scanner(System.in);
		int n = stdin.nextInt();
		int[] nums = new int[n];
		for(int i=0;i<n;i++){
			nums[i] = stdin.nextInt();
		}
		//float m = 4/3f;//if you want to get the whole value, use float (not double)!
		System.out.printf("%.2f\n",average(nums)); //way to format value (printf)
		System.out.println(amplitude(nums));

	}
}