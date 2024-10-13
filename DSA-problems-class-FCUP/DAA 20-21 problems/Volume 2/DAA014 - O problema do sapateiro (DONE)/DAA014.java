import java.util.Scanner;
import java.util.Arrays;

class ShoeOrder implements Comparable<ShoeOrder>{
    int id;
    int duration;
    int fine;
    double finePerDay;
    ShoeOrder(int id, int d, int m){
	this.id = id;
	this.duration = d;
	this.fine = m;
	this.finePerDay = (double) m/d;
    }

    public int compareTo(ShoeOrder s){
	if(this.finePerDay > s.finePerDay) return -1;
	else if(this.finePerDay < s.finePerDay) return 1;
	else return this.id - s.id;
    }

    public String toString(){
	//return id+": ["+duration+", "+fine+"]";
	return this.id+" "+this.finePerDay;
    }
}

class DAA014{
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	int n = stdin.nextInt();
        ShoeOrder[] orders = new ShoeOrder[n];
	for(int i=0;i<n;i++){
	    orders[i] = new ShoeOrder(i+1, stdin.nextInt(), stdin.nextInt());
	}
	//System.out.println(Arrays.toString(orders));
	Arrays.sort(orders);
	//System.out.println(Arrays.toString(orders));
	for(int i=0;i<n;i++){
	    System.out.print(orders[i].id);
	    if(i!=n-1) System.out.print(" ");
	}
	System.out.println();
    }
}
