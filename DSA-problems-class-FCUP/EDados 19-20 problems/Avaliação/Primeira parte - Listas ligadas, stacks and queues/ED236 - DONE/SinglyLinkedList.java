// -----------------------------------------------------------
// Estruturas de Dados 2019/2020 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1920/
// -----------------------------------------------------------
// Lista ligada simples
// Ultima alteracao: 03/04/2018
// -----------------------------------------------------------
import java.util.Arrays;
public class SinglyLinkedList<T> {
   private Node<T> first;    // Primeiro no da lista
   private int size;         // Tamanho da lista

   // Construtor (cria lista vazia)
   SinglyLinkedList() {
      first = null;
      size = 0;
   }

   // Retorna o tamanho da lista
   public int size() {
      return size;
   }

   // Devolve true se a lista estiver vazia ou falso caso contrario
   public boolean isEmpty() {
      return (size == 0);
   }
   
   // Adiciona v ao inicio da lista
   public void addFirst(T v) {
      Node<T> newNode = new Node<T>(v, first); 
      first = newNode;
      size++;
   }

   // Adiciona v ao final da lista
   public void addLast(T v) {
      Node<T> newNode = new Node<T>(v, null); 
      if (isEmpty()) {
         first = newNode;
      } else {
         Node<T> cur = first;
         while (cur.getNext() != null)
            cur = cur.getNext();
         cur.setNext(newNode);         
      }
      size++;
   }

   // Retorna o primeiro valor da lista (ou null se a lista for vazia)
   public T getFirst() {
      if (isEmpty()) return null;
      return first.getValue();
   }

   // Retorna o ultimo valor da lista (ou null se a lista for vazia)
   public T getLast() {
      if (isEmpty()) return null;
      Node<T> cur = first;
      while (cur.getNext() != null)
         cur = cur.getNext();
      return cur.getValue();      
   }

   // Remove o primeiro elemento da lista (se for vazia nao faz nada)
   public void removeFirst() {
      if (isEmpty()) return;
      first = first.getNext();
      size--;
   }

   // Remove o ultimo elemento da lista (se for vazia nao faz nada)
   public void removeLast() {
      if (isEmpty()) return;
      if (size == 1) {
         first = null;
      } else {
         // Ciclo com for e uso de de size para mostrar alternativa ao while
         Node<T> cur = first;
         for (int i=0; i<size-2; i++)
            cur = cur.getNext();
         cur.setNext(cur.getNext().getNext());
      }
      size--;
   }
   
   // Converte a lista para uma String
   public String toString() {
      String str = "{";      
      Node<T> cur = first;
      while (cur != null) {
         str += cur.getValue();
         cur = cur.getNext();
         if (cur != null) str += ",";                     
      }      
      str += "}";
      return str;
   }

    //ED236
    public SinglyLinkedList<T> cut(int a, int b){
	SinglyLinkedList<T> newList = new SinglyLinkedList<>();
	Node<T> curr = first;
	int pos = 0;
	while(curr != null){
	    if(pos > b)
		break;
	    if(pos >= a)
		newList.addLast(curr.getValue());
	    curr = curr.getNext();
	    pos++;
	}
	return newList;
    }

    /*public void shift(int k){
	for(int i=0;i<k;i++){
	    T last = getLast();
	    removeLast();
	    addFirst(last);
	}
	}*/
    
    /*public void shift(int k){
        int res = k%size;
	@SuppressWarnings("unchecked")
	    T[] arr = (T[]) new Object[res];//array that contains values from the end of linked list and which need to go to the beginning
	Node<T> curr = first;
	//getting to node before the ones to be switched -> O(n)
	for(int i=0;i<size-res-1;i++){
	    curr = curr.getNext();
	}
	//deleting individual node from list and adding its value to array -> O(n)
	for(int i=0;i<res;i++){
	    Node<T> deleted = curr.getNext();
	    curr.setNext(deleted.getNext());
	    arr[i]=deleted.getValue();
	}
	//adding values from array to beginning of list (starting from the end of array - first added should be the last added first to list)
	for(int i=0;i<res;i++)
	    addFirst(arr[res-i-1]);
	    }*/

    public void shift(int k){
	if(k==0) return;
	int res = k%size;
	Node<T> curr = first;
	Node<T> last = null;
	//getting to node before the ones to be switched -> O(n)
	for(int i=0;i<size;i++){
	    if(i==size-res-1)
	        last = curr;
	    //only go to next node size-1 times (to get to last node)
	    if(i!=size-1) curr = curr.getNext();
	}
	//curr is the element which will be the last node on list. Then,
	curr.setNext(first); //set last element's next node to the first node of original list
	first = last.getNext();//update first node
	last.setNext(null);//make it the actual last element of list
    } 
}
