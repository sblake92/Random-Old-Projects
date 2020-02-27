//Scott Blake
//CS 143
//
//This code (in its entirety) plays a game by using different classes 
//and objects to bring together different pieces of the code

package game;

import java.util.*;
import players.*;
import tiles.*;

public class Game {
	private static Scanner kb = new Scanner(System.in);
	
	// stores tile objects
	private BasicTile[] tiles;
	

	/*
	 * stores the index of player (which tile the player is located within inside
	 * the tiles array
	 */
	private int position = -1;

	// the player object
	private Player player;

	public Game(int numTiles, Player player) {
		this.player = player;
		tiles = new BasicTile[numTiles];
	}

	// public methods

	public void startGame() {
		
		buildTiles(tiles);
		
		/*
		 * The main game loop should be declared here. Each turn the player should move
		 * a random distance forward from 1 tmaxSteps.
		 * 
		 * NOTE: maxSteps should be stored in the Player class and should be 2 for
		 * Knights and 3 for squires or princesses.
		 */

		boolean gameOver = false;
		while (!gameOver) {
			System.out.println("Do you want to quit playing?(true/false) ");
			System.out.println(this.toString());
			gameOver = kb.nextBoolean();
			Random step = new Random();
			int distance = step.nextInt(this.player.getSteps() + 1) + 1;
			if(movePlayer(distance)) {
				System.out.println("Player moves " + distance + " steps to a " + tiles[position].getType() + " tile");
				System.out.println(this.toString());
				System.out.println();
				tiles[position].visitTile(this);
			}
			else {
				System.out.println("Movement is outside tile length");
			}
			System.out.println("Current fatigue level: " + this.player.getCurrent() + "/" + this.player.getMax());
			if(this.player.getCurrent() == this.player.getMax()) {
				System.out.println("You are too fatigued to continue your journey");
				gameOver = true;
			}
			if(this.position >= tiles.length) {
				System.out.println("You've made it to the end! You Win!");
				gameOver = true;
			}
			
		}

		System.out.println("Thank you for playing");

	}

	public Player getPlayer() {
		return player;
	}

	public boolean movePlayer(int distance) {
		/*
		 * This method moves the player the given distance. A positive value will move
		 * the player to the later indices in the tiles[] array, while a negative value
		 * will move the player back to lower indices.
		 * 
		 * Return false if the distance passed falls outside the range 0 -->
		 * tiles.length - 1
		 */
		this.position += distance;
		return this.position >= 0 && this.position < tiles.length;
			
	}


	// private methods
	private void buildTiles(BasicTile [] tiles) {
		Random rand = new Random();
		for(int i = 0; i < tiles.length; i++) {
			int tile = rand.nextInt(10) + 1;
			if(tile <= 4) {
				BasicTile grass = new Grass();
				tiles[i] = grass;
			}
			else if(tile <= 7) {
				BasicTile road = new Road();
				tiles[i] = road;
			}
			else if(tile <= 9) {
				BasicTile mud = new Mud();
				tiles[i] = mud;
			}
			else if(tile <= 10) {
				BasicTile trap = new Trap();
				tiles[i] = trap;
			}
		}
	}

	// prints out the tiles array along with the current player position
	@Override
	public String toString() {
		String result = "[";

		for (int i = 0; i < tiles.length; i++) {
			if (i != 0) {
				result += ", ";
			}

			// player is in this tile
			if (position == i) {
				result += tiles[i].toString() + " - (player)";
			} else {
				result += tiles[i].toString();
			}
		}
		result += "]";

		if (position >= tiles.length) {
			result += " (player)";
		}

		return result;
	}
}
