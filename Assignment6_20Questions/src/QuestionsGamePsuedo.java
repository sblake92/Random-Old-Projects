import java.io.PrintWriter;
import java.util.Scanner;

public class QuestionsGame {

	private QuestionNode overallRoot;
	private static Scanner console;

	public QuestionsGame(String object) {
		// instantiate the console
		console = new Scanner(System.in);
		// instantiate the overallRoot
		overallRoot = new QuestionNode(object);

	}

	public QuestionsGame(Scanner fileIn) {
		//instantiate the console
		
		// call recursive readTree method
		

	}

	// QuestionsGame(Scanner fileIn) recursive helper method
	private QuestionNode readTree(Scanner input) {
		// Declare a QuestionNode named root
		QuestionNode root=null;
		// if there are lines in the input file
		
			// read in a line 
		    // if the line begins with "A"
			
				// read in the next line from the file and construct a QuestionNode with the answer and assign to root
				
		    // else the line begins with "Q:
				// read in the next line from the file and construct a QuestionNode with the question and assign to root
				
				// call recursive readTree for root.left
				
				// call recursive readTree for root.right
				
		// return the root
		return root;
	}

	public void saveQuestions(PrintWriter fileOut) {
		// call the writeTree recursive method
		
	}

	// saveQuestions recursive helper method
	private void writeTree(PrintWriter output, QuestionNode root) {
		// if root is not null
		
			// if root is a question
				// write Q: to file
			// else root is an answer
				// write A: to file
				
			// write root.data to file
			// call writeTree for root.left
			// call writeTree for root.right
			
	}

	public void play() {
		// call recursive play method in x=change(x) style
        
	}

	// play recursive helper method
	private QuestionNode play(QuestionNode root) {
		// if root is not null
       
          // if the node is a question
        	
        		//display question in console
        		
        		// if users replies yes
        		
        			// call recursive play method for root.left (yes is always the left subtree)     			
        			
        		// else user replies no
        			// call recursive play method for root.rignt (no is always the right subtree)
        			
        		
          // else node is an answer - may need to modify tree
        		// display "I guess that your object is _____! Am I right? (y/n)?"
        		
        	    // if user replies yes
        		
        			// display "Awesome! I win!"   			
        			
        	    // else user replies no - need to modify tree
        			// display question "Boo! I Lose. Please help me get better! What is your object?"   			
        			
        			// read in newAnswer and construct a new QuestionNode
        			
        			
        			// display "Please give me a yes/no question that distinguishes between ______ and ______"
        		   
        		    // read in newQuestion and construct a new QuestionNode
        		   
        		    // display question "Is the answer "yes" for ________? (y/n)?"
        		    
        		    // if user replies yes, 
        		    //      assign the newAnswer QuestionNode to the the newQuestion QuestionNode's LEFT and
        		    //      assign the original answer node(root) to the newQuestion QuestionNode's RIGHT
        		    
        		    	
        		    // else user replies no, 
                        //      assign the newAnswer QuestionNode to the the newQuestion QuestionNode's RIGHT and
            		    //      assign the original answer node(root) to the newQuestion QuestionNode's LEFT
        		    	
        		    
        	       // assign newQuestion QuestionNode to the root passed into this recursive call 
        		   
        	
        		
        
        // return the root
		return root;
	}

}
