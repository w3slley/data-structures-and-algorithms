import java.util.Comparator;

public class MinHeap<T>{
    private T[] data; //store elements between positions 1 and size
    private int size;
    private Comparator<T> comparator;

    @SuppressWarnings("unchecked")//because of array with generic
    //Constructor with given capacity
    MinHeap(int capacity){
	//since Java forbids generic types array, you have to use casting!
	data = (T[]) new Object [capacity + 1];
	size = 0;
	comparator = null;
    }

    //Contructor with given capacity and a custom comparator
    MinHeap(int capacity, Comparator<T> comp){
	this(capacity);//calls the standard constructor
	comparator = comp;
    }

    //-----------------------------------------------------
    //Size of heap
    
    public int size(){ return this.size; }
    
    
    //-----------------------------------------------------
    //Is heap empty?
    
    public boolean isEmpty(){ return size == 0; }


    //-----------------------------------------------------
    //Get min element
    
    public T min(){
	if(isEmpty()) return null;
	return data[1];
    }
    

    //-----------------------------------------------------
    //Insert element into heap
    public void insert(T value){
	if(size+1 >= data.length)
	    throw new RuntimeException("Heap is full");
	size++;
	data[size] = value;
	upHeap(size);
    }
    //makes an element go up into the heap to its correct position
    private void upHeap(int i){
	//while the element is less then its parent and it's not on root
	while(i>1 && smaller(i, i/2)){
	    swap(i,i/2);
	    i=i/2;
	}
    }

    @SuppressWarnings("unchecked")//bypassing generic type array error with this and cast
    private boolean smaller(int i, int j){
	//if there is no comparator, use natural comparator:
	if(comparator == null)
	    return ((Comparable<? super T>) data[i]).compareTo(data[j]) < 0;
	//if there is, use it
	else
	    return comparator.compare(data[i], data[j]) < 0;
    }

    private void swap(int i, int j){
	T temp = data[i];
	data[i] = data[j];
	data[j] = temp;
    }


    //-----------------------------------------------------
    //Remove and return minimum value

    public T removeMin(){
	if(isEmpty()) return null;
	T min = data[1];
	data[1] = data[size];
	data[size] = null; //this helps garbage collector
	size--;
	downHeap(1);
	return min;
    }

    private void downHeap(int i){
	while(2*i <= size){//while the element is not in the last position of heap
	    int j = i*2;
	    //(j+1 is the second child node, j is the first). Gets the position of the smallest of child nodes
	    if(j<size && smaller(j+1, j)) j++;
	    if(smaller(i,j)) break; //if node is already less then smallest child, break
	    swap(i,j);
	    i=j;//updates position of element
				 
	}
    }

    public String toString(){
	String answ = "{";
	for(int i=1;i<size+1;i++){
	    if(i!=1)
		answ+=",";
	    answ+=data[i];
	}
	return answ+"}";
    }
    
    
}
