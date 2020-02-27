package dogexample;

import java.util.ArrayList;
/**
 * This class will remove all Dogs that already have a rabies vaccine from the kennel
 * When using a traditional for loop while removing items from an ArrayList, you must be careful that you
 * take into account the objects remaining in the list are shifting their "index" numbers
 * @author susan
 *
 */
public class RemoveDogs {

	public static void main(String[] args) {
		ArrayList<Dog> dogs = new ArrayList<Dog>();
    	dogs.add(new Dog(45, 30, true,"Fido","Poodle"));
		dogs.add(new Dog(65, 36, true,"Chuck","Lab"));
		dogs.add(new Dog(12, 18, false,"Leroy","Mutt"));
		dogs.add(new Dog(45, 40, true,"Rover","Mutt"));
		dogs.add(new Dog(90, 38, true,"Charlotte","Golden"));
		

	}

}
