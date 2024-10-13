import java.util.Scanner;
class Balanced{
    String line;
    char[] allowedSymbols = {'(', ')', '[', ']'};
    
    public void read(Scanner stdin){
	line = stdin.nextLine();
    }
    public char inverse(char c){
	if(c == '(') return ')';
        return ']';
    }
    public boolean contains(char c){
	for(int i=0;i<allowedSymbols.length;i++){
	    if(c == allowedSymbols[i]) return true;
	}
	return false;
    }
    public void balanced(){
	MyStack<Character> stack = new LinkedListStack<Character>();
	for(int i=0;i<line.length();i++){
	    if(!contains(line.charAt(i))) continue; //if not one of the allowed symbols, then go to next one
	    
	    if((line.charAt(i)==')' || line.charAt(i)==']') && stack.size()==0){
		System.out.println("Erro na posicao "+ i);
		return;
	    }
	    if(line.charAt(i)=='(' || line.charAt(i)=='[') {
		stack.push(line.charAt(i));
		continue;
	    }
	    if(line.charAt(i)!=inverse(stack.top())){
		System.out.println("Erro na posicao "+ i);
		return;
	    }
	    stack.pop();   
	}	
	if(stack.size() != 0){
	    System.out.println("Ficam parenteses por fechar");
	    return;
	}
	System.out.println("Expressao bem formada");
    }
}
class ED007{
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	int n = stdin.nextInt();
	String m = stdin.nextLine();//removing first empty string after int
	for(int i=0;i<n;i++){
	    Balanced p = new Balanced();
	    p.read(stdin);
	    p.balanced();
	}
    }	
}
