import java.util.Scanner;

class TestBTree{
    public static void main(String[] args){
	// Ler arvore de inteiros em preorder
	Scanner in = new Scanner(System.in);
	BTree<Integer> t = LibBTree.readIntTree(in);

	// Escrever resultado de chamada a alguns metodos
	/*System.out.println("numberNodes = " + t.numberNodes());
	System.out.println("depth = " + t.depth());
	System.out.println("contains(2) = " + t.contains(2));
	System.out.println("contains(3) = " + t.contains(3));

	t.printPreOrder();
	t.printInOrder();
	t.printPostOrder();*/

	System.out.println(t.level(3));
    }
}
