class ED194{
    public static void reverse(MyStack<Integer> s, int n){
	int[] arr = new int[n];
        for(int i=0;i<n;i++)
	    arr[i] = s.pop();

	for(int j=0;j<n;j++){
	    s.push(arr[j]);
	}
    }
}
