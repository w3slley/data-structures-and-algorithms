import java.util.Scanner;
class BooleanArrayIntList implements IntSet{
    private int size;
    private boolean[] elem;

    BooleanArrayIntList(int maxSize){
	elem = new boolean[maxSize];
	size = 0;
    }
    public boolean contains(int x){
	if(elem[x])
	    return true;
	return false;
    }
    public boolean add(int x){
	if(!contains(x)){
	    elem[x] = true;
	    size++;
	    return true;	    
	}
	return false;
	
    }
    
    public boolean remove(int x){
	if(contains(x)){
	    elem[x] = false;
	    size--;
	    return true;
	}
	return false;
    }

    public int size(){
	return size;
    }

    public void clear(){
	size = 0;
        elem = new int[maxSize];
    }
    public String toString(){
	String answ = "{";
	int control = 0;
	for(int i=0;i<elem.length;i++){
	    if(elem[i]){
		answ+=control==0?i:", "+i;
		control=1;
	    }
	}
	answ+="}";
	return answ;
    }
    
}
