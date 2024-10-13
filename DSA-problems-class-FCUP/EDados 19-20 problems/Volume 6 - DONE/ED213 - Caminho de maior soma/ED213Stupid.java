import java.util.LinkedList;
import java.util.Stack;
class Path{
    public int sum;
    public String path;
    
    Path(int sum, String path){
	this.path = path;
	this.sum = sum;
    }
    public String toString(){
	return "{"+sum+","+path+"}";
    }
}
class ED213{
    static Stack<Integer> nodeStack;//stack to store node's values from root - to calculate sum
    static Stack<Character> pathStack;//stack to store the path (E or D) from root - to return
    static LinkedList<Path> paths; //linked list to store paths object
    
    public static String getPath(Stack<Character> stack){
	String str = "";
	int n = stack.size();
	char[] arr = new char[n];
	//adding char values from stack to array
	for(int i=0;i<n;i++){
	    char val = stack.pop();
	    arr[n-i-1] = val;
	}
	//putting items back into stack and adding path to string
	for(int i=0;i<n;i++){
	    stack.push(arr[i]);
	    str+=arr[i];
	}
	return str;
    }
    public static int sumStack(Stack<Integer> stack){ //O(n+n) = O(n)
	int sum = 0;
	int n = stack.size();
	int[] arr = new int[n];//array to store values of stack
	for(int i=0;i<n;i++){//loop through the stack, pop its value, add its value to the sum variable and put it into the array
	    int val = stack.pop();
	    sum += val;
	    arr[i] = val;
	}
	for(int i=0;i<n;i++) stack.push(arr[n-i-1]);//add values back into stack starting from end of array
	return sum;
    }

    public static Path getMaxPath(LinkedList<Path> l){
	Path maxPath = l.get(0);
	for(int i=1;i<l.size();i++)
	    if(l.get(i).sum > maxPath.sum) maxPath = l.get(i);
	return maxPath;
    }
    
    //O(n) - algorithm has to go through each of the n nodes of the binary tree
    public static String maxSum(BTree<Integer> t){
	nodeStack = new Stack<>();
	pathStack = new Stack<>();
	paths = new LinkedList<>();
	maxSum(t.getRoot());
	return getMaxPath(paths).path;//getting (and returning) the maxt path from the linked list of Path objects
    }
    private static void maxSum(BTNode<Integer> n){
	nodeStack.push(n.getValue());//pushing each node to stack
	if(n.getLeft() == null && n.getRight() == null){//when arrived at a leaf
	    Path p = new Path(sumStack(nodeStack), getPath(pathStack));
	    paths.addLast(p);
	    nodeStack.pop();//removing current node from stacks since its path/sum was already calculated
	    pathStack.pop();//Next, its sibling node will be avaluated, its path will be derived and its sum calculated - and so on
	    return;//get out of current node, go back to its parent and enter its other child node, then repeat
	}
	//only go to left subtree if it's not null
        if(n.getLeft() != null){
	    pathStack.add('E');
	    maxSum(n.getLeft());
	}
	//only go to right subtree if it's not null
	if(n.getRight() != null){
	    pathStack.add('D');
	    maxSum(n.getRight());
	}
	//removing item on top of stack (both on nodes and paths stack) when moving one height up in the tree
	nodeStack.pop();
        if(!pathStack.empty()) pathStack.pop();
    }
}
