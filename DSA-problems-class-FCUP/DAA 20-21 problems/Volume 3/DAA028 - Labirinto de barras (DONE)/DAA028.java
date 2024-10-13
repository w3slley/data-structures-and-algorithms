import java.util.*;
class Point{
    int y;
    int x;
    Point(int y, int x){
	this.y = y;
	this.x = x;
    }

    public String toString(){
	return "(y: "+y+",x: "+x+")";
    }
}
class DAA028{
    static int MAX = 300;
    static int scale = 3;
    static char[][] maze = new char[MAX][MAX];
    static int L;
    static int C;
    //directions (up,down,right,left)
    static int numDir = 4;
    static int[] xdir = {0,0,1,-1};
    static int[] ydir = {-1,1,0,0};

    public static void constructMaze(int y, String line){
	for(int x=0;x<C;x++){
	    int yy = y*scale;
	    int xx = x*scale;
	    for(int a=0;a<scale;a++)
		for(int b=0;b<scale;b++)
		    maze[yy+a][xx+b] = '.';
	    //filling 3x3 grid with scaled slash
	    if(line.charAt(x) == '\\'){
		for(int k=0;k<scale;k++)
		    maze[yy+k][xx+k] = '#';
	    }
	    else {
		for(int k=0;k<scale;k++)
		    maze[yy+k][xx+scale-k-1] = '#';
	    }
	}
    }
    public static void printMaze(){
	for(int i=0;i<L;i++){
	    for(int j=0;j<C;j++)
		System.out.print(maze[i][j]+" ");
	    System.out.println();
	}
    }

    public static boolean hasCycle(int y, int x,int[] longest){
	Queue<Point> queue = new LinkedList<>();
	int length = 1;
	boolean hasCycle = true;
	queue.add(new Point(y,x));
	while(!queue.isEmpty()){
	    length++;
	    Point curr = queue.poll();
	    for(int i=0;i<numDir;i++){
		Point neighbor = new Point(curr.y+ydir[i],curr.x+xdir[i]);
		if(neighbor.y<0||neighbor.y>=L||neighbor.x<0||neighbor.x>=C){
		    hasCycle = false;//we arrived at the edge of the maze, so there is no cycle on this path
		    continue;//invalid positions, so continue to the next one
		}
		if(maze[neighbor.y][neighbor.x]=='.'){//if position wasn't visited yet, mark as visited and go there
		    //System.out.println(neighbor);
		    maze[neighbor.y][neighbor.x] = '#';
		    queue.add(neighbor);
		}
	    }
	}

	if(!hasCycle) return false;//if hasCycle is false, then we got to the edge of the maze (thus no cycle)
	//otherwise, scale back length and update longest value
	length/=scale;//this length is scaled, so divide by the amount scaled
	if(length>longest[0])longest[0] = length;
	return true;
    }
    
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	C = stdin.nextInt();
	L = stdin.nextInt();
	stdin.nextLine();
	for(int i=0;i<L;i++){
	    String l = stdin.nextLine();
	    constructMaze(i,l);
	}
	L*=scale;
	C*=scale;
	int[] longest = {0};
	int numCycles = 0;
	for(int i=0;i<L;i++){
	    for(int j=0;j<C;j++){
		if(maze[i][j]=='.'){
		    if(hasCycle(i,j,longest))
			numCycles++;
		    //printMaze();
		    //System.out.println("hasCycle: "+hc+", longest: "+longest[0]);
		    //System.out.println();
		}
	    }
	}
	if(numCycles==0)
	    System.out.println("nao tem ciclos");
	else
	    System.out.println(numCycles+" "+longest[0]);
    }
}
