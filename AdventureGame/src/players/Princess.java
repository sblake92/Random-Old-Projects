//Scott Blake
//CS 143
//
//This code writes the default stats for the Princess player type

package players;

public class Princess extends Player {
	private static int steps = 3;
	private static int maxFatigue = 12;
	
	public Princess() {
		super();
	}
	
	public Princess(String name) {
		super(name, maxFatigue, steps);
	}

	public void stepsInMud() {
		System.out.println("This mud is going to stain my dress!");
	}

	public void stepsOnGrass() {
		System.out.println("This grass feels great between my toes.");
	}

	public void stepsOnRoad() {
		System.out.println("This road is dusty");
	}

	public void stepsOnTrap() {
		System.out.println("This trap won't affect me!");
	}
}


