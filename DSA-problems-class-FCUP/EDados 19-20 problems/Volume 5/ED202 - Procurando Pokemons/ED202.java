import java.util.Scanner;
class Permutations{
    public static void permutations(int arr[]){
	boolean used[] = new boolean[arr.length];
	int perm[] = new int[arr.length];
	goPermutation(0, arr, used, perm);
    }
    
    public static void goPermutation(int curr, int arr[], boolean[] used, int[] perm){
	if(curr == arr.length){ //the entire array was traversed
	    for(int i=0;i<arr.length;i++){
		System.out.print(arr[perm[i]]+" ");
	    }
	    System.out.println();
	}
	else
	    for(int i=0;i<arr.length;i++)
		if(!used[i]){
		    used[i] = true;
		    perm[curr] = i;
		    goPermutation(curr+1, arr, used, perm);
		    used[i] = false;
		}
    }
}

class PokemonAdventure{
    String[] places;
    double[][] data;

    PokemonAdventure(int n){
	places = new String[n];
	data = new double[n][n];
    }
    public void read(Scanner stdin){
	int n = places.length;
	for(int i=0;i<n;i++)
	    places[i] = stdin.next();
	
	stdin.nextLine();
	
	for(int i=0;i<n;i++){
	    for(int j=0;j<n;j++){
	        System.out.println(stdin.next());
	    }
	}
    }

}

class ED202{
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	int n = stdin.nextInt();
	PokemonAdventure p = new PokemonAdventure(n);
	p.read(stdin);
        int[] arr = {1,2,3};
	//Permutations.permutations(arr);
    }
}
