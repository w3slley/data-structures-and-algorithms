import java.util.Scanner;
class Game{
    private int numWords = 0;
    private int numPlayers;
    private CircularLinkedList<String> players;
    private String loser;
    
    public void read(Scanner stdin){
	String str = "";//string responsible to store input values
	while(!stdin.hasNextInt()){
	    str+=stdin.next();
	    numWords++; 
	}	
        numPlayers = stdin.nextInt();
	players = new CircularLinkedList<>();
	for(int i=0;i<numPlayers;i++)
	    players.addLast(stdin.next());
    }

    public void play(){
	while(numPlayers !=1){
	    for(int i=0;i<numWords-1;i++)//loop will occur numWords-1 times because the counting starts at the first element.
		players.rotate();
	    players.removeFirst();
	    numPlayers--;
	}
	loser = players.getFirst();
	showResult();	
    }

    public void showResult(){
	if(loser.equals("Carlos")) System.out.println("O Carlos nao se livrou");
	else System.out.println("O Carlos livrou-se (coitado do "+loser+"!)");
    }
}
class ED006{
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	int n = stdin.nextInt();
	for(int i=0;i<n;i++){
	    Game g = new Game();
	    g.read(stdin);
	    g.play();
	}
    }
}
