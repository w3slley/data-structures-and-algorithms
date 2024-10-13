import java.lang.Math;
class BigNumber{
    protected int[] digits;
    protected int size;

    BigNumber(String n){
	size = n.length();
	digits = new int[size];
	for(int i=0;i<size;i++){
	    digits[i] = n.charAt(size-i-1) - '0'; //how you turn a char into an integer
	}
    }
    public BigNumber add(BigNumber n){
	String result = "";
	int rest = 0;
	int sum = 0;
	int maxSize = Math.max(size, n.size);
	for(int i=0;i<maxSize;i++){
	    //preventing out of bound errors for the strings
	    if(i < n.size && i < size)
		sum = digits[i] + n.digits[i]+ rest;
	    else if(i < size)
		sum = digits[i]+rest;
	    else if(i < n.size)
		sum = n.digits[i]+rest;
	    
	    if(sum >= 10){
		result = sum%10+result;
		rest = sum/10;
		if(i==maxSize-1) result=rest+result;
	    }
	    else{
		result = sum+result;
		rest = 0;
	    }
       	}
	BigNumber answer = new BigNumber(result);
        return answer;
    }
    public BigNumber multiply(BigNumber n){
	//first case where n is only one digit. generalize later.
	String result="";//string that stores partial results 
	String zeros = "";
	BigNumber cumul = new BigNumber("0");//bignumber object that will be added for each multiplication
	int multiplication = 1;
	int rest = 0;
	int maxSize = Math.max(size, n.size);
	for(int i=0;i<size;i++){
	    for(int j=0;j<n.size;j++){
		//	System.out.println("n.digits[j]="+n.digits[j]);
		//System.out.println("digits[i]="+digits[i]);
		multiplication = n.digits[j]*digits[i]+rest;//multiplication of each number
		if(multiplication>=10){
		    result = multiplication%10+result;
		    rest = multiplication/10;
		    //adding rest to result when performing last multiplication with rest
		    if(j==n.size-1){
			result=rest+result;
			rest=0;
		    }
		    
		}
		else{
		    result = multiplication+result;
		    rest=0;
		}
	    }
	    //System.out.println(result);
	    BigNumber curr = new BigNumber(result+zeros);
	    result="";
	    cumul = cumul.add(curr);//adding cumulative result
	    zeros+="0";//increasing zeros for next result
	}
	return cumul;
    }
    public boolean equals(BigNumber n){
	if(size==n.size) {
	    for(int i=0;i<size;i++){
		if(digits[i]!=n.digits[i]) return false;
	    }
	    return true;
	}
	return false;
    }
    public String toString(){
	String answ = "";
	for(int i=0;i<digits.length;i++){
	    answ+=digits[digits.length-i-1];
	}
	return answ;
    }
}
