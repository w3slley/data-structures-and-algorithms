import java.util.Scanner;
import java.util.Arrays;

class Turtle{
    public boolean drawing;//boolean value which indicates if the turtle's pen is up or down
    public int x;//horizontal position
    public int y;//vertical position
    public int i;//position on array direction - changes based whether the turtle's moves left or right
    public char[] directions = {'E', 'S', 'W', 'N'};

    Turtle(){
	x = 0;
	y = 0;
	i = 0;
	drawing=false;
    }
    public char facing(){
	return directions[i];
    }
    
    public void moveLeft(){
	if(i!=0) i--;
	else i=directions.length-1;
    }

    public void moveRight(){
	if(i!=directions.length-1) i++;
	else i=0;
    }
}

class World{
    int rows;
    int cols;
    char[][] grid;
    
    World(int r, int c){
	rows = r;
	cols = c;
	grid = new char[r][c];
	for(int i=0;i<rows;i++)
	    for(int j=0;j<cols;j++)
		grid[i][j]='.';
    }
    //O(s) where s is the number of steps per instruction
    public void moveTurtle(int steps, Turtle turtle){
	if(turtle.drawing) grid[turtle.y][turtle.x] = '*';//fill current position before walking steps if pen is down
	
	for(int i=0;i<steps;i++){
	    //System.out.println("x = "+turtle.x+" y = "+turtle.y);
	    if(turtle.facing()=='E' && turtle.x+1 < rows)
		turtle.x += 1;//walk one position depending on facing direction
	    if(turtle.facing()=='S' && turtle.y+1 < cols)
		turtle.y += 1;
	    if(turtle.facing()=='W' && turtle.x-1 >= 0)
		turtle.x -= 1;
	    if(turtle.facing()=='N' && turtle.y-1 >= 0)
		turtle.y -= 1;
	    //else, the turtle stays at the same position
	    if(turtle.drawing) grid[turtle.y][turtle.x] = '*';//fill again after moving if pen's down
	}
    }

    //O(N*s) on worse case (s is the number of steps in a forward command)
    public void process(Scanner stdin){
	Turtle turtle = new Turtle();
	while(stdin.hasNext()){
	    String command = stdin.next();
	    if(command.equals("D")) {//O(1)
		turtle.drawing = true;
		grid[turtle.y][turtle.x] = '*';//had to fill position everytime the turtle puts the pen down...
	    }
	    if(command.equals("U")) turtle.drawing = false;//O(1)
	    if(command.equals("L")) turtle.moveLeft();//O(1)
	    if(command.equals("R")) turtle.moveRight();//O(1)
	    if(command.equals("F")){
		int steps = stdin.nextInt();
		moveTurtle(steps, turtle);//O(s)
	    }
	    if(command.equals("end")) break;
	}
	
	
    }
    
    public boolean checkImage(Scanner stdin){
	//input grid
	int rowsInput = stdin.nextInt();
	int colsInput = stdin.nextInt();
	char[][] gridInput = new char[rowsInput][colsInput];
	for(int i=0;i<rowsInput;i++)
	    for(int j=0;j<colsInput;j++)
		gridInput[i][j] = stdin.next().charAt(0);
	//one strategy: split grid into all it's rowsInput x colsInput forms and compare to gridInput using function Arrays.deepEquals()
	char[][] temp = new char[rowsInput][colsInput];
	boolean found = false;
	for(int v=0;v<rows-rowsInput+1;v++){
	    for(int h=0;h<cols-colsInput+1;h++){
		for(int i=0;i<rowsInput;i++)
		    for(int j=0;j<colsInput;j++)
			temp[i][j] = grid[i+v][j+h];
		if(Arrays.deepEquals(temp, gridInput))
		    found = true;
	    }
	}
	return found;
    }

    public void show(int flag, Scanner stdin){
	if(flag == 0)
	    printArray();
	else if(flag == 1)
	    printStats();
	else{
	    if(checkImage(stdin)) System.out.println("Sim");
	    else System.out.println("Nao");
	}
    }
    
    //O(rows*cols)
    public void printArray(){
	for(int i=0;i<rows;i++){
	    for(int j=0;j<cols;j++){
		System.out.print(grid[i][j]);
		if(j!=cols-1) System.out.print(' ');
	    }
	    System.out.println();
	}
    }
    //O(rows*cols)
    public void printStats(){
	int filled = 0;
	//number of positions filled
	for(int i=0;i<rows;i++){
	    for(int j=0;j<cols;j++){
		if(grid[i][j]=='*') filled++;
	    }
	}

	//rows not filled
	int rowsNotFilled = 0;
	outerloop:
	for(int i=0;i<rows;i++){
	    for(int j=0;j<cols;j++)
		if(grid[i][j]=='*') continue outerloop;
	    
	    rowsNotFilled++;
	}
	
	//columns not filled
	int colsNotFilled = 0;
	outerloop:
	for(int i=0;i<cols;i++){
	    for(int j=0;j<rows;j++){
		if(grid[j][i]=='*') continue outerloop;
	    }
	    colsNotFilled++;
	}
	System.out.println(100*filled/(rows*cols) + " " + rowsNotFilled + " " + colsNotFilled);
    }
}

class ED101{
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	int flag = stdin.nextInt();
	int rows = stdin.nextInt();
	int cols = stdin.nextInt();
	World w = new World(rows,cols);
	w.process(stdin);
	w.show(flag, stdin);
    }
}
