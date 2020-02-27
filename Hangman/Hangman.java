// Scott Blake
// CS 141
// HW Core Topics: Arrays, file processing
// 
// This program will play a game of hangman. It will 
// select a phrase from a .txt file, convert it into a 
// string, then ask for guesses on what the phrase might be.

import java.io.*; 
import java.util.*;

public class Hangman {
public static final int LIMIT = 3;

   public static void main (String [] args) throws FileNotFoundException {
      Scanner wordFile = new Scanner(new File("hangman.txt"));
      String [] phrases = input(wordFile);

      String choice = pickPhrase(phrases);
      
      System.out.println("Let's play a game of word guess");
      System.out.println("You can guess wrong up to " + LIMIT + " times");
      playGame(choice);
   }
   // this method pulls all of the phrases from the text
   // file and converts it into a giant array. This method
   // also defines the length of the array
   public static String[] input(Scanner in) {
      int numPhrases = in.nextInt();
      String newLine = in.nextLine();
      String [] phrases = new String [numPhrases];
      for(int i = 0; i < phrases.length; i++) {
            phrases[i] = in.nextLine();            
      }
      return phrases;
   }
   // this method randomly selects one of the phrases from the array
   public static String pickPhrase(String[] phrases){
      Random rand = new Random ();
      int choice = rand.nextInt(phrases.length - 1);

      return phrases[choice];
   }
  // this method plays the game. It calls on future methods
  // and uses them to check if the game is solved, and prints
  // the letter that is input, if it is found in the phrase. It
  // will do this for however many times the letter appears.
   public static void playGame(String choice){
      int guesses = LIMIT;
      int guessCount = 0;
      boolean [] test = new boolean[choice.length()];
      for(int i = 0; i < test.length; i++){
         if(!Character.isLetter(choice.charAt(i))){
            test[i] = true;
         }
      }
      while(!isSolved(test) && guesses != 0){
         printGame(choice, test);
         if(!checkGuess(test, choice)){
            guesses--;
            guessCount++;
            System.out.println("You have " + guesses + " more incorrect guesses");
         }
      }
      // I have intentionally left in the printing of the phrase as I felt it 
      // brought the game to a better close.   
       if(isSolved(test)){
         System.out.println(choice);
         System.out.print("Congratulations! You solved the puzzle with only " + (guessCount) + " incorrect guesses!");
       }
       else{
         System.out.println("You have reached your maximum number of guesses");
         System.out.println("The puzzle was " + choice);
      }
   }
   
   // this method prints the start of the game, if there is anything other than
   // a letter, this will print that as well as underscores for the length of the 
   // game.
   public static void printGame(String choice, boolean[] test){
      for(int i = 0; i < test.length; i++) {
         if(test[i]){
            System.out.print(choice.charAt(i) + " ");
         }
         else{
            System.out.print("_" + " ");
         }
      }
      System.out.println();
   }
   
   // this method tests to see if the entire phrase
   // has been solved
   public static boolean isSolved(boolean [] test){
      for(int i = 0; i < test.length; i++){
         if(!test[i]){
            return false;
         }
      }
      return true;
   }
   
   // this method tests if the input is valid and
   // changes the value of the boolean to true, 
   // allowing it to be printed to the screen
   public static boolean checkGuess(boolean [] test, String choice){
      Scanner console = new Scanner(System.in);
      System.out.print("Guess a letter >  ");
      String input = console.next();
      int counter = 0;
      for(int i = 0; i < test.length; i++){
         if(input.toLowerCase().charAt(0) == choice.toLowerCase().charAt(i)){
            test[i] = true;
            counter++;
         }
      }   
      if(counter > 0){
         System.out.println(input + " was found in puzzle " + counter + " times");

      }
      else{
         System.out.println(input + " was not found in puzzle");
      }
      return counter > 0;
   }
}

