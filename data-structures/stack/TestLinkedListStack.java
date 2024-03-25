class TestLinkedListStack{
    public static void main(String[] args){
	MyStack<Integer> stack = new LinkedListStack<>();
	stack.push(1);
	stack.push(3);
	stack.push(5);
	stack.push(9);
	stack.push(11);
	System.out.println(stack);
	stack.pop();
	System.out.println(stack.top());
	System.out.println(stack.size());
	System.out.println(stack.isEmpty());
	
	
    }
}
