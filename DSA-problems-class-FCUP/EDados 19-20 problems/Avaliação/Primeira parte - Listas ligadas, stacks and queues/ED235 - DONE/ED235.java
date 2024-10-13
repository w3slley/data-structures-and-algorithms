import java.util.Scanner;

class Triangle{
    public void read(Scanner stdin){
	int n = stdin.nextInt();
	int pos = n-1;
	for(int i=0;i<n;i++){
	    for(int j=0;j<n;j++){
		//System.out.print(pos);
		if(j<=pos) System.out.print('#');
		else System.out.print('.');
	    }
	    System.out.println();
	    pos--;
	}
    }
}
class ED235{
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	int n = stdin.nextInt();
	for(int i=0;i<n;i++){
	    Triangle t = new Triangle();
	    t.read(stdin);
	}
    }
}
