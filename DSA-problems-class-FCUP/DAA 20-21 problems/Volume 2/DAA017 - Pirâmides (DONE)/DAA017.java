import java.util.Scanner;
class DAA017{
    public static void calculate(long[][] p, int N){
	for(int i=N-2;i>-1;i--){
	    for(int j=0;j<=i;j++){
		if(p[i][j]==-1) p[i][j] = 0;
		else if(i==N-2){
		    p[i][j] = 0; //N-1 layer starts with 0 valid moves
		    if(p[i+1][j]==1) p[i][j]++;
		    if(p[i+1][j+1]==1) p[i][j]++;
		}
		else p[i][j] = p[i+1][j] + p[i+1][j+1];
	    }
	}
    }
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	int N = stdin.nextInt();
        long[][] p = new long[N][N];
	for(int i=0;i<N;i++)
	    for(int j=0;j<=i;j++)
		p[i][j] = 1;
	int D = stdin.nextInt();
	for(int k=0;k<D;k++){
	    int C = stdin.nextInt();
	    int P = stdin.nextInt()-1;
	    p[N-C][P] = -1;
	}
	calculate(p,N);
	System.out.println(p[0][0]);
    }
}
