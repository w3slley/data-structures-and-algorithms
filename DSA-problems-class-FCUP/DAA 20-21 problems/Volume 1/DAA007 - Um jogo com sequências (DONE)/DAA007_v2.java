class DAA007_v2{
    public static int maxSum(int[] arr, int a, int b){
	if(a == b) return arr[a];
	int middle = b + (a-b)/2;
	int best1 = maxSum(arr,a,middle);
	int best2 = maxSum(arr,middle+1,b);
	//int best3 = ;
	//return max(max(best1,best2),best3);
	return max(best1,best2);
    }
    
    public static void main(String[] args){
	FastScanner stdin = new FastScanner(System.in);
	int n = stdin.nextInt();
	int[] numbers = new int[n];
	for(int i=0;i<n;i++){
	    numbers[i] = stdin.nextInt();
	}
	FastPrint.out.println(maxSum(numbers, 0, numbers.length-1));
	FastPrint.out.close();
    }
}
