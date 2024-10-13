import java.util.Scanner;
class Test{

    public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	BTree<Integer> t = LibBTree.readIntTree(in);
	ED240.paths(t);
    }


}
