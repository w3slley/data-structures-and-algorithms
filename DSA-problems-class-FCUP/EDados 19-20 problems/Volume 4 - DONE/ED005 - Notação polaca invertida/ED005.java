import java.util.Scanner;
class RPN{
    String line;
    String[] operators = {"+", "-", "*", "/"};
    MyDeque<Integer> q;
    
    public boolean isOperator(String c){
	for(int i=0;i<operators.length;i++)
	    if(c.equals(operators[i])) return true;
	return false;
    }
    
    public void read(Scanner stdin){
	line = stdin.nextLine();
    }
    
    public void process(){
	Scanner stdinline = new Scanner(line);
	q = new LinkedListDeque<Integer>();
	while(stdinline.hasNext()){
	    String character = stdinline.next(); 
	    if(isOperator(character)){
		if(q.size() < 2) {
		    System.out.println("Expressao Incorrecta");
		    return;
		}
		int l1 = q.removeLast();
		int l2 = q.removeLast();
		if(character.equals("+")){
		    int sum = l2+l1;
		    q.addLast(sum);
		}
		if(character.equals("-")){
		    int sub = l2-l1;
		    q.addLast(sub);
		}
		if(character.equals("*")){
		    int mult = l2*l1;
		    q.addLast(mult);
		}
		if(character.equals("/")){
		    int div = l2/l1;
		    q.addLast(div);
		}
	    }
	    else{
		int number = Integer.parseInt(character) ; //that's how you convert from string to int!
		q.addLast(number);//adding number to queue
	    }

	}
	if(q.size()==1) System.out.println(q.first()); //if there is one number, that's the result
        if(q.size()>1) System.out.println("Expressao Incorrecta");//for cases when there are numbers left in the queue*/
    }
}

class ED005{
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	int n = stdin.nextInt();
	String m = stdin.nextLine();//remove first empty space from input before operations
	RPN notacao = new RPN();
	for(int i=0;i<n;i++){
	    notacao.read(stdin);
	    notacao.process();
	}
    }
}
