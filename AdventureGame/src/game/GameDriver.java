//Scott Blake
//CS 143
//
//This code (in its entirety) plays a game by using different classes 
//and objects to bring together different pieces of the code

package game;

import java.util.*;
import players.*;
import game.*;
import tiles.*;

public class GameDriver {
	private static Scanner console = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Welcome to the Longest Adventure.");
		System.out.println("*********************************");

		
		System.out.print("Please choose a number of tiles: ");
		int tiles = console.nextInt();
		console.nextLine(); // clear enter key from integer input

		System.out.print("Enter your player name: ");
		String name = console.nextLine();

		System.out.println("Please choose a player type (knight, princess, squire):");
		System.out.println("Knight - Tough travelers that can weather any adversity!");
		System.out.println("Princess - Smart and savvy, a princess is never caught off guard!");
		System.out.println("Squire - Squires have a knack for getting there quicker!");
		System.out.print("Enter your player type: ");
		String type = console.nextLine();

		
		// TODO: send in the number of tiles and a new player object here
		// use the type entered to determine which object to construct 
		// Princess, Knight, or Squire ex. 
		// Game game = new Game(tiles, new Princess(name));
		// you will need an if or switch statement
		
		Player player;
		if(type.equalsIgnoreCase("princess")){
			player = new Princess(name);
		}
		else if(type.equalsIgnoreCase("knight")) {
			player = new Knight(name);
		}
		else {
			player = new Squire(name);
		}
	
		Game game = new Game(tiles, player);
		
		game.startGame();

		console.close();
	}
}
