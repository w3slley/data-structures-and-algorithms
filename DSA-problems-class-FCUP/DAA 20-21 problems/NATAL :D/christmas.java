import java.util.Arrays;
class christmas{
    static int w=29;
    static int h=28;
    public static void main(String[] args){
	int m=w/2;
	int d,d2,d3;
	d=d2=d3=0;
	for(int i=1;i<=h;i++){
	    char[] t = new char[w+1];
	    Arrays.fill(t,'_');
	    for(int j=1;j<=w;j++){
		if(i>=2&&i<=9)
		    if(j==m-d || j==m+d) t[j]='*';
		if(i>=2 && i<=8){
		    if(j==m-d+1 || j==m+d-1) t[j]='o';
		    if(i>=8&&i<=8){
			if(j==m-d2-2 || j==m+d2+2) t[j]='o';
		    }
		}
		if(i>=6 && i<=14){
		    if(j==m-d2 || j==m+d2) t[j]='o';
		    if(i>=14&&i<=14){
			if(j==m-d3-2 || j==m+d3+2) t[j]='o';
		    }
		}
		if(i>=9 && i<=14){
		   if(j==m-d2-1||j==m+d2+1) t[j]='*';
		}
		if(i>=15 && i<=22){
		    if(j==m-d3-1||j==m+d3+1) t[j] = '*';
		}
		if(i>=11 && i<=22){
		    if(j==m-d3 || j==m+d3) t[j]='o';
		}
		if(i==22&&i<=h)
		    if(j>=4 && j<=23 && j%2!=0) t[j]='o';
	    }
	    if(i>=0&&i<=h)d++;
	    if(i>=6&&i<=h)d2++;
	    if(i>=11&&i<=h)d3++;
	    if(i>=0&&i<=2)t[m]='*';
	    if(i>=28&&i<=28)t[m-1]=t[m]=t[m+1]='o';
	    if(i>=23&&i<=h)t[m-1]=t[m+1]='o';
	    String str="";
	    for(int k=1;k<=w;k++)str+=t[k];
	    System.out.println(str);
	}
    }
}
