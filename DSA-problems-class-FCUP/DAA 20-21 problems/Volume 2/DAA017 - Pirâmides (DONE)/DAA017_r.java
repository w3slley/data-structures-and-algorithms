import java.util.Scanner;
import java.util.Arrays;
class DAA017_r{
    static int N;
    public static long validPaths(boolean[][]p, long[][] c, int i, int j){
	//System.out.println("i: "+i+", j: "+j);
	if(c[i][j]!=-1) return c[i][j];
	if(!p[i][j]) return 0;
	if(i==N-2){
	    int valid = 0;
	    if(p[i+1][j])
		valid++;
	    if(p[i+1][j+1])
		valid++;
	    return valid;
	}
	long ans = validPaths(p, c, i+1, j) + validPaths(p, c, i+1, j+1);
	c[i][j] = ans;
	return ans;
    }
    
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	N = stdin.nextInt();
        boolean[][] p = new boolean[N][N];
	for(int i=0;i<N;i++)
	    for(int j=0;j<=i;j++)
		p[i][j] = true;
	int D = stdin.nextInt();
	for(int k=0;k<D;k++){
	    int C = stdin.nextInt();
	    int P = stdin.nextInt();
	    p[N-C][P-1] = false;
	}
	    
	if(N==1)
	    System.out.println(p[0][0]?1:0);
	else{
	    long[][] c = new long[N][N];
	    for(int i=0;i<N;i++)
		for(int j=0;j<=i;j++)
		    c[i][j] = -1;
	
	    //System.out.println(Arrays.deepToString(p));
	    System.out.println(validPaths(p, c, 0, 0));
	}
    }
}
    
