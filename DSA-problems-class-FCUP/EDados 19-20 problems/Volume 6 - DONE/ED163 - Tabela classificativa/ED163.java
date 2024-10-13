import java.util.Scanner;
import java.util.Arrays;

class Team implements Comparable<Team>{
    private String name;
    private Integer points, goalAverage;

    Team(String name, int victories, int draws, int losses, int goalsScored, int goalsTaken){
	this.name = name;
	this.points = victories*3+draws;
	this.goalAverage = goalsScored-goalsTaken;
    }

    public int compareTo(Team t){
	if(points.compareTo(t.points)==0){
	    if(goalAverage.compareTo(t.goalAverage)==0)
		return name.compareTo(t.name);
	
	    return -goalAverage.compareTo(t.goalAverage);
	}
	
	return -points.compareTo(t.points);
    }
    public String toString(){
	return name+" "+points+" "+goalAverage;
    }
}

class ED163{
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	int n = stdin.nextInt();
	stdin.nextLine();
	Team[] arr = new Team[n];
	//Adding teams to array
	for(int i=0;i<n;i++){
	    String name = stdin.next();
	    int victs = stdin.nextInt();
	    int draws = stdin.nextInt();
	    int losses = stdin.nextInt();
	    int gScored = stdin.nextInt();
	    int gTaken = stdin.nextInt();
	    arr[i] = new Team(name,victs,draws,losses,gScored,gTaken);
	    stdin.nextLine();
	}
	//sorting array
	Arrays.sort(arr);
	//building string
	StringBuilder str = new StringBuilder();
	for(int j=0;j<n;j++)
	    str.append(arr[j]+"\n");
	
	System.out.print(str);

    }
}
