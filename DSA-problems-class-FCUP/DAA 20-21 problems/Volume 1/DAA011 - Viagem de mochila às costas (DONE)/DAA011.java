import java.util.Scanner;
import java.util.Arrays;
class DAA011{
    public static int sum(int[] arr){
	int s = 0;
	for(int i=0;i<arr.length;i++)
	    s+=arr[i];
	return s;
    }
    public static boolean isPossible(int[] arr, int k, int x){//O(n)
	int partitions = 0;
	int sumSoFar = 0;
	for(int i=0;i<arr.length;i++){
	    if(sumSoFar + arr[i] > x){
		if(sumSoFar == 0 || arr[i]>x) return false;
		
		partitions++;
		sumSoFar = arr[i];
	    }
	    else
		sumSoFar+=arr[i];
	}
	return partitions + 1 <= k;
    }

    public static int bsearch(int[] arr, int k){
	int l = 0;
	int r = sum(arr);
	while(l<r){
	    int middle = l + (r-l)/2;
	    if(isPossible(arr,k,middle)) r = middle;
	    else l = middle + 1;
	}
	if(isPossible(arr,k,l) == false) return -1;
	return l;
    }
    
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	int n = stdin.nextInt();
	int[] arr = new int[n];
	for(int i=0;i<n;i++)
	    arr[i] = stdin.nextInt();
	
	int p = stdin.nextInt();
	for(int i=0;i<p;i++){//O(n logn)
	    int k = stdin.nextInt();
	    int pos = bsearch(arr,k);
	    System.out.println(pos);
	}
	
    }
}
