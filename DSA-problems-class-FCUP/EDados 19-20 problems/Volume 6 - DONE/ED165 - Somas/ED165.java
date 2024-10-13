import java.util.Scanner;
class Sum{
    public BSTree<Integer> sums;
    private int[] set,questions;

    Sum(int n){
	sums = new BSTree<>();
	set = new int[n];
    }
    //O(N+P)
    public void read(Scanner stdin){
	//populating set array
	for(int i=0;i<set.length;i++)
	    set[i] = stdin.nextInt();

	//populating questions' array
	int m = stdin.nextInt();
	questions = new int[m];
	for(int i=0;i<m;i++)
	    questions[i] = stdin.nextInt();
    }
    //O(N^2)
    public void insertAllSums(){
	int k = set.length;
	for(int i=0;i<k;i++)
	    for(int j=0;j<k;j++)
		sums.insert(set[i]+set[j]);
    }
    //O(N^2 + P*log(m)), where m is the size of the binary search tree. The algorithm is quadratic in N and Plog(P) in P (which are the input values I should be concerned).
    public void process(){
	insertAllSums();
	for(int i=0;i<questions.length;i++){
	    System.out.print(questions[i]+": ");
	    if(sums.contains(questions[i]))
		System.out.print("sim\n");
	    else
		System.out.print("nao\n");
	}
    }
}
class ED165{
    //O(N+P+N^2+P*log(m)) = O(N^2+P*log(m)) = O(N^2 + P*log(P)), because in the worse case m = P. Then the complexity of the algorithm is O(N^2+P*log(P))
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	int n = stdin.nextInt();
	Sum s = new Sum(n);
	
        s.read(stdin);
	s.process();
    }
}
