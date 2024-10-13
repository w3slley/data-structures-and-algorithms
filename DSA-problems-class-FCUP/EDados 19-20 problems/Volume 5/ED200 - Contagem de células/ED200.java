import java.util.Scanner;
class Count{
    char[][] m;
    int cols;
    int rows;
    boolean[][] visited;
    int[] values;

    public void read(Scanner stdin){
	rows = stdin.nextInt();
	cols = stdin.nextInt();
	m = new char[rows][cols];
	visited = new boolean[rows][cols];
	for (int i=0; i<rows; i++)
	    m[i] = stdin.next().toCharArray();
    }
    
    public int floodfill(int y, int x){
	if(y<0 || y>=rows || x<0 || x>=cols) return 0;
	if(visited[y][x]) return 0;
	if(m[y][x]=='.') return 0;
	int count=1;
	visited[y][x] = true;
	//diagonal
	count += floodfill(y+1,x+1);
	count += floodfill(y-1,x+1);
	count += floodfill(y+1,x-1);
	count += floodfill(y-1,x-1);

	//horizontal+vertical
	count += floodfill(y,x+1);
	count += floodfill(y,x-1);
	count += floodfill(y+1,x);
	count += floodfill(y-1,x);
	return count;
    }

    public void getMax(){
	int max = 0;
	for(int i=0;i<rows;i++)
	    for(int j=0;j<cols;j++){
		int val = floodfill(i,j);
		if(val>max) max = val;
	    }
	System.out.println(max);
    }
}

class ED200{
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	int n = stdin.nextInt();
	for(int i=0;i<n;i++){
	    Count c = new Count();
	    c.read(stdin);
	    c.getMax();
	}
	
    }
}
