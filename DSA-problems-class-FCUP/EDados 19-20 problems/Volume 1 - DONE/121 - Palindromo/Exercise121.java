import java.util.Scanner;
class Exercise121{
	static Boolean isPalindrome(String str){
		String s = str.replaceAll("\\s", "").toLowerCase();//removing whitespaces in java 
		String strInput="";
		//ineficient way. improve this
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)>='a' && str.charAt(i)<='z'){
				strInput += s.charAt(i);
			}
		}
		String reverse = "";
		for(int i=strInput.length()-1;i>=0;i--){
			if(strInput.charAt(i)>='a' && strInput.charAt(i)<='z'){
			reverse += strInput.charAt(i);
			}
		}
		if(reverse.equals(strInput)){
			return true;
		}
		else{
			return false;
		}
	}
	public static void main(String[] args){
		Scanner stdin = new Scanner(System.in);
		String n = stdin.nextLine();//getting rid of the first number and running the isPalindrome function only on the phrases
		System.out.println(n);
		while(stdin.hasNextLine()){	
			if(isPalindrome(stdin.nextLine())){
				System.out.println("sim");
			}
			else{
				System.out.println("nao");
			}			
		}			
	}
}