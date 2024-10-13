import java.util.Scanner;

class Process{
    public String name;
    public int timeLeft;

    Process(String n, int t){
	name = n;
	timeLeft = t;
    }

    public String toString(){
	return name + " " + timeLeft;
    }
}

class RoundRobin{
    int tMax;
    int currTime;
    int iterations;
    MyQueue<Process> queue = new LinkedListQueue<>();

    public void read(Scanner stdin){
	tMax = stdin.nextInt();
	int n = stdin.nextInt();
	for(int i=0;i<n;i++){
	    String name = stdin.next();
	    int time = stdin.nextInt();
	    Process p = new Process(name, time);
	    queue.enqueue(p);
		}	
    }
		
    public void process(){
		iterations = 0;
		currTime = 0;
		while(!queue.isEmpty()){
			//System.out.println("currTime = "+currTime);
			//System.out.println(queue);
			Process first = queue.dequeue();
			iterations++;
			if(first.timeLeft > tMax){
			first.timeLeft-=tMax;
			queue.enqueue(first);
			currTime+=tMax;
			}
			else{
			int culTime = (first.timeLeft+currTime);
			currTime+=first.timeLeft;
			first.timeLeft=0;
			
			System.out.println(first.name + " " + culTime+ " "+iterations);
			
			}
				
		}
		//System.out.println(iterations);
    }
}
class ED237{
    public static void main(String[] args){
		Scanner stdin = new Scanner(System.in);
		RoundRobin r = new RoundRobin();
		r.read(stdin);
		r.process();
    }
}
