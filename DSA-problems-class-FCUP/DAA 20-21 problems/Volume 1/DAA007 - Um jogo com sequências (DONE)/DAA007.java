class DAA007{
    public static int max(int[] arr){
	int max = arr[0];
	for(int i=0;i<arr.length;i++){
	    max = Math.max(arr[i],max);
	}
	return max;
    }
    
    public static int kadane(int[] arr){
	int[] best = new int[arr.length];
	best[0] = arr[0];
	for(int i=1;i<arr.length;i++){
	    if(best[i-1]>0)
		best[i] = best[i-1]+ arr[i];
	    else
		best[i] = arr[i];
	}
	return max(best);
    }
    public static void main(String[] args){
	FastScanner stdin = new FastScanner(System.in);
	int n = stdin.nextInt();
	int[] numbers = new int[n];
	for(int i=0;i<n;i++){
	    numbers[i] = stdin.nextInt();
	}
	
	System.out.println(kadane(numbers));
    }
}
