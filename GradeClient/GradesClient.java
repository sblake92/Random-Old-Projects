import java.util.*;
/**
 * This class displays a menu of options to allow a user to perform operations on
 * a list of grades that is maintained by the Grades class.
 * @author Susan Uland
 *
 */
public class GradesClient {
	
	private final static String READ = "1", ADD = "2", REMOVE = "3", DROP = "4", DISPLAY = "5", SORT = "6",
			AVERAGE = "7", EXIT = "8";
	private static Scanner keyboard = new Scanner(System.in);
	private Grades grades = new Grades();

/**
 * This method displays a list of menu options for the user to chose from and then performs
 * an action based on the user's choice. Currently the user can choose to read in grades from
 * a file, add a grade he/she enters to the list, remove all grades that the user chooses from the list,
 * drop the lowest grade found first in the list, display all grades in the list to the console window, 
 * sort the grades, and calculate the average grade 
 * @param args - not used
 */
	public static void main(String[] args) {

		String choice = "";
		GradesClient client = new GradesClient();

		// continually display menu options unless user exits
		while (!choice.equals(EXIT)) {

			displayMenu();

			System.out.print("Enter your numerical choice: ");
			choice = keyboard.next();

			if (choice.equals(READ))
				client.readGrades();
			else if (choice.equals(ADD))
				client.addGrade();
			else if (choice.equals(REMOVE))
				client.removeAll();
			else if (choice.equals(DROP))
				client.dropLowest();
			else if (choice.equals(DISPLAY))
				client.displayGrades();
			else if (choice.equals(SORT))
				client.displaySorted();
			else if (choice.equals(AVERAGE))
				client.calcAverage();
         else if (choice.equals(EXIT))
            System.out.println("GoodBye");
			else 
				System.out.println("That choice is not valid "+ choice);
		}

		keyboard.close();

	}

	private static void displayMenu() {
		System.out.println();
		System.out.println("*************************************");
		System.out.println("1. Read grades from file");
		System.out.println("2. Add grade");
		System.out.println("3. Remove all grades");
		System.out.println("4. Drop lowest grade                         ");
		System.out.println("5. Display grades ");
		System.out.println("6. Sort grades");
		System.out.println("7. Calculate average");
		System.out.println("8. Exit");

		System.out.println("*************************************");
		System.out.println();

	}

	private void readGrades() {
		System.out.print("Enter a filename to read the grades from:");
		String fileName = keyboard.next();

		System.out.println(" Reading in grades from " + fileName);
		grades.readGrades(fileName);

	}

	private void calcAverage() {
		System.out.printf("Average is %.2f" , grades.calcAverage());
	}
	
	private void addGrade() {
		System.out.print("Enter a grade to add:");
		String number = keyboard.next();
		try {
        Double grade = Double.parseDouble(number);
		System.out.println("Adding grade " + grade);
		grades.addGrade(grade);
		} catch (NumberFormatException e) {
			System.out.println("You did not enter a valid grade: "+e.getMessage());
		}
		
	}
	
	private void removeAll() {
		System.out.print("Enter a grade to remove:");
		while(!keyboard.hasNextDouble()) {
			keyboard.next();
			System.out.println("You did not enter a valid grade: try again.");
			System.out.print("Enter a grade to remove:");
		}
		String number = keyboard.next();
        Double grade = Double.parseDouble(number);

        boolean removed = grades.removeAllGrades(grade);
        if(removed)
        	System.out.println("Removed ALL grades = "+grade);
        else
        	System.out.println("No grade,"+grade+", found to remove");
	
	}

	private void dropLowest() {
		System.out.println("Lowest grade dropped: " + grades.dropLowest());
	}

	private void displayGrades() {
		System.out.println(grades);
	}

	private void displaySorted() {
		grades.printSortedGrades();
	}

}
