import java.util.Arrays;
class DAA005{
    public static void main(String[] args){
	FastScanner stdin = new FastScanner(System.in);
	int n = stdin.nextInt();
	int[] energies = new int[n];
	int[] sumCumul = new int[n+1];
	for(int i=0;i<n;i++){
	    energies[i] = stdin.nextInt();
	    sumCumul[i+1] = energies[i] + sumCumul[i];
	}
	int f = stdin.nextInt();
	for(int i=0;i<f;i++){
	    int a = stdin.nextInt();
	    int b = stdin.nextInt();
	    if(a==0) a = 1;
	    FastPrint.out.println(sumCumul[b] - sumCumul[a-1]);
	}
	FastPrint.out.close();
    }
}
