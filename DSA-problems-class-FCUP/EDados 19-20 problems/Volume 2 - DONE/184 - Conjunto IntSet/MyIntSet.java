class MyIntSet implements IntSet{
    private int size;
    private boolean[] elem;

    MyIntSet(){
	elem = new boolean[1000];
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
	for(int i=0;i<elem.length;i++)
	    elem[i]=false;
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
