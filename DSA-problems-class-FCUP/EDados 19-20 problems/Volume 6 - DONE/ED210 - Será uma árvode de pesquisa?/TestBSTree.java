// -----------------------------------------------------------
// Estruturas de Dados 2019/2020 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1920/
// -----------------------------------------------------------
// Exemplo de utilizacao da uma arvore binaria
// Ultima alteracao: 26/04/2018
// -----------------------------------------------------------

import java.util.Scanner;
import java.util.Arrays;

public class TestBSTree {
   public static void main(String[] args) {
      // Ler arvore de inteiros em preorder
      Scanner in = new Scanner(System.in);
      BSTree<Integer> t = LibBSTree.readIntTree(in);

      // Escrever resultado de chamada a alguns metodos
      //System.out.println("numberNodes = " + t.numberNodes());
      //System.out.println("depth = " + t.depth());
      //System.out.println("contains(2) = " + t.contains(2));
      //System.out.println("contains(3) = " + t.contains(3));

      // Escrever nos da arvore seguindo varias ordens possiveis
      t.printInOrder();
      System.out.println(t.valid());
      
   }
}
