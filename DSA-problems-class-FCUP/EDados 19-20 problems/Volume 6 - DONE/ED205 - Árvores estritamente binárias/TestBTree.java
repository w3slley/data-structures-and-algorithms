import java.util.Scanner;
class LibBTree {//used to read binary tree
    
   public static BTree<Integer> readIntTree(Scanner in) {
      BTree<Integer> t = new BTree<Integer>();
      t.setRoot(readIntNode(in));
      return t;
   }
   
   private static BTNode<Integer> readIntNode(Scanner in) {
      String s = in.next();
      if (s.equals("N")) return null;
      Integer value = Integer.parseInt(s);
      BTNode<Integer> left = readIntNode(in);
      BTNode<Integer> right = readIntNode(in);
      return new BTNode<Integer>(value, left, right);
   }
}

class TestBTree{
    public static void main(String[] args){
	// Ler arvore de inteiros em preorder
	Scanner in = new Scanner(System.in);
	BTree<Integer> t = LibBTree.readIntTree(in);

	// Escrever resultado de chamada a alguns metodos
	System.out.println("numberNodes = " + t.numberNodes());
	System.out.println("depth = " + t.depth());
	System.out.println("contains(2) = " + t.contains(2));
	System.out.println("contains(3) = " + t.contains(3));

	t.printPreOrder();
	t.printInOrder();
	t.printPostOrder();
	System.out.println(t.strict());
    }
}
