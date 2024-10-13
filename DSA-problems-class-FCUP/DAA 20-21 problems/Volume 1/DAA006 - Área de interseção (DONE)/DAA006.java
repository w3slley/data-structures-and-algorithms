import java.util.Scanner;
class DAA006{
    static double cx;
    static double cy;
    static double cr;
    
    public static boolean isCircleInsideSquareBySides(double x, double y, double l){
	return (cy-cr < y+l) || (cx-cr < x+l) || (cx+cr > x) || (cy+cr > y);
    }
    
    public static boolean isPointInsideCircle(double x, double y){
	return Math.sqrt((cx-x)*(cx-x) + (cy-y)*(cy-y)) < cr;
    }
    public static double intersection(double x, double y, double l){
	//precision of ql
	if(l < .003) return 0;
	
	//circle inside square
        else if((cx+cr<=x+l && cx-cr>=x) && (cy+cr<=y+l && cy-cr>=y))
	    return Math.PI*cr*cr;
	
	//square inside circle
        else if(isPointInsideCircle(x,y) && isPointInsideCircle(x,y+l) && isPointInsideCircle(x+l,y+l) && isPointInsideCircle(x+l,y))
	    return l*l;
	
	//square completely is outside of the circle
	else if(isPointInsideCircle(x,y)==false && isPointInsideCircle(x,y+l)==false && isPointInsideCircle(x+l,y+l)==false && isPointInsideCircle(x+l,y)==false && isCircleInsideSquareBySides(x,y,l)==false)
	    return 0;
	
	else{
	    double area = 0;
	    l = l/2;
	    area += intersection(x, y+l, l);
	    area += intersection(x+l, y+l, l);
	    area += intersection(x, y, l);
	    area += intersection(x+l, y, l);
	    return area;
	}
	
    }
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	int n = stdin.nextInt();
	for(int i=0;i<n;i++){
	    double qx = stdin.nextDouble();
	    double qy = stdin.nextDouble();
	    double ql = stdin.nextDouble();
	    cx = stdin.nextDouble();
	    cy = stdin.nextDouble();
	    cr = stdin.nextDouble();
	    System.out.printf("%.4f %n", intersection(qx,qy,ql));
	    //System.out.println(isPointInsideCircle(4,4,4,6,3));
	}
	
	
    }
}
