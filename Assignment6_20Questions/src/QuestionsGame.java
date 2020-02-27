//Scott Blake
//CS 143
//
//This code will play a game of 20 questions by reading in questions
//from a binary search tree, and using recursive calls to determine
//if a choice is a question or an answer

import java.io.*;
import java.util.*;

public class QuestionsGame {
	
	//Instance variables
	private QuestionNode overallRoot;
	private static Scanner console;
	
	//constructor that accepts a string 
	public QuestionsGame(String object) {
		overallRoot = new QuestionNode(object);
		console = new Scanner(System.in);
	}
	
	//constructor that accepts input from a file
	public QuestionsGame(Scanner fileIn) {
		console = new Scanner(System.in);
		overallRoot = readTree(fileIn);
		
	}
	
	// QuestionsGame(Scanner fileIn) recursive helper method
	// reads input from a file and loads them into a binary 
	// search tree based on whether it is a question or an 
	// answer
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
	
	//Makes use of recursive method that writes questions and answers
	//to a file
	public void saveQuestions(PrintWriter fileOut) {
		writeTree(fileOut, overallRoot);
	}
	
	// saveQuestions recursive helper method
	// writes a question and answer to the question to a file 
	// if it is not already in the selected file
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
	// plays 20 question game by reading in outputs from a file, then based on user input
	// recursively calls the method and traces a binary search tree to ask questions 
	// to determine an object
    private QuestionNode play(QuestionNode root) {
    	if(root != null) {
    		if(root.left != null && root.right != null) {
    			System.out.println(root.data);
    			if(console.nextLine().toLowerCase().charAt(0) == 'y') {
    				root.left = play(root.left);
    			}
    			else {
    				root.right = play(root.right);
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
