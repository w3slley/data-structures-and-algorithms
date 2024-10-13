class ED213{
    static int maxVal;
    static String bestPath;
    public static String maxSum(BTree<Integer> t){
	maxVal = 0;
	maxSum(t.getRoot(), 0, "");
	return bestPath;
    }
    private static void maxSum(BTNode<Integer> n, int sum, String path){
	if(n == null) return;
	sum+=n.getValue();
	if(sum > maxVal) {
	    maxVal = sum;
	    bestPath = path;
	}
	maxSum(n.getLeft(), sum, path+"E");
	maxSum(n.getRight(), sum, path+"D");
    }
}

