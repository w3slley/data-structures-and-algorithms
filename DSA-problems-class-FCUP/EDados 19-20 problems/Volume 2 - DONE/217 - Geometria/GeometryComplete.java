import java.util.Scanner;
import java.util.Arrays;

// Uma classe simples para representar um ponto 2D
class Point {
    private int x, y; // Coordenadas do ponto

    // Construtor de um ponto
    Point(int x0, int y0) {
	x = x0;
	y = y0;
    }

    // Getters
    int getX() { return x; }
    int getY() { return y; }
   
    // Devolve uma representação em texto do conteúdo de um ponto
    public String toString() {
	return "(" + x + "," + y + ")";
    }
}

// Uma classe simples para representar um rectângulo
class Rectangle {
    Point p1, p2; // Ponto inferior esquerdo e ponto superior direito

    // Construtor de um rectângulo
    Rectangle(Point a, Point b) {
	p1 = new Point(a.getX(), a.getY());
	p2 = new Point(b.getX(), b.getY());
    }

    // Área de um rectângulo
    int area() {
	return (p2.getX()-p1.getX()) * (p2.getY()-p1.getY()); 
    }

    // Perímetro de um rectângulo
    int perimeter() {
	return (p2.getX()-p1.getX())*2 +  (p2.getY()-p1.getY())*2;
    }

    // Devolve true se o ponto p está dentro do rectângulo e false caso contrário
    // Se estiver na borda é considerado que está dentro
    boolean pointInside(Point p) {
	return (p.getX() >= p1.getX() && p.getX() <= p2.getX() &&
		p.getY() >= p1.getY() && p.getY() <= p2.getY());
    }

    // Devolve true se o rectângulo r está dentro do rectângulo e false caso contrário
    boolean rectangleInside(Rectangle r) {
	return pointInside(r.p1) && pointInside(r.p2);
    }
}

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
