// -----------------------------------------------------------
// Estruturas de Dados 2019/2020 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1920/
// -----------------------------------------------------------
// Classe utilitaria com metodo para ler uma arvore em preorder
// Ex: 5 1 8 N N 6 N N 7 2 N N N
// Ultima alteracao: 26/04/2018
// -----------------------------------------------------------

import java.util.Scanner;

public class LibBSTree {
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
