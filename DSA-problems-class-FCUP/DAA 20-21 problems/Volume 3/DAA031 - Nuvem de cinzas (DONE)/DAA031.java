import java.util.*;

class Point{
    int x;
    int y;
    char state;
    boolean visited;
    int distance;

    Point(char s, int y, int x){
	this.state = s;
	this.x = x;
	this.y = y;
	this.visited = (s=='#');
	this.distance = 0;
    }

    public String toString(){
	return "[("+y+","+x+") '"+state+"' "+distance+"]";
    }
}

class DAA031{
    static Point[][] m;
    static int rows;
    static int cols;
    //directions (right,left,up,down)
    static int numDir = 4;
    static int[] ydir = {0,0,1,-1};
    static int[] xdir = {1,-1,0,0};
    
    public static void bfs(LinkedList<Point> clouds){
	Queue<Point> queue = new LinkedList<>();
	for(Point p : clouds) queue.add(p);//adding all cloud nodes to queue
	
	while(!queue.isEmpty()){
	    Point curr = queue.poll();
	    for(int i=0;i<numDir;i++){//iterating over nodes next to curr node
		if(curr.x + xdir[i] < 0 || curr.x + xdir[i] >= cols || curr.y + ydir[i] < 0 ||curr.y + ydir[i] >= rows) continue;
		int nx = curr.x+xdir[i];
		int ny = curr.y+ydir[i];
		if(!m[ny][nx].visited){
		    queue.add(m[ny][nx]);
		    m[ny][nx].visited = true;
		    m[ny][nx].distance = curr.distance + 1;
		}
	    }
	}
    }
    
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	rows = stdin.nextInt();
	cols = stdin.nextInt();
	m = new Point[rows][cols];
	LinkedList<Point> clouds = new LinkedList<>();
	LinkedList<Point> airports = new LinkedList<>();
	for(int i=0;i<rows;i++){
	    String s = stdin.next();
	    for(int j=0;j<cols;j++){
		m[i][j] = new Point(s.charAt(j),i,j);
		if(m[i][j].state == '#') clouds.add(m[i][j]);
		if(m[i][j].state == 'A') airports.add(m[i][j]);
	    }
	}
	bfs(clouds);

	int max = Integer.MIN_VALUE;
	int min = Integer.MAX_VALUE;
	for(Point p : airports){
	    max = Math.max(max,p.distance);
	    min = Math.min(min,p.distance);
	}
	
	System.out.println(min+" "+max);
    }
}
