import java.util.Scanner;
class ED211{
    //static int count;
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

    public static int countEven(BTree<Integer> t) {
	//count = 0;
	return countEven(t.getRoot());
    }
    private static int countEven(BTNode<Integer> n){
	//I could simply use a count variable in here!
	if(n==null) return 0;//when reached null node
	int count = 0;//variabie which will store number of even nodes. I don't need to create a global variable - I just need to return its value here
	if(n.getValue()%2 == 0) count++;
	//return count variable + its value in the left + its value in the right!!
	return count + countEven(n.getLeft()) + countEven(n.getRight());
    }

    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	BTree<Integer> tree = read(stdin);

	System.out.println(countEven(tree));

    }

}
