class Test{
    public static void main(String[] args){
	MyStack<Integer> stack = new LinkedListStack<Integer>();
	for(int i=5;i>0;i--)
	    stack.push(i);
	System.out.println("Pilha Inicial: "+stack);
	ED194.reverse(stack,3);
	System.out.println("Invertendo com n=3");
	System.out.println("Pilha final: "+stack);
    }
}
