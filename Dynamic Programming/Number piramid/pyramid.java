import java.util.Scanner;
import java.util.Arrays;
class pyramid{
    static Scanner stdin = new Scanner(System.in);
    static int n = stdin.nextInt();

    public static void calculate_best(int[][] p){
	for(int i=n-1;i>0;i--)
	    for(int j=1;j<=i;j++)
		p[i][j] = p[i][j] + Math.max(p[i+1][j], p[i+1][j+1]);
    }
    
    public static void main(String[] args){
	int[][] p = new int[n+1][n+1];
	for(int i=1;i<=n;i++)
	    for(int j=1;j<=i;j++)
		p[i][j] = stdin.nextInt();
	//System.out.println(Arrays.deepToString(p));
	calculate_best(p);
	System.out.println("best sum = "+p[1][1]);
	//System.out.println(Arrays.deepToString(p));
    }
}
