import java.util.Scanner;
import java.util.Arrays;
class TreasureHunt{
    int N;
    int B;
    int I;
    String treasures;
    int curr;
    int posRight;//most extreme position arrived to the right
    int posLeft;//most extreme position arrived to the left
    int count;

    public void process(Scanner stdin){
	N = stdin.nextInt();
	B = stdin.nextInt();
	I = stdin.nextInt();
	stdin.nextLine();//jumping cursor to next line
	treasures = stdin.nextLine();
	curr = B-1;
	count = 0;
	//initializing max positions to initial one
	posRight = posLeft = B;
	for(int i=0; i<I; i++){ //O(I)
	    char direction = stdin.next().charAt(0);
	    int steps = stdin.nextInt();
	    doInstruction(direction, steps);
	}
	for(int j=posLeft; j<=posRight; j++)//worst case is O(N)
	    if(treasures.charAt(j)=='T')
		count++;
	//O(N+I) which is better than O(N*I)
	System.out.println(count);
    }

    public void doInstruction(char direction, int steps){
	
        if(direction=='D')
	    curr+=steps;
	else
	    curr-=steps;
	
	//updating extreme left and right positions
	if(curr<posLeft)
	    posLeft = curr;
	if(curr>posRight)
	    posRight = curr;		
    }
}

class ED199{
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	TreasureHunt t = new TreasureHunt();
	t.process(stdin);
    }
}
