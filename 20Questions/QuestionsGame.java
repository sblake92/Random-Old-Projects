import java.io.*;
import java.util.*;

public class QuestionsGame {

	private QuestionNode overallRoot;
	private static Scanner console;
	
	public QuestionsGame(String object) {
		overallRoot = new QuestionNode(object);
		console = new Scanner(System.in);
	}
	
	public QuestionsGame(Scanner fileIn) {
		console = new Scanner(System.in);
		overallRoot = readTree(fileIn);
		
	}
	
	// QuestionsGame(Scanner fileIn) recursive helper method
	private QuestionNode readTree(Scanner input) {
		QuestionNode root = null;
	    if(input.hasNextLine()) {
	    	if(input.nextLine().equals("Q:")) {
	    		root = new QuestionNode(input.nextLine());
	    		root.left = readTree(input);
	    		root.right = readTree(input);
	    	}
	    	else {
	    		root = new QuestionNode(input.nextLine());
	    		//root.right = readTree(input);
	    	}
	    }
	    return root;
	    
	}
	
	
	public void saveQuestions(PrintWriter fileOut) {
		writeTree(fileOut, overallRoot);
	}
	
	// saveQuestions recursive helper method
	private void writeTree(PrintWriter output, QuestionNode root) {
		if(root != null) {
			if(root.isQuestion()) {
				output.println("Q:");
			}
			else {
				output.println("A:");
			}
			output.println(root.data);
			writeTree(output, root.left);
			writeTree(output, root.right);			
		}
		return;
	}

	public void play() {
		overallRoot = play(overallRoot);
	}
	
	// play recursive helper method
    private QuestionNode play(QuestionNode root) {
    	if(root != null) {
    		if(root.left != null && root.right != null) {
    			System.out.println(root.data);
    			if(console.nextLine().toLowerCase().charAt(0) == 'y') {
    				play(root.left);
    			}
    			else {
    				play(root.right);
    			}
    		}
    		else {
    			System.out.println("I guess that your object is " + root.data + "! Am I right?");
    			if(console.nextLine().toLowerCase().charAt(0) == 'y'){
    				System.out.println("Awesome I win!");
    			}
    			else {
    				System.out.println("Boo! I lose. Please help me get better! What is your object?");
    				QuestionNode newAnswer = new QuestionNode(console.nextLine());
    				System.out.println("Please give me a yes/no question that destinguishes between " + root.data
    						+ " and " + newAnswer.data);
    				QuestionNode newQuestion = new QuestionNode(console.nextLine());
    				System.out.println("Is the answer \"yes\" for " + "\"" + newQuestion.data + "\"" + "? (y/n)");
    				if(console.nextLine().toLowerCase().charAt(0) == 'y') {
    					newQuestion.left = newAnswer;
    					newQuestion.right = root;
    				}
    				else {
    					newQuestion.right = newAnswer;
    					newQuestion.left = root;
    				}
    				root = newQuestion;
    			}
    			
    		}
    	}
        return root;
    }

	
}
