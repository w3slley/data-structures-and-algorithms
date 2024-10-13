import java.util.TreeMap;

class Bakugan implements Comparable<Bakugan>{
    int power;
    Bakugan(int p){
	this.power = p;
    }

    public int compareTo(Bakugan b){
	return this.power - b.power;
    }

    public String toString(){
	return this.power+"";
    }
}
class DAA021{
    public static void main(String[] args){
	FastScanner stdin = new FastScanner(System.in);
	int A = stdin.nextInt();
	int R = stdin.nextInt();
	TreeMap<Bakugan, Integer> bakugans = new TreeMap<>();
	
	for(int i=0;i<A+R;i++){
	    String s = stdin.nextLine();
	    if(s.equals("MIN")){
		Bakugan min = bakugans.firstKey();
		System.out.println(min);
		int count = bakugans.get(min);
		if(count == 1)
		    bakugans.remove(min);
		else
		    bakugans.put(min,count-1);
	    }
	    else if(s.equals("MAX")){
		Bakugan max = bakugans.lastKey();
		System.out.println(max);
		int count = bakugans.get(max);
		if(count == 1)
		    bakugans.remove(max);
		else
		    bakugans.put(max,count-1);
	    }
	    else{
	        int power = Integer.parseInt(s.split(" ")[1]);
		Bakugan p = new Bakugan(power);
		Integer c = bakugans.get(p); //occurrence of a given bakugan
		if(c != null)//if there is a bakugan with the same power as this, increase number of occurrence
		    bakugans.put(p, c+1);
		else//otherwise, just add a new one
		    bakugans.put(p, 1);
	    }
	}
    }
}
