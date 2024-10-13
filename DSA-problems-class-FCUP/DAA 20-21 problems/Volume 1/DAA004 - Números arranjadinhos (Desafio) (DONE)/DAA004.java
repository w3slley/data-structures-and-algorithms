import java.util.Scanner;

class DAA004{
    static int sumDigits(long num){
	int sum = 0;
	while(num!=0){
	    sum+=num%10;
	    num/=10;
	}
	return sum;
    }

    static long increaseSum(long n, int k){
	int diff = k - sumDigits(n);
	long aux = n;
	long mult = 10;
	while(diff > 0){
	    long num = (aux%mult)/(mult/10); //gets each digit going from the right to the left
	    
	    long numToSum = 9 - num;
	    if(numToSum>diff) 
		numToSum = diff;
	    
	    aux+= numToSum*mult/10;
	    diff-= numToSum;
	    mult*=10;
	}
	return aux;
    }

    static long findNextNumber(long n, int k){
	if(k - sumDigits(n) > 0)
	    return increaseSum(n+1,k);
	else{
	    long aux;
	    long mult = 1;
	    aux = k==sumDigits(n)?n+1:n;
	    
	    while(sumDigits(aux) >= k){
		aux /= 10;
		mult *= 10;
		    
	    }
	    aux++;
	    return increaseSum(aux*mult, k);
	
	}
    }

    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	int t = stdin.nextInt();
	for(int i=0;i<t;i++){
	    long n;
	    int k;
	    n = stdin.nextLong();
	    k = stdin.nextInt();
	    System.out.println(findNextNumber(n, k));
	}
    }
}
