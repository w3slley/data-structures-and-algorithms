import java.util.Arrays;
import java.util.Scanner;
class Ruivacos{
    int N;
    int K;
    int T;
    int count;
    int[] depth;
    
    public void process(){
	int q = 0;
	for(int i=0;i<N;i++){
	    //first of (N-K)+1 intervals
	    if(i==0)
		for(int j=0;j<K;j++)
		    if(depth[j]>=T) q++;
	    double k = (int) K;//creating double variable for correct comparison
	    if(q>=k/2) count++;
	    if(i+K==depth.length) break; //if arrived at position N-K, get out of loop
	    //updating values of q based on value of position a=i and b+1=i+K
	    if(depth[i]>=T) q-=1;
	    if(depth[i+K]>=T) q+=1;
	}
	System.out.println(count);
    }
	
    public void read(Scanner stdin){
	N = stdin.nextInt();
	K = stdin.nextInt();
	T = stdin.nextInt();
	count=0;
	depth = new int[N];
	for(int i=0;i<N;i++)
	    depth[i] = stdin.nextInt();
	process();
    }
}

class ED222{
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	Ruivacos r = new Ruivacos();
	r.read(stdin);
    }
}
