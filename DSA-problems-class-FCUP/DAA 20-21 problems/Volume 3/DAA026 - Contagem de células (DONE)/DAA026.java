import java.util.Scanner;
import java.util.Arrays;

class DAA026{
    //smart way to keep track of the directions you need to go
    static int numDir = 8;
    static int[] incx = {1,-1,0,0,1,1,-1,-1};
    static int[] incy = {0,0,1,-1,1,-1,1,-1};
    
    public static int dfs(char[][] arr, int i, int j){
	if((i<0||i>=arr.length) || (j<0||j>=arr[0].length) || (arr[i][j]=='.')) return 0;
	int val = arr[i][j]=='#'?1:0;
	arr[i][j] = '.';//position was already visited
	int neighbors = 0;
	for(int k=0;k<numDir;k++)
	    neighbors +=dfs(arr,i+incx[k],j+incy[k]);
	return val + neighbors;
    }
    
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	int n = stdin.nextInt();
	for(int t=0;t<n;t++){
	    int rows = stdin.nextInt();
	    int cols = stdin.nextInt();
	    char[][] arr = new char[rows][cols];
	    for(int i = 0;i<rows;i++){
		String line = stdin.next();
		arr[i] = line.toCharArray();
	    }
	    int max = 0;
	    for(int i=0;i<rows;i++){
		for(int j=0;j<cols;j++){
		    if(arr[i][j]=='#'){
			int v = dfs(arr,i,j);
			if(v > max) max = v;
		    }
		}
	    }
	    System.out.println(max);
	}
    }
}
