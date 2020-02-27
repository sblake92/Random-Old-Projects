public class Cat implements Audible {

	private static int id; //class varible only on for the class
	private double weight; // instance variables if no static is there
	private double height;
   private boolean chipped;
	private String name; // null
	private String breed; // null
	
	// add default constructor to initialize fields or instance/class variable
	public Cat() {
		this.weight = 0.0;
		this.height = 0.0;
		this.chipped = false;
		this.name = "Unknown";
		this.breed = "Unknown";
	}

	// add five parameter constructor
	public Cat(double weight, double height, boolean chipped, String name, String breed) {
		this.weight = weight;
		this.height = height;
		this.chipped = chipped;
		this.name = name;
		this.breed = breed;
	}

	//Getters   
   public double getWeight() {	return weight; }
   public double getHeight() {	return height;	}
   public boolean isChipped() { return chipped;	}
   public String getName() { return name; }
	public String getBreed() { return breed;}

   //Setters
	public void setWeight(double weight) { this.weight = weight; }
	public void setHeight(double height) { this.height = height; }
	public void setChipped(boolean chipped) { this.chipped = chipped; }
	public void setName(String name) { this.name = name; }
	public void setBreed(String breed) { this.breed = breed;	}

   //toString
	public String toString() { 
		return "Cat [weight = " + weight + ", height = " + height + ", chipped = " + chipped + ", name = " + name
				+ ", breed = " + breed + "]\n";
	}
	
	// implement Audible interface
	public String makeSound() {
		return "meow";
	}
	
// 	public static void main(String [] args) {
// 		Cat d = new Cat(15,10,true,"Forrest","Siamese");
// 		System.out.println(d);
// 				
// 	}
}
