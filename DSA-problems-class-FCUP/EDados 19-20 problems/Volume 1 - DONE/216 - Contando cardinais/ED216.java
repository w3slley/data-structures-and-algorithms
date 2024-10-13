import java.util.Scanner;
class ED216{
	static int[] getHashtagNumLine(char[][] arr, int lineNum, int colNum){
		int maxPattern = 0;
		int howManyTimes = 0;
		for(int i=0;i<lineNum;i++){//line by line
			int highest = 0;
			int count = 0;
			for(int j=0;j<colNum;j++){
				if(arr[i][j]=='#'){
					count++;
				}
				else if(arr[i][j]=='.'){
					if(count>highest){
						highest = count;
					}
					count = 0;
				}
			}
			if(count>highest){ highest=count; }
			if(highest>maxPattern){
				maxPattern = highest;
				howManyTimes=1;
			}
			else if(highest == maxPattern){
				howManyTimes++;
			}
		}
		int[] result = {maxPattern, howManyTimes};
		return result;
	}

	static int[] getHashtagNumCol(char[][] arr, int lineNum, int colNum){
		int maxPattern = 0;
		int howManyTimes = 0;
		for(int j=0;j<colNum;j++){//column by column
			int highest = 0;
			int count = 0;
			for(int i=0; i<lineNum;i++){
				if(arr[i][j]=='#'){
					count++;
				}
				else if(arr[i][j]=='.'){
					if(count>highest){
						highest = count;
					}
					count = 0;
				}
			}
			if(count>highest){ highest=count; }
			if(highest>maxPattern){
				maxPattern = highest;
				howManyTimes=1;
			}
			else if(highest == maxPattern){
				howManyTimes++;
			}
		}
		int[] result = {maxPattern, howManyTimes};
		return result;
	}

	public static void main(String[] args){
		Scanner stdin = new Scanner(System.in);
		int a = stdin.nextInt();
		int b = stdin.nextInt();
		char[][] arr = new char[a][b];
		for(int i=0;i<a;i++){//inserting chars into 2d array
			String line = stdin.next();
			for(int j=0;j<b;j++){
				arr[i][j] = line.charAt(j);
			}
		}
		int[] highestLine = getHashtagNumLine(arr, a, b);
		int[] highestCol = getHashtagNumCol(arr, a, b);
		if(highestLine[0]==highestCol[0]){
			System.out.print(highestLine[0]+" ");
			System.out.println(highestLine[1]+highestCol[1]);
		}
		else if(highestLine[0] > highestCol[0]){
			System.out.print(highestLine[0]+" ");
			System.out.println(highestLine[1]);
		}
		else{
			System.out.print(highestCol[0]+" ");
			System.out.println(highestCol[1]);
		}
	}
}