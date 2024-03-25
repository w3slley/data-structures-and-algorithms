import java.util.Scanner;

class LibBTree {//used to read binary tree
   public static BSTree<Integer> readIntTree(Scanner in) {
      BSTree<Integer> t = new BSTree<Integer>();
      t.setRoot(readIntNode(in));
      return t;
   }
   
   private static BSTNode<Integer> readIntNode(Scanner in) {
      String s = in.next();
      if (s.equals("N")) return null;
      Integer value = Integer.parseInt(s);
      BSTNode<Integer> left = readIntNode(in);
      BSTNode<Integer> right = readIntNode(in);
      return new BSTNode<Integer>(value, left, right);
   }
}

class TestBSTree {
   public static void main(String[] args) {

       Scanner stdin = new Scanner(System.in);
      // Criacao da Arvore
       BSTree<Integer> t = LibBTree.readIntTree(stdin);
      
      // Escrever resultado de chamada a alguns metodos
      //System.out.println("numberNodes = " + t.numberNodes());
      //System.out.println("depth = " + t.depth());
      //System.out.println("contains(2) = " + t.contains(2));
      //System.out.println("contains(3) = " + t.contains(3));

      // Escrever nos da arvore seguindo varias ordens possiveis
      t.printPreOrder();
      t.printInOrder();
      t.printPostOrder();
      //t.printInOrder();
      //t.printPostOrder();
      System.out.println(t.printBFS());
      //Experimentando remocao
      //t.remove(10);
      //t.insert(11);
      //t.insert(4);
      //t.printPreOrder();
      //t.printInOrder();
      //t.printPostOrder();
   }
}
