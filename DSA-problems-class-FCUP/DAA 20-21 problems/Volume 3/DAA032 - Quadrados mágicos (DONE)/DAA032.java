import java.util.*;
class MagicSquare implements Comparable<MagicSquare>{
    int n;
    int[] config = {1,2,3,4,5,6,7,8};
    String path;
    
    MagicSquare(){
	n = 8;
	path = "";
    }

    MagicSquare(int[] initConfig){
	this();
        for(int i=0;i<n;i++){
	    this.config[i] = initConfig[i];
	}
    }
  
    void transform(char c){//O(1)
	if(c == 'A'){
	    for(int i=0;i<n/2;i++){
		int tmp = config[i];
		config[i] = config[n-i-1];
		config[n-i-1] = tmp;
	    }
	}
	else if(c == 'B'){
	    int tmpLeft = config[n/2-1];
	    int tmpRight = config[n/2];
	    int[] arr = new int[n];
	    arr[0] = tmpLeft;
	    arr[n-1] = tmpRight;
	    for(int i=0;i<n/2-1;i++){
		arr[i+1] = config[i];
	    }
	    for(int i=n/2;i<n-1;i++)
		arr[i] = config[i+1];
	    this.config = arr;
	}
	else if(c == 'C'){
	    int tmp1 = config[1];//2
	    int tmp2 = config[2];//3
	    int tmp3 = config[n-3];//6
	    int tmp4 = config[n-2];//7

	    config[1] = tmp4;
	    config[2] = tmp1;
	    config[n-3] = tmp2;
	    config[n-2] = tmp3;
	}
    }
    @Override
    public boolean equals(Object o){
	MagicSquare ms = (MagicSquare) o;
	return Arrays.equals(this.config, ms.config);
    }

    @Override
    public int hashCode(){
	return Arrays.hashCode(this.config);
    }
    
    public int compareTo(MagicSquare ms){
	if(Arrays.equals(this.config, ms.config))
	    return 0;
	
	return -1;//just to have something here, I won't use < or > comparisons
    }

    public String toString(){
	String ans = "\n";
	for(int i=0;i<n/2;i++)
	    ans+=config[i];
	ans+='\n';
	for(int i=n-1;i!=n/2-1;i--)
	    ans+=config[i];
	return ans+"\n";
    }
}

class DAA032{
    static HashSet<MagicSquare> visitedStates;
    
    public static void bfs(MagicSquare target){//O(3^n)
	Queue<MagicSquare> queue = new LinkedList<>();
	queue.add(new MagicSquare());//adding MagicalSquare with initial state into queue
	visitedStates.add(new MagicSquare());//adding initial state into visited state
	
	while(!queue.isEmpty()){
	    MagicSquare curr = queue.poll();

	    for(char c='A';c<='C';c++){//creating the 3 states
	        MagicSquare child = new MagicSquare(curr.config);//creates configuration based on parent node
		child.transform(c);//apply transformation for A, B and C
		child.path = curr.path + c;//Updating path of child node
		
		//if a previous config was achieved, don't create subtree with this new configuration
		if(visitedStates.contains(child))//O(1) (hashtable lookup)
		    continue;
		else
		    visitedStates.add(child);//O(1)

		// if the current magical square has the same state as the target
		if(child.compareTo(target)==0){//O(1)
		    System.out.println(child.path.length());
		    System.out.println(child.path);
		    return;
		}
		else{//otherwise, add it to queue 
		    queue.add(child);
		}
	    }
	}
    }
    
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	int[] target = new int[8];
	for(int i=0;i<8;i++)
	    target[i] = stdin.nextInt();
	MagicSquare ms = new MagicSquare(target);
	visitedStates = new HashSet<>();
	bfs(ms);
    }
}
