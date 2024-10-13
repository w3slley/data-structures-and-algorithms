import java.util.Scanner;
class UniqueName{
    private String[] namesArr;
    private BSTree<String> namesTree;
    public void read(Scanner stdin){
	int n = stdin.nextInt();
	namesArr = new String[n];
	for(int i=0;i<n;i++) namesArr[i] = stdin.next();
	process();
    }

    public void process(){
	namesTree = new BSTree<String>();
	for(int i=0;i<namesArr.length;i++) namesTree.insert(namesArr[i]);
    }

    public void printNumUniqueNames(){
	System.out.println(namesTree.numberNodes());
    }
}

class ED164{
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	UniqueName u = new UniqueName();
	u.read(stdin);
	u.printNumUniqueNames();
    }
}
