// Scott Blake
// CS 143
// 19 April 2018
//
// Homework Assignment #1: ArrayList CS 141 Review
// 
// This class will allow a person to manipulate a set of 
// grades in the class GradeClient.


import java.io.*; 
import java.util.*;

public class Grades {
	
	private ArrayList<Double> grades;
   
   // Default constructor: empty  
	public Grades() {
		this.grades = new ArrayList <Double>();
	}
	
   // Constructor that allows ArrayList to be filled
   // with data from a file 
	public Grades(String filename){  
		this.grades = new ArrayList<Double>();
   }
	
   // Reads in data from a file and loads it to 
   // the ArrayList
	public void readGrades(String filename){
      try{
        Scanner in = new Scanner(new File(filename));
        while(in.hasNext()){
         grades.add(in.nextDouble());
        }
      }catch(FileNotFoundException e){
      
      }
   }
   
   // Calculates the mean of all grades in the
   // ArrayList
   public Double calcAverage(){
      double total = 0;
      for(int i = 0; i < grades.size(); i++){
         total += grades.get(i);
      }
      return total / grades.size();  
   }
   
   // Prints and removes the lowest grade in the
   // ArrayList
   public Double dropLowest(){
      double low = Double.MAX_VALUE;
      for(double i : grades){
         low = Math.min(i, low);
      }
      grades.remove(low);
      return low;
   }
   
   // Adds a grade to the ArrayList
   public void addGrade(Double grade){
      grades.add(grade);
   }
   
   // Checks if grade is in the ArrayList and 
   // then removes all instances of it
   public boolean removeAllGrades(Double grade){
      if(!grades.contains(grade)){
         return false;
      }
      else{
         while(grades.contains(grade)){
            grades.remove(grade);
         }
      }
      return true;
   }
   
   // Sorts grades from smallest to largest 
   // and prints the ArrayList 
   public void printSortedGrades(){
      Collections.sort(grades);
      System.out.println(grades);
   }
   
   // Getters and Setters for the ArrayList
   public ArrayList<Double> getGradeList(){ return grades; }
   public void setGradeList(ArrayList<Double> grades){ this.grades = grades; }
   
   // Prints the ArrayList
   public String toString (){
      return "Grades " + grades;
   }
  
}