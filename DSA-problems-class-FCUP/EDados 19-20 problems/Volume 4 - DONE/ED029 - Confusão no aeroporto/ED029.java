import java.util.Scanner;

class FlightControl{
    LinkedListQueue<String[]> takeOff = new LinkedListQueue<>();//queue which stores takeOff flights
    LinkedListQueue<String[]> land = new LinkedListQueue<>();//queue which stores landing flights
    LinkedListQueue<String[]> takeOffResult = new LinkedListQueue<>();
    LinkedListQueue<String[]> landResult = new LinkedListQueue<>();
    int numTakeOff,numLand;//number of cases for takeoff and landing
    //delays
    int delayTakeOff = 0;
    int delayLand = 0;
    public void read(Scanner stdin){
	numTakeOff = stdin.nextInt();
	numLand = stdin.nextInt();
	String m = stdin.nextLine();//responsible for move cursor to next line
	for(int i=0;i<numTakeOff;i++){
	    String planeTakeOff= stdin.next();
	    String minuteTakeOff = stdin.next();
	    String delay = "0";
	    String[] plane = {planeTakeOff, minuteTakeOff, delay};
	    takeOff.enqueue(plane);
	    m = stdin.nextLine();//move cursor to next line
	}
	for(int i=0;i<numLand;i++){
	    String planeLand= stdin.next();
	    String minuteLand = stdin.next();
	    String delay = "0";
	    String[] plane = {planeLand, minuteLand, delay};
	    land.enqueue(plane);
	}
	//this variable keeps track of how many minutes went by since the first comparison.
	int minute= Math.min(Integer.parseInt(takeOff.first()[1]), Integer.parseInt(land.first()[1]));
	while(true){
	    int timeFirstTakeOff, timeFirstLand;
	    if(takeOff.isEmpty() && land.isEmpty())
	        break;
	    else if(land.isEmpty()){
		timeFirstTakeOff = Integer.parseInt(takeOff.first()[1]);
		timeFirstLand = 0;
	    }
	    else if(takeOff.isEmpty()){//only happens on initial conditions (not at the end)
		timeFirstTakeOff = 0;
		timeFirstLand = Integer.parseInt(land.first()[1]);
	    }
	    else{
		timeFirstTakeOff = Integer.parseInt(takeOff.first()[1]);
		timeFirstLand = Integer.parseInt(land.first()[1]);
	    }
	    if(minute >= timeFirstTakeOff || minute >= timeFirstLand)
		compare(timeFirstTakeOff, timeFirstLand, minute);
	    minute++;
	}
    }
    public void compare(int timeFirstTakeOff, int timeFirstLand, int minute){

	 if(minute>=timeFirstTakeOff)
		delayTakeOff = minute-timeFirstTakeOff;
	 
	  if(minute>=timeFirstLand)
		delayLand = minute-timeFirstLand;
	  
	//if one of queues is empty
	if(timeFirstLand == 0){
	    takeOff.first()[2] = delayTakeOff+"";
	    takeOffResult.enqueue(takeOff.dequeue());
	    return;
	}
	if(timeFirstTakeOff == 0){
	    land.first()[2] = delayLand+"";
	    landResult.enqueue(land.dequeue());
	    return;
	}
	
	if(timeFirstTakeOff == timeFirstLand){
	    delayTakeOff++;
	    land.first()[2] = delayLand+"";
	    landResult.enqueue(land.dequeue());
	}
	else if(timeFirstTakeOff > timeFirstLand){
	    land.first()[2] = delayLand+"";
	    landResult.enqueue(land.dequeue());
	}
	else if(timeFirstTakeOff<timeFirstLand && delayTakeOff>delayLand){
	    delayLand++;
	    takeOff.first()[2] = delayTakeOff+"";
	    takeOffResult.enqueue(takeOff.dequeue());
	}
	else{
	    takeOff.first()[2] = delayTakeOff+"";
	    takeOffResult.enqueue(takeOff.dequeue());
	}

    }
    public void getFlightResults(){
	System.out.println(numTakeOff+" "+numLand);
	for(int i=0;i<numTakeOff;i++){
	    String[] first = takeOffResult.dequeue();
	    System.out.println(first[0]+" "+first[2]);
	}
	for(int j=0;j<numLand;j++){
	    String[] first = landResult.dequeue();
	    System.out.println(first[0]+" "+first[2]);
	}
    }
}
class ED029{
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	int c = stdin.nextInt();
	for(int i=0;i<c;i++){
	    FlightControl planes = new FlightControl();
	    planes.read(stdin);
	    planes.getFlightResults();
	}
    }
}
