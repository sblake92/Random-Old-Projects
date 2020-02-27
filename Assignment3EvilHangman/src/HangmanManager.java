//Scott Blake
//CS 143
//
//This program will play a game of Hangman that chooses the word selection at last minute
//from a shrinking set

import java.util.*;

public class HangmanManager {
	// instance variables
	private String pattern;//"----" or "- - - -" "- e - e"
	private Set<Character> letters; // letters player guesses
	private Set<String> words; // current dictionary using gets smaller
	private int guessesLeft; // passed max amount,
	
	// default constructor
	public HangmanManager(List<String> dictionary, int length, int max) {
		words = new TreeSet<String>();
		for(String s: dictionary) {
			if(s.length() == length) {
				words.add(s);
			}
		}
		letters = new TreeSet<Character>();
		guessesLeft = max;
		pattern = "";
		for(int i = 0; i < length; i++) {
			pattern += "-";
		}
	}
	
	// equivelent of getters
	public String pattern() { return pattern; }
	public Set<Character> guesses() { return letters; }
	public Set<String> words() { return words; }
	public int guessesLeft() { return guessesLeft; }
	
	// this method calls two other methods and returns the number of occurrences the guessed letter occurs in the chosen pattern
	public int record(char guess) {
		badInput(guess);
		int count = 0;
		getMap(guess);
		for(int i = 0; i < pattern.length(); i++) {
			if(guess == pattern.charAt(i)) {
				count++;
			}
		}
		if(count < 1) {
			guessesLeft--;
		}
		letters.add(guess);
		return count;
	}
	
	// this method tests for bad input
	private void badInput(char guess) {
		if(guessesLeft < 1) {
			throw new IllegalStateException("No More Guesses");
		}
		if(words.isEmpty()&& letters.contains(guess)) {
			throw new IllegalArgumentException();
		}
	
	}
	
	// this method sets, and changes, the map according to the guess that is input
		private void getMap(char guess) {
		Map<String, Set<String>> map = new TreeMap<String, Set<String>>();
		for(String s: words) {
			String temp = "";
			for(int i = 0; i < s.length(); i++) {
				if(guess == s.charAt(i)) {
					temp += guess;
				}
				else {
					temp += pattern.charAt(i);
				}
			}
			if(map.containsKey(temp)) {
				map.get(temp).add(s);
			}
			else {
				Set<String> set = new TreeSet<String>();
				set.add(s);
				map.put(temp, set);
			}
		}
		int max = 0;
		for(String key: map.keySet()) {
			//int max = 0;
			if(map.get(key).size() > max) {
				max = map.get(key).size();
				pattern = key;
				}
		}
		words = map.get(pattern);
	}
	
}
