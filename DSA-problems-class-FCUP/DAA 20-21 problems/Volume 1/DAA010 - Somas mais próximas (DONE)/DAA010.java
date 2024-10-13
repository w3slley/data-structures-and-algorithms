import java.util.Scanner;
import java.util.Arrays;
class DAA010{
    public static int bsearch(int[] sums, int q){
	int l = 0;
	int r = sums.length-1;
	while(l<r){
	    int m = l + (r-l)/2;
	    if(sums[m] >= q)
		r = m;
	    else
		l = m + 1;
	}
	if(sums[l] < q) return -1;

	return l;

    }
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	int n = stdin.nextInt();
	int[] arr = new int[n];
	for(int i=0;i<n;i++)
	    arr[i] = stdin.nextInt();
	int[] sums = new int[n*(n-1)];
	int k = 0;
	for(int i=0;i<n;i++){
	    for(int j=0;j<n;j++){
		if(i!=j) {
		    sums[k] = arr[i]+arr[j];
		    k++;
		}
	    }
	}

	Arrays.sort(sums);

	int q = stdin.nextInt();
	for(int i=0;i<q;i++){
	    int qi = stdin.nextInt();
	    int initPos = bsearch(sums,qi);
	    
	    if(initPos!= -1){
		if(sums[initPos]==qi)
		    System.out.println(qi);
		else{
		    if(initPos == 0)
			System.out.println(sums[0]);
		    else{
			if(sums[initPos]-qi < qi - sums[initPos-1])
			    System.out.println(sums[initPos]);
			else if(sums[initPos]-qi > qi - sums[initPos-1])
			    System.out.println(sums[initPos-1]);
			else
			    System.out.println(sums[initPos-1]+" "+sums[initPos]);
		    }
		}
	    }
	    else{
		System.out.println(sums[sums.length-1]);
	    }
	}
    }
}
