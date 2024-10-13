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

class ED185{
    public static void main(String[] args){
	BigNumber n51 = new BigNumber("4792");
	BigNumber n52 = new BigNumber("5831");
	BigNumber s = n52.multiply(n51);
	System.out.println(s);
	
	BigNumber n1 = new BigNumber("1");
	BigNumber n2 = new BigNumber("2");
	BigNumber n3 = new BigNumber("2361736176326363");
	BigNumber n4 = new BigNumber("7362767647676737");
	BigNumber n5 = new BigNumber("12378123783987389174692846829");
	BigNumber n6 = new BigNumber("87621876216012610825307153171");
	BigNumber n7 = new BigNumber("28347923749823749872395872985798598579585");
	BigNumber n8 = n1.multiply(n2);
	BigNumber n9 = n3.multiply(n2);
	BigNumber n10 = n3.multiply(n4);
	BigNumber n11 = n4.multiply(n5);
	BigNumber n12 = n6.multiply(n5);
	BigNumber n13 = n5.multiply(n6);
	BigNumber n14 = n6.multiply(n7);
	BigNumber n15 = n14.multiply(n13);
	BigNumber n16 = n15.multiply(n14);
	System.out.println("n1= "+n1);
	System.out.println("n2= "+n2);
	System.out.println("n3= "+n3);
	System.out.println("n4= "+n4);
	System.out.println("n5= "+n5);
	System.out.println("n6= "+n6);
	System.out.println("n7= "+n7);
	System.out.println("n8= "+n8);
	System.out.println("n9= "+n9);
	System.out.println("n10= "+n10);
	System.out.println("n11= "+n11);
	System.out.println("n12= "+n12);
	System.out.println("n13= "+n13);
	System.out.println("n14= "+n14);
	System.out.println("n15= "+n15);
	System.out.println("n16= "+n16);
	
	

    }
}
