class MyIntSet implements IntSet{
    int[] elem;
    int size;
    
    MyIntSet(int maxSize){
	elem = new int[maxSize];//max number of digits in set
	size = 0;
    }
    
    public boolean contains(int x){
	for(int i=0;i<size;i++){
	    if(elem[i]==x){
		return true;
	    }
	}
	return false;
    }
    public boolean add(int x){
	if(!contains(x)){
	    if (size == elem.length)
		throw new RuntimeException("Maximum size of set reached"); 	    	    
	    elem[size]=x;
	    size++;
	    return true;
	}
	return false;
    }
    public boolean remove(int x){
	if (contains(x)) {
	    int pos = 0;
	    while (elem[pos] != x) pos++;
	    size--;
	    elem[pos] = elem[size]; // Trocar ultimo elemento 
	    return true;            // com o que se removeu
	}
      return false;
    }
    public int size(){
	return size;
    }
    public void clear(){
	size=0;
    }
    public String toString() {
	String res = "{";
	for (int i=0; i<size; i++) {
	    if (i>0) res += ",";
	    res += elem[i];
	}
	res += "}";
	return res;
   }
}
