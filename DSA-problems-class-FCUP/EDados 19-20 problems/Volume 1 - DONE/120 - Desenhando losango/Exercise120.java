import java.util.Scanner;

class Exercise120{
	static String writeLine(int n, int total){
		char[] arr = new char[total];
		int middlePos = (total-1)/2;
		int posFromMiddle = (n-1)/2;
		String x = "";
		for(int i=0;i<arr.length;i++){
			if(i >= middlePos - posFromMiddle & i<= middlePos + posFromMiddle){
				arr[i] = '#';
			}
			else{
				arr[i] = '.';
			}
		}
		for(int k=0;k<arr.length;k++){
			x+=arr[k];	
		}
		return x;
	}
	static void drawLosango(int n){ //n is odd
		int decreasing = n;
		for(int i=0;i<n;i++){
			if(2*i+1<n){//goes till the middle
				System.out.println(writeLine(2*i+1, n));
			}
			else{//after middle, odd numbers decrease each line by a factor of 2
				System.out.println(writeLine(decreasing, n));
				decreasing-=2;
			}
		}
	}
	public static void main(String[] args){
		Scanner stdin = new Scanner(System.in);
		int n = stdin.nextInt();		
		drawLosango(n);
	}
}