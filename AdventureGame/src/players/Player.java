//Scott Blake
//CS 143
//
//This code writes the Player class that lends itself to the different types of players

package players;

public abstract class Player
{
	/*
	 * Player objects will need to manage:
	 * name: the players name
	 * fatigue: the players current and maximum fatigue (a player loses when current == maximum)
	 * steps: the maximum number of steps a player can take (based on sub class)
	 */
	private String name;
	private int maxFatigue;
	private int currentFatigue;
	private int steps;
	
	public Player() {
		name = "";
		maxFatigue = 0;
		currentFatigue = 0;
		steps = 0;
	}
	
	public Player(String name, int maxFatigue, int steps) {
		this.name = name;
		this.maxFatigue = maxFatigue;
		this.steps = steps;
	}
	
	public String getName() { return name;}
	public int getMax() { return maxFatigue;}
	public int getCurrent() { return currentFatigue;}
	public int getSteps () { return steps;}
	public void setCurrent(int currentFatigue) { this.currentFatigue = currentFatigue;}
	
	public abstract void stepsInMud();
	public abstract void stepsOnGrass();
	public abstract void stepsOnRoad();
	public abstract void stepsOnTrap();
}
