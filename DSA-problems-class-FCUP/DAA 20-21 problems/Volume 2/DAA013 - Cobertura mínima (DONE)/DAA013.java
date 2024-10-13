import java.util.Scanner;
import java.util.Arrays;

class Segment implements Comparable<Segment>{
    int left;
    int right;
    
    Segment(int l, int r){
	this.left = l;
	this.right = r;
    }

    public int compareTo(Segment s){
	if(this.left == s.left)
	    return this.right - s.right;
	
	return this.left - s.left;
    }

    public String toString(){
	return "[" + this.left + ", " + this.right + "]";
    }
}
class DAA013{
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	int m = stdin.nextInt();
	int n = stdin.nextInt();
	Segment[] segments = new Segment[n];
	for(int i=0;i<n;i++){
	    int l = stdin.nextInt();
	    int r = stdin.nextInt();
	    segments[i] = new Segment(l,r);
	}
	Arrays.sort(segments);
	int end = 0;
	int count = 0;
	int rMax = 0;
	for(int i=0;i<n;i++){
	    if(end > m) break;
	    if(segments[i].left <= end)
		rMax = Math.max(rMax,segments[i].right);
	    else{
		end = rMax;
		count++;
		rMax = segments[i].right;
	    }
	}
	if(end < m && rMax >= m) count++;
	System.out.println(count);
    }
}
