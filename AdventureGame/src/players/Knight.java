//Scott Blake
//CS 143
//
//This code writes the default stats for the Knight player type

package players;

public class Knight extends Player {
	private static int steps = 2;
	private static int maxFatigue = 25;
	
	public Knight() {
		super();
	}
	
	public Knight(String name) {
		super(name, maxFatigue, steps);
	}

	@Override
	public void stepsInMud() {
		System.out.println("Mud, yuck, mud everywhere!");
	}

	@Override
	public void stepsOnGrass() {
		System.out.println("This grass is slowing me down.");

	}

	@Override
	public void stepsOnRoad() {
		System.out.println("This road is more to my liking.");
	}

	@Override
	public void stepsOnTrap() {
		System.out.println("Lucky my armor is on, ouch!");

	}

}
