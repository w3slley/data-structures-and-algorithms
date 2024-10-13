class ED195{
    public static char inverse(char c){
	if(c == '(') return ')';
        return ']';
    }
    public static boolean balanced(String s){
	MyStack<Character> stack = new LinkedListStack<Character>();
	for(int i=0;i<s.length();i++){
	    if((s.charAt(i)==')' || s.charAt(i)==']') && stack.size()==0) return false;
	    if(s.charAt(i)=='(' || s.charAt(i)=='[') {
		stack.push(s.charAt(i));
		continue;
	    }
	    if(s.charAt(i)!=inverse(stack.top())) return false;
	    stack.pop();
	}
	if(stack.size() != 0) return false;
	return true;
    }
}
