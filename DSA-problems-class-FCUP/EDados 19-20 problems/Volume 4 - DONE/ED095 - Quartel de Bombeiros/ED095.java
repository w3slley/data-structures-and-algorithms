import java.util.Scanner;
class Firefighter{
    String name;
    int numEvents;
    int minutesWorked;

    Firefighter(String name){
	this.name = name;
	this.numEvents = 0;
	this.minutesWorked = 0;
    }

    public String toString(){
	return "[name: "+name+", minutesWorked: "+minutesWorked+", numEvents: "+numEvents+"]";
    }
}
class FireEvent{
    int id;
    int numFirefighters;
    Firefighter[] firefighters;
    int timeLeft;
    int timeArrived;

    FireEvent(int id, Firefighter[] firefighters, int timeLeft){
	this.id = id;
	this.numFirefighters = firefighters.length;
        this.firefighters = firefighters;
	this.timeLeft = timeLeft;
	this.timeArrived = 0;
    }

    public String toString(){
	return "{id= "+id+", firefighters="+firefighters.length+", timeleft= "+timeLeft+", timeArrived= "+timeArrived+"}";
    }
}

class FireDepartment{
    MyQueue<Firefighter> firefightersQueue = new LinkedListQueue<>();
    CircularLinkedList<FireEvent> events = new CircularLinkedList<>();
    int numFirefighters;

    public int getMinimumId(){
	int min = events.getFirst().id;
	for(int i=0;i<events.size();i++){
	    if(events.getFirst().id<min){
		min = events.getFirst().id;
	    }
	    events.rotate();
	}
	return min;
    }
    public void process(Scanner stdin){
	numFirefighters = stdin.nextInt();
	stdin.nextLine();

	for(int i=0;i<numFirefighters;i++){//reading firefighters
	    Firefighter f = new Firefighter(stdin.nextLine());
	    firefightersQueue.enqueue(f);
	}

	while(stdin.hasNext()){//reading events
	    String l = stdin.nextLine();
	    if(l.equals("FIM")) break;
	    
	    Scanner line = new Scanner(l);	
	    String action = line.next();
	    int id = Integer.parseInt(line.next());
	    if(action.equals("PARTIDA")){
		int numFirefighters = Integer.parseInt(line.next());
		int timeLeft = Integer.parseInt(line.next());
		//making sure only available firefighters are asigned to an event
		if(numFirefighters > firefightersQueue.size())
		    numFirefighters = firefightersQueue.size();
		//add firefighters to array
		Firefighter[] firefighters = new Firefighter[numFirefighters];
		
		for(int i=0;i<numFirefighters;i++){
		    firefighters[i] = firefightersQueue.dequeue();
		}
		//adding event to event circular linked list
		FireEvent e = new FireEvent(id, firefighters, timeLeft);
		events.addLast(e);
	    }
	    else{
		int timeArrived = Integer.parseInt(line.next());
		FireEvent matchedEvent= events.getFirst();
		for(int i=0;i<events.size();i++){
		    if(events.getFirst().id == id){
			matchedEvent = events.getFirst();
			break;
		    }
		    events.rotate();
		}
		matchedEvent.timeArrived = timeArrived;
		for(int i=0;i<matchedEvent.firefighters.length;i++){
		    if(matchedEvent.firefighters[i]!=null){//adding timed worked+numEvents for each firefighter
			matchedEvent.firefighters[i].minutesWorked+=matchedEvent.timeArrived-matchedEvent.timeLeft;
			matchedEvent.firefighters[i].numEvents++;
		    }
		    //return firefighters to department
		    firefightersQueue.enqueue(matchedEvent.firefighters[i]);
		}
	    }
	}
    }

    public void showResult(int flag){
	//Showing results for each flag
	if(flag==1){
	    System.out.println("Ocorreram "+events.size()+" eventos");
	}
	else if(flag==2){
	    StringBuilder str = new StringBuilder();
	    str.append("Bombeiros Destacados");
	    str.append("\n");
	    //dealing with first event id
	    int initial = getMinimumId();
	    int delta=0;
	    if(initial!=0) delta=1;
	    int eventSize = events.size();

	    for(int i=initial;i<eventSize+delta;i++){	    
	        str.append("EVENTO "+i);
		str.append("\n");
		while(events.getFirst().id!=i){
		    events.rotate();
		}
		if(events.getFirst().firefighters.length==0){
		    str.append("Nenhum");
		    str.append("\n");
		    continue;
		}

		for(int j=0;j<events.getFirst().firefighters.length;j++){
		    str.append(events.getFirst().firefighters[j].name);
		    if(!(i==(eventSize+delta-1) && j==events.getFirst().firefighters.length-1)){
			str.append("\n");
		    }
		}
	    }
	    System.out.println(str);
	}
	else{
	    System.out.println("Listagem de Bombeiros");
	    while(!firefightersQueue.isEmpty()){
		Firefighter f = firefightersQueue.dequeue();
		String name = f.name;
		int numEvents = f.numEvents;
		int minutesWorked = f.minutesWorked;
		    
		System.out.println(name+" "+numEvents+" "+minutesWorked);
	    }
	}	
    }
}
class ED095{
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	int flag = stdin.nextInt();
	FireDepartment firedp = new FireDepartment();
	firedp.process(stdin);
	firedp.showResult(flag);
    }
}

    
