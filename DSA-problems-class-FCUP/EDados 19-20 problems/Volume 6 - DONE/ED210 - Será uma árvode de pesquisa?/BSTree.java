// -----------------------------------------------------------
// Estruturas de Dados 2019/2020 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1920/
// -----------------------------------------------------------
// Arvore binaria de pequisa
// Ultima alteracao: 13/05/2018
// -----------------------------------------------------------

// O tipo T tem de implementar o interface Comparable
// (ou te-lo herdado de uma super classe).
public class BSTree<T extends Comparable<? super T>> {   
   private BSTNode<T> root; // raiz da arvore

   // Construtor
   BSTree() {
      root = null;
   }

   // Getter e Setter para a raiz
   public BSTNode<T> getRoot() {return root;}
   public void setRoot(BSTNode<T> r) {root = r;}
   
   // Verificar se arvore esta vazia
   public boolean isEmpty() {
      return root == null;
   }

   // Limpa a arvore (torna-a vazia)
   public void clear() {
      root = null;
   }

     
    // --------------------------------------------------------
    // ED210 - Será uma árvore de pesquisa?

    //strategy: do an in order traversal and put the result into a linked list. If the list is sorted, then it's a binary search tree. If not, then it isn't. It will be linear because doing an in order traversal takes O(n) and checking if the list is sorted is also O(n). 
    public boolean valid (){
	DoublyLinkedList<T> list = new DoublyLinkedList<>();//list with data
	getInOrder(this.root, list);//add node's values into list using in order tree traversal
	int size = list.size();
	//going through the linked list and comparing each element to the next to see if the list is sorted
	for(int i=0;i<size-1;i++){
	    T a = list.getFirst();//first element on list
	    list.removeFirst();//remove it so that on the next loop b is the first element
	    T b = list.getFirst();//second element on list and element that will be compared to the first
	    if(a.compareTo(b)>0) return false; //if a > b, then the list is not sorted and return false
	}
	return true; //if it got here, the list is sorted and return true
    }
    
    private void getInOrder(BSTNode<T> n, DoublyLinkedList<T> list){
	if(n == null) return;
	getInOrder(n.getLeft(), list);
        list.addLast(n.getValue());
	getInOrder(n.getRight(), list);

    }

   // --------------------------------------------------------
   // Numero de nos da arvore
   public int numberNodes() {
      return numberNodes(root);
   }

   private int numberNodes(BSTNode<T> n) {
      if (n == null) return 0;
      return 1 + numberNodes(n.getLeft()) + numberNodes(n.getRight());
   }
   
   // --------------------------------------------------------   
   // O elemento value esta contido na arvore?
   public boolean contains(T value) {
      return contains(root, value);
   }

   private boolean contains(BSTNode<T> n, T value) {
      if (n==null) return false;
      if (value.compareTo(n.getValue()) < 0) // menor? sub-arvore esquerda
         return contains(n.getLeft(), value);
      if (value.compareTo(n.getValue()) > 0) // maior? sub-arvore direita
         return contains(n.getRight(), value);
      return true; // se nao e menor ou maior, e porque e igual
   }

   // --------------------------------------------------------
   // Adicionar elemento a uma arvore de pesquisa
   // Devolve true se conseguiu inserir, false caso contrario
   public boolean insert(T value) {
      if (contains(value)) return false;
      root = insert(root, value);
      return true;
   }

   private BSTNode<T> insert(BSTNode<T> n, T value) {
      if (n==null)
         return new BSTNode<T>(value, null, null);
      else if (value.compareTo(n.getValue()) < 0) 
         n.setLeft(insert(n.getLeft(), value));
      else if (value.compareTo(n.getValue()) > 0)
         n.setRight(insert(n.getRight(), value));
      return n;
   }

   // --------------------------------------------------------
   // Remover elemento de uma arvore de pesquisa
   // Devolve true se conseguiu remover, false caso contrario
   public boolean remove(T value) {
      if (!contains(value)) return false;
      root = remove(root, value);
      return true;
   }

   // Assume-se que elemento existe (foi verificado antes)
   private BSTNode<T> remove(BSTNode<T> n, T value) {
      if (value.compareTo(n.getValue()) < 0)
         n.setLeft(remove(n.getLeft(), value));
      else if (value.compareTo(n.getValue()) > 0)
         n.setRight(remove(n.getRight(), value));
      else if (n.getLeft() == null) // Nao tem filho esquerdo
         n = n.getRight();
      else if (n.getRight() == null) // Nao tem filho direito
         n = n.getLeft();
      else { // Dois fihos: ir buscar maximo do lado esquerdo
         BSTNode<T> max = n.getLeft();
         while (max.getRight() != null) max = max.getRight();
         n.setValue(max.getValue()); // Substituir valor removido
         // Apagar valor que foi para lugar do removido
         n.setLeft(remove(n.getLeft(), max.getValue()));
      }
      return n;
   }

   // --------------------------------------------------------
   // Altura da arvore
   public int depth() {
      return depth(root);
   }

   private int depth(BSTNode<T> n) {
      if (n == null) return -1;
      return 1 + Math.max(depth(n.getLeft()), depth(n.getRight()));
   }

   // --------------------------------------------------------

   // Imprimir arvore em PreOrder
   public void printPreOrder() {
      System.out.print("PreOrder:");
      printPreOrder(root);
      System.out.println();
   }

   private void printPreOrder(BSTNode<T> n) {
      if (n==null) return;
      System.out.print(" " + n.getValue() );
      printPreOrder(n.getLeft());
      printPreOrder(n.getRight());
   }

   // --------------------------------------------------------
   
   // Imprimir arvore em InOrder
   public void printInOrder() {
      System.out.print("InOrder:");
      printInOrder(root);
      System.out.println();
   }

   private void printInOrder(BSTNode<T> n) {
      if (n==null) return;
      printInOrder(n.getLeft());
      System.out.print(" " + n.getValue());
      printInOrder(n.getRight());
   }

   // --------------------------------------------------------

   // Imprimir arvore em PostOrder
   public void printPostOrder() {
      System.out.print("PostOrder:");
      printPostOrder(root);
      System.out.println();
   }

   private void printPostOrder(BSTNode<T> n) {
      if (n==null) return;
      printPostOrder(n.getLeft());
      printPostOrder(n.getRight());
      System.out.print(" " + n.getValue());
   }
   
   // --------------------------------------------------------
    /*
   // Imprimir arvore numa visita em largura (usando TAD Fila)
   public void printBFS() {
      System.out.print("BFS:");
      
      MyQueue<BSTNode<T>> q = new LinkedListQueue<BSTNode<T>>();
      q.enqueue(root);
      while (!q.isEmpty()) {
         BSTNode<T> cur = q.dequeue();
         if (cur != null) {
            System.out.print(" " + cur.getValue());
            q.enqueue(cur.getLeft());
            q.enqueue(cur.getRight());
         }
      }
      System.out.println();
   }

   // --------------------------------------------------------
   
   // Imprimir arvore numa visita em largura (usando TAD Pilha)
   public void printDFS() {
      System.out.print("DFS:");
      
      MyStack<BSTNode<T>> q = new LinkedListStack<BSTNode<T>>();
      q.push(root);
      while (!q.isEmpty()) {
         BSTNode<T> cur = q.pop();
         if (cur != null) {
            System.out.print(" " + cur.getValue());
            q.push(cur.getLeft());
            q.push(cur.getRight());
         }
      }
      System.out.println();
      }*/

}
