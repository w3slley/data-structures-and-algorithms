import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

class Customer{
    public String name;
    public int numProducts;
    public int timeArrived;
    public int timeFinished;
    
    Customer(String name, int timeArrived, int numProducts){
	this.name = name;
	this.timeArrived = timeArrived;
	this.numProducts = numProducts;
    }
    public String toString(){
	return "["+name+","+timeArrived+","+numProducts+","+timeFinished+"]";
    }
}

class Checkout{
    public int numClients;
    public int totalNumProducts=0;
    public int totalNumClients=0;
    public int k;
    public int delay;
    public int lastFinished;
    public MyDeque<Customer> line = new LinkedListDeque<>();

    Checkout(int k){
	this.k = k;
	numClients = 0;
    }
    public void addCustomer(Customer c){
	line.addFirst(c);
	numClients++;
	totalNumClients++;
	totalNumProducts +=c.numProducts;

	if(c.timeArrived < this.lastFinished)
	    this.delay = this.lastFinished-c.timeArrived;
	else
	    this.delay = 0;
	int finished = c.timeArrived+10+(c.numProducts*this.k)+this.delay;
	this.lastFinished = finished;
	c.timeFinished = finished;//keeping track when consumer is done on the checkout. If there is another customer on the line and its arrivedTime is greater then this timeFinished, the client with the timeFinished should get out of the queue.

    }
    public Customer getFirstOnLine(){
	return this.line.last();
    }
    public Customer getLastOnLine(){
	return this.line.first();
    }
    public void popFirstOfLine(){
	this.line.removeLast();
	numClients--;
    }
    public String toString(){
	return "{"+line+"|lastFinished = "+lastFinished+"|size= "+numClients+"}";
    }
}

class Supermarket{
    int numCheckouts, numCustomers;
    Checkout[] checkouts;
    MyQueue<Customer> clientsQueue = new LinkedListQueue<>();

    public void read(Scanner stdin){
	int flag = stdin.nextInt();
	numCheckouts = stdin.nextInt();
	checkouts = new Checkout[numCheckouts];
	
	for(int i=0;i<numCheckouts;i++)
	    checkouts[i] = new Checkout(stdin.nextInt());

	numCustomers = stdin.nextInt();
	stdin.nextLine();//move cursor to next line

	if(flag == 1){
	    for(int j=0;j<numCheckouts;j++)
		processFlagOne(stdin, j);
	}

	if(flag == 2){
	    for(int l=0;l<numCustomers;l++){//populating clients queue
		Scanner newline = new Scanner(stdin.nextLine());
		String name = newline.next();
		int arrived = newline.nextInt();
		int numProducts = newline.nextInt();
		Customer c = new Customer(name, arrived, numProducts);
		clientsQueue.enqueue(c);
	    }
	    int clientQueueInitSize = clientsQueue.size();
	    for(int i=0;i<clientQueueInitSize;i++)
		processFlagTwo();
	    for(int i=0;i<numCheckouts;i++)
		System.out.println("Caixa #"+(i+1)+": "+checkouts[i].totalNumClients+" "+checkouts[i].totalNumProducts);
	}

    }
    public void processFlagOne(Scanner stdin, int j){
	for(int i=0;i<numCustomers;i++){
	    Scanner newline = new Scanner(stdin.nextLine());
	    String name = newline.next();
	    int arrived = newline.nextInt();
	    int numProducts = newline.nextInt();
	    Customer c = new Customer(name, arrived,numProducts);//creating customer object
	    checkouts[j].addCustomer(c);//adding customer to checkout object
	    //printing result
	    System.out.println(checkouts[j].getLastOnLine().name+" "+checkouts[j].getLastOnLine().timeArrived+" "+checkouts[j].lastFinished);
	}
    }
    public void updateCheckoutQueue(Customer client){
	for(int i=0;i<numCheckouts;i++){
	    if(checkouts[i].numClients == 0) continue;
	    if(client.timeArrived>checkouts[i].getFirstOnLine().timeFinished)
		checkouts[i].popFirstOfLine();
	}
    }

    public void processFlagTwo(){
	int select = 0;
	int minP = 0;
	int minC = 0;
	Customer client = clientsQueue.dequeue();
	updateCheckoutQueue(client);//if the client's time of arrival is greater then the finishing time of the first customer on line, then that customer gets out of the line and the queue is updated;
	for(int i=0;i<numCheckouts;i++){
	    if(i==0 && !checkouts[i].line.isEmpty()){
		minP = checkouts[i].getLastOnLine().numProducts;
		minC = checkouts[i].numClients;
	    }
	    if(checkouts[i].numClients == 0){
	        select = i;	
		break;
	    }
	    else if(checkouts[i].numClients < minC){ //the following else if gets selects the checkout with the least number of clients
		minC = checkouts[i].numClients;
		minP = checkouts[i].getLastOnLine().numProducts;
		select = i;
				
	    }
	    //and, in case of a draw, the checkout with the last client having the least number of products.
	    else if(checkouts[i].numClients == minC && checkouts[i].getLastOnLine().numProducts < minP){
		minC = checkouts[i].numClients;
		minP = checkouts[i].getLastOnLine().numProducts;
		select = i;
	    }
	}
	checkouts[select].addCustomer(client);//adding customer to checkout line
    }
}

class ED115{
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	Supermarket n = new Supermarket();
	n.read(stdin);
    }
}