/*    Let's play a game of word guess
 You can guess wrong up to 7 times
 _ _ _ _ ,   _ _ _ _ _   _ _   _ _ ,   _ _ _ _ ,   _ _ _ 
 Guess a letter >  l
 l was found in puzzle 2 times
 _ _ l l ,   _ _ _ _ _   _ _   _ _ ,   _ _ _ _ ,   _ _ _ 
 Guess a letter >  o
 o was found in puzzle 1 times
 _ _ l l ,   _ _ _ _ _   _ _   _ _ ,   _ _ _ _ ,   _ o _ 
 Guess a letter >  m
 m was not found in puzzle
 You have 6 more incorrect guesses
 _ _ l l ,   _ _ _ _ _   _ _   _ _ ,   _ _ _ _ ,   _ o _ 
 Guess a letter >  h
 h was found in puzzle 1 times
 _ _ l l ,   _ h _ _ _   _ _   _ _ ,   _ _ _ _ ,   _ o _ 
 Guess a letter >  d
 d was not found in puzzle
 You have 5 more incorrect guesses
 _ _ l l ,   _ h _ _ _   _ _   _ _ ,   _ _ _ _ ,   _ o _ 
 Guess a letter >  a
 a was found in puzzle 2 times
 _ _ l l ,   _ h a _ _   _ _   _ _ ,   _ a _ _ ,   _ o _ 
 Guess a letter >  b
 b was found in puzzle 2 times
 _ _ l l ,   _ h a _ _   _ _   _ _ ,   b a b _ ,   _ o _ 
 Guess a letter >  e
 e was found in puzzle 2 times
 _ e l l ,   _ h a _ e   _ _   _ _ ,   b a b _ ,   _ o _ 
 Guess a letter >  w
 w was found in puzzle 2 times
 W e l l ,   _ h a _ e   _ _   _ _ ,   b a b _ ,   _ o w 
 Guess a letter >  v
 v was not found in puzzle
 You have 4 more incorrect guesses
 W e l l ,   _ h a _ e   _ _   _ _ ,   b a b _ ,   _ o w 
 Guess a letter >  y
 y was found in puzzle 1 times
 W e l l ,   _ h a _ e   _ _   _ _ ,   b a b y ,   _ o w 
 Guess a letter >  n
 n was found in puzzle 1 times
 W e l l ,   _ h a _ e   _ _   _ _ ,   b a b y ,   n o w 
 Guess a letter >  c
 c was not found in puzzle
 You have 3 more incorrect guesses
 W e l l ,   _ h a _ e   _ _   _ _ ,   b a b y ,   n o w 
 Guess a letter >  t
 t was found in puzzle 1 times
 W e l l ,   _ h a _ e   _ t   _ _ ,   b a b y ,   n o w 
 Guess a letter >  i
 i was found in puzzle 1 times
 W e l l ,   _ h a _ e   i t   _ _ ,   b a b y ,   n o w 
 Guess a letter >  s
 s was found in puzzle 1 times
 W e l l ,   s h a _ e   i t   _ _ ,   b a b y ,   n o w 
 Guess a letter >  o
 o was found in puzzle 1 times
 W e l l ,   s h a _ e   i t   _ _ ,   b a b y ,   n o w 
 Guess a letter >  o
 o was found in puzzle 1 times
 W e l l ,   s h a _ e   i t   _ _ ,   b a b y ,   n o w 
 Guess a letter >  v
 v was not found in puzzle
 You have 2 more incorrect guesses
 W e l l ,   s h a _ e   i t   _ _ ,   b a b y ,   n o w 
 Guess a letter >  p
 p was found in puzzle 1 times
 W e l l ,   s h a _ e   i t   _ p ,   b a b y ,   n o w 
 Guess a letter >  u
 u was found in puzzle 1 times
 W e l l ,   s h a _ e   i t   u p ,   b a b y ,   n o w 
 Guess a letter >  k
 k was found in puzzle 1 times
 Well, shake it up, baby, now
 Congratulations! You solved the puzzle with only 5 incorrect guesses!
  ----jGRASP: operation complete.
  
  
    ----jGRASP exec: java Hangman
 Let's play a game of word guess
 You can guess wrong up to 3 times
 _ _ _ _ ,   _ _ _ _   _ _   _ _   
 Guess a letter >  g
 g was not found in puzzle
 You have 2 more incorrect guesses
 _ _ _ _ ,   _ _ _ _   _ _   _ _   
 Guess a letter >  g
 g was not found in puzzle
 You have 1 more incorrect guesses
 _ _ _ _ ,   _ _ _ _   _ _   _ _   
 Guess a letter >  g
 g was not found in puzzle
 You have 0 more incorrect guesses
 You have reached your maximum number of guesses
 The puzzle was Love, love me do 
 */