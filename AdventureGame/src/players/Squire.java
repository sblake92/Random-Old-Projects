//Scott Blake
//CS 143
//
//This code writes the default stats for the Squire player type

package players;

public class Squire extends Player {
	private static int steps = 3;
	private static int maxFatigue = 15;
	
	public Squire() {
		super();
	}
	
	public Squire(String name) {
		super(name, maxFatigue, steps);
	}

	public void stepsInMud() {
		System.out.println("I grew up in the mud, this won't affect me!");
	}

	public void stepsOnGrass() {
		System.out.println("I love the open grassy fields.");
	}

	public void stepsOnRoad() {
		System.out.println("I wonder how long this road will go on");
	}

	public void stepsOnTrap() {
		System.out.println("Ugh! A Trap!");
	}

}
