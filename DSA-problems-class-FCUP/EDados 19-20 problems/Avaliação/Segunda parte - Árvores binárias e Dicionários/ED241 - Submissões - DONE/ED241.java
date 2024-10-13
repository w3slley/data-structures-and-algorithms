import java.util.Scanner;

class Submission{
    BSTMap<String,Integer> students;
    BSTMap<String,Integer> problems;
    int maxSubmission;
    String problemMaxSubmission;
    BSTMap<String,Integer> problemsAccepted;
    BSTMap<String,BSTree<String>> problemsDone;

    Submission(){
	students = new BSTMap<String,Integer>();
	problems = new BSTMap<String,Integer>();
	problemsAccepted = new BSTMap<String,Integer>();
	maxSubmission = 0;
	problemsDone = new  BSTMap<String,BSTree<String>>();
    }
    public void read(Scanner stdin){
	int n = stdin.nextInt();
	for(int m=0;m<n;m++){
	    String name = stdin.next();
	    String problem = stdin.next();
	    String status = stdin.next();
	    //for flag 1
	    Integer i = students.get(name);
	    if(i == null)
		students.put(name, 1);
	    else
		students.put(name,i+1);

	    //for flag 2
	    Integer j = problems.get(problem);
	    if(j == null){
		problems.put(problem,1);
		j = 0;
	    }
	    else
		problems.put(problem,j+1);
	    
	    if(j+1 > maxSubmission) {
		maxSubmission = j+1;
		problemMaxSubmission = problem;
	    }
	    
	    //for flag 3
	    Integer k = problemsAccepted.get(problem);
	    if(status.equals("Accepted")){
		if(k == null)
		    problemsAccepted.put(problem,1);
		else
		    problemsAccepted.put(problem,k+1);
	    }

	    //for flag 4
	    BSTree<String> set = problemsDone.get(name);
	    if(status.equals("Accepted")){
		if(set == null){
		    BSTree<String> p = new BSTree<>();
		    p.insert(problem);
		    problemsDone.put(name,p);
		}
		else{
		    set.insert(problem);
		    problemsDone.put(name,set);
		}
	    }
	}
    }

    public void process(int flag){
	if(flag == 1)
	    System.out.println(students.size());
	
	else if(flag == 2)
	    System.out.println(problemMaxSubmission + " " + maxSubmission);
	
	else if(flag == 3){
	    BSTMap<String,Integer> accepted = new BSTMap<>();
	    for(String s : problemsAccepted.keys()){
		if((double) problemsAccepted.get(s)/problems.get(s) >= 0.5)
		    accepted.put(s,0);
	    }

	    for(String s : accepted.keys())
		System.out.println(s);
	}
	else{
	    for(String student : problemsDone.keys()){
		if(problemsDone.get(student).numberNodes() == problems.size())
		  System.out.println(student);
	    }
	}
    }
}

class ED241{
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	int flag = stdin.nextInt();
	Submission s = new Submission();
	s.read(stdin);
	s.process(flag);
    }
}
