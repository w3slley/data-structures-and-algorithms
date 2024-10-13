import java.util.LinkedList;
import java.util.Arrays;
class ED240{

    public static int getMin(BTree<Integer> t){
        int min = t.getRoot().getValue();
	int[] arr = new int[1];
	arr[0] = min;
	getMin(t.getRoot(), arr);
	//System.out.println(arr[0]);
	return arr[0];
    }

    private static void getMin(BTNode<Integer> n, int[] arr){
	if(n == null) return;
	if(n.getValue() < arr[0]) arr[0] = n.getValue();
	//System.out.println(n.getValue() + " " +min);
	getMin(n.getLeft(), arr);
	getMin(n.getRight(), arr);
    }
    
    public static String[] paths(BTree<Integer> t){
	LinkedList<String> list  = new LinkedList<>();
        int min = getMin(t);
	String path = "";
	paths(t.getRoot(), min, list, "");
        int size = list.size();
	
	String[] arr = new String[size];
	for(int i=0;i<size;i++){
	    arr[i] = list.removeFirst();
	}
        //System.out.println(Arrays.toString(arr));
	return arr;
    }

    private static void paths(BTNode<Integer> n, Integer min, LinkedList<String> list, String path){
	if(n == null) return;
	if(n.getValue().equals(min)){
	    if(path.equals(""))
		list.addLast("R");
	    else
		list.addLast(path);
	    
	}
       
	paths(n.getLeft(), min, list, path+"E");
	paths(n.getRight(), min, list, path+"D");
    }
}
