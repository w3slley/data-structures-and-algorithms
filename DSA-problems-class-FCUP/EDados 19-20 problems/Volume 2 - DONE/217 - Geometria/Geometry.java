import java.util.Scanner;

class Geometry{
    public int numPoints;
    public int numRect;
    public Point[] points;
    public Rectangle[] rectangles;

    public void read(Scanner stdin){
	numPoints = stdin.nextInt();
	points = new Point[numPoints];
	for(int i=0; i<numPoints;i++){
	    int x = stdin.nextInt();
	    int y = stdin.nextInt();
	    Point p = new Point(x,y);
	    points[i] = p;
	}
	
	numRect = stdin.nextInt();
	rectangles = new Rectangle[numRect];
	for(int i=0; i<numRect;i++){
	    int a = stdin.nextInt();
	    int b = stdin.nextInt();
	    Point point1 = new Point(a,b);
	    int c = stdin.nextInt();
	    int d = stdin.nextInt();
	    Point point2 = new Point(c,d);
	    
	    rectangles[i] = new Rectangle(point1, point2);
	}
    }

    public int getNumPointsNotInsideAnyRectangle(){
	int num = 0;
	for(int n=0;n<numPoints;n++){
	    int count = 0;
	    for(int m=0;m<numRect;m++){
		if(rectangles[m].pointInside(points[n]))
		    count++;	
	    }
	    if(count==0) num++;
	}
	return num;      
    }

    public int getNumRectanglesThatDontHaveAnyPoints(){
	int num = 0;
	for(int n=0;n<numRect;n++){
	    int count = 0;
	    for(int m=0;m<numPoints;m++){
		if(rectangles[n].pointInside(points[m]))
		    count++;
	    }
	    if(count==0) num++;
	}
	return num;      
    }
    
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        Geometry geo = new Geometry();
	geo.read(stdin);
	System.out.print(geo.getNumPointsNotInsideAnyRectangle()+ " "+ geo.getNumRectanglesThatDontHaveAnyPoints()+"\n");
    }
}
