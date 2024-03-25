class ClassIntSet implements IntSet{
    public boolean contain(int x){
	return false;
    }
    public boolean add(int x){
	return false;
    }
    public boolean remove(int x){
	return false;
    }
    public int size(){
	return 200;
    }
    public void clear(){
    }
}
class TestIntSet{
    public static void main(String[] args){
	IntSet s = new ClassIntSet();
	System.out.println(s.size());
				     
    }
}
