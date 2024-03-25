import java.util.Comparator;

class LengthComparator implements Comparator<String>{
    public int compare (String a, String b) {
        return a.length() - b.length();
    }
}

class TestMinHeap{
    public static void testIntegers(){
	MinHeap<Integer> h = new MinHeap<>(100);

	int[] v = {10,4,3,12,9,1,7,11,5,8};
	//add elements to heap
	for(int i=0;i<v.length;i++)
	    h.insert(v[i]);

	//remove and print elements from heap
	for(int i=0;i<v.length;i++)
	    System.out.print(h.removeMin() + " ");
	System.out.println();

    }

    public static void testStrings(){
	MinHeap<String> h = new MinHeap<>(100,new LengthComparator());

	String [] v = {"aaaaa", "bbb", "cccc", "d", "ee"};

	for(int i=0; i<v.length;i++)
	    h.insert (v[i]);

	for(int i=0;i<v.length;i++)
	    System.out.print(h.removeMin() + " ");
	System.out.println();
    }
    public static void main(String[] args){
	testStrings();
    }
}
