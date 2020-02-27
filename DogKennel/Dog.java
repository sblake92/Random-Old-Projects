package dogexample;
/**
 * This class will be the template for Dogs 
 * @author susan
 *
 */
public class Dog implements Audible {

	private static int id; //class varible only on for the class
	private double weight; // instance variables if no static is there
	private double height;
    private boolean rabiesVaccine;
	private String name; // null
	private String breed; // null
	
	// add default constructor to initialize fields or instance/class variable
	public Dog() {
		this.weight = 0.0;
		this.height = 0.0;
		this.rabiesVaccine = false;
		this.name = "Unknown";
		this.breed = "Unknown";
	}

	// add five parameter constructor
	public Dog(double weight, double height, boolean rabiesVaccine, String name, String breed) {
		this.weight = weight;
		this.height = height;
		this.rabiesVaccine = rabiesVaccine;
		this.name = name;
		this.breed = breed;
	}

	// create Setters/Getters/toString
	public void setWeight(double weight) { this.weight = weight; }

	public double getHeight() {	return height;	}

	public void setHeight(double height) { this.height = height; }

	public boolean isRabiesVaccine() { return rabiesVaccine;	}

	public void setRabiesVaccine(boolean rabiesVaccine) { this.rabiesVaccine = rabiesVaccine; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getBreed() { return breed;}

	public void setBreed(String breed) { this.breed = breed;	}

	public double getWeight() {	return weight; }

	@Override
	//Override Object's toString
	public String toString() {
		return "Dog [weight=" + weight + ", height=" + height + ", rabiesVaccine=" + rabiesVaccine + ", name=" + name
				+ ", breed=" + breed + "]\n";
	}
	
	// implement Audible interface
	public String makeSound() {
		return "woof";
	}
	
//	public static void main(String [] args) {
//		Dog d = new Dog(45,60,true,"Forrest","Lab");
//		System.out.println(d);
//				
//	}
	
	
}
