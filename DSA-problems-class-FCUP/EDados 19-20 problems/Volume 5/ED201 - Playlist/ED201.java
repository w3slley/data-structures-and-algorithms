import java.util.Scanner;
class Playlist{
    int[] set;
    boolean[] used;
    int result;
    int bestPlaylist;
    int minDiff;
    
    public void read(Scanner stdin){
	result = stdin.nextInt();
	int n = stdin.nextInt();
	set = new int[n];
	for(int i=0;i<n;i++)
	    set[i] = stdin.nextInt();
    }
    public boolean checkAllFalse(boolean[] arr){
	for(int i=0;i<arr.length;i++)
	    if(arr[i]) return false;
	return true;
    }

    public boolean checkAllTrue(boolean[] arr){
	for(int i=0;i<arr.length;i++)
	    if(!arr[i]) return false;
	return true;
    }
    
    public void getResult(){
	used = new boolean[set.length];
	goSets(0, set, used);
	System.out.println(bestPlaylist);
    }

    public void goSets(int curr, int[]arr, boolean[] used){
	//base case: when all the array is traversed
	if(curr == arr.length){
	    if(checkAllFalse(used)) return; //removing empty subset
	    int sum = 0;
	    for(int i=0;i<arr.length;i++)
		if(used[i]) sum+=arr[i];
	    //setting minimum to first diff (when all boolean values in used are true
	    if(checkAllTrue(used)) minDiff = Math.abs(result-sum);

	    //updating minDiff value
	    if(Math.abs(result-sum)< minDiff && sum<=result){
		minDiff = Math.abs(result-sum);
		bestPlaylist = sum;
	    }
	}
	else{
	    //generating sets which start with true
	    used[curr] = true;
	    goSets(curr+1, arr, used);
	    //generating sets which start with false
	    used[curr] = false;
	    goSets(curr+1, arr, used);
	}
    }
}
class ED201{
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	Playlist p = new Playlist();
	p.read(stdin);
	p.getResult();
    }
}
