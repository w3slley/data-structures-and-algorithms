import java.util.Scanner;
import java.util.Arrays;
class Binary{
    String digits;
    int[] ks;
    int max=0;
    
    public void read(Scanner stdin){
	int n = stdin.nextInt();
	stdin.nextLine();
	digits = stdin.nextLine();
	int q = stdin.nextInt();
	ks = new int[q];
	for(int i=0;i<q;i++)
	    ks[i] = stdin.nextInt();

	for(int i=0;i<q;i++)
	    process(ks[i]);
	System.out.println(max);
    }

    public void process(int k){
	int sum=0;
	for(int i=0;i<digits.length();i++){
	    int c = digits.charAt(i);
	    
	    if(c == '1')
		sum++;
	    
	    if(c == '0' && sum != 0){
		if(sum > max) max = sum;
		sum = 0;
	    }
	    //System.out.println(digits.charAt(i));
	}
    }
}
class ED238{
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	Binary b = new Binary();
	b.read(stdin);
    }
}
