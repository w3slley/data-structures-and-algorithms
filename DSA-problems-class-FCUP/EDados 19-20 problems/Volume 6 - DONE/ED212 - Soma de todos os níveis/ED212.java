import java.util.Scanner;
import java.util.Arrays;

class ED212{
    
    public static BTree<Integer> read(Scanner stdin) {
	BTree<Integer> t = new BTree<Integer>();
	t.setRoot(readIntNode(stdin));
	return t;
    }
   
    private static BTNode<Integer> readIntNode(Scanner stdin) {
	String s = stdin.next();
	if (s.equals("N")) return null;
	Integer value = Integer.parseInt(s);
	BTNode<Integer> left = readIntNode(stdin);
	BTNode<Integer> right = readIntNode(stdin);
      return new BTNode<Integer>(value, left, right);
   }
    //recursive method: you simply have to use an array and a int level variable. What it does it to add to the lth position of the array the values of the nodes at the lth level. Then, do the same thing for l+1. For what I can tell so far, when dealing with BFS using recursion this is the usual approach.
    public static int[] sumLevels(BTree<Integer> tree){
	int[] arr = new int[tree.depth()+1];
	sumLevels(tree.getRoot(), arr, 0);
	return arr;
	    
    }
    private static void sumLevels(BTNode<Integer> n, int[] arr, int l){
	if(n == null) return;
	arr[l]+=n.getValue();
	sumLevels(n.getLeft(),arr,l+1);
	sumLevels(n.getRight(),arr,l+1);
    }
    /*public static int sumQueue(MyQueue<BTNode<Integer>> q){
	int result = 0;

	for(int i=0;i<q.size();i++){
	    BTNode<Integer> n = q.dequeue();
	    result+=n.getValue();
	    q.enqueue(n);
	}
	return result;
    }
    public static int[] sumLevels(BTree<Integer> tree){
	int[] sum = new int[tree.depth()+1];
	MyQueue<BTNode<Integer>> q = new LinkedListQueue<>();
	q.enqueue(tree.getRoot());

	for(int i=0;i<tree.depth();i++){
	    sum[i] = sumQueue(q);
	    int n = q.size();
	    for(int j=0;j<n;j++){
		BTNode<Integer> curr = q.dequeue();
		if(curr.getLeft() != null)
		    q.enqueue(curr.getLeft());
		if(curr.getRight() != null)
		    q.enqueue(curr.getRight());
	    }
	}
	sum[tree.depth()] = sumQueue(q);//inserting sum of last queue
	return sum;
    }*/

    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	BTree<Integer> tree = read(stdin);

	System.out.println(Arrays.toString(sumLevels(tree)));
    }
	 
}
