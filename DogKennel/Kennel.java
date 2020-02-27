package dogexample;

import java.util.ArrayList;

public class Kennel {
	private ArrayList<Dog> dogs;
	//private ArrayList<Cat> cats;
	private String kennelName;
	private String city;
	private String state;

	// default constructor creates a kennel with 
	// 5 dogs with unknown names
	public Kennel () {
		dogs = new ArrayList<Dog>();
		for(int i = 0; i < 5; i++) {
			dogs.add(new Dog());
		}
		kennelName = "";
		city = "";
		state = "";
			
	}
	// four parameter constructor receives a populated list of Dogs, kennelName, city, state
	public Kennel(ArrayList<Dog> dogs, String kennelName, String city, String state) {
		this.dogs = dogs;
		this.kennelName = kennelName;
		this.city = city;
		this.state = state;
	}
	
	// add getters, setters, toString
	public ArrayList<Dog> getDogs() {
		return dogs;
	}
	public void setDogs(ArrayList<Dog> dogs) {
		this.dogs = dogs;
	}
	public String getKennelName() {
		return kennelName;
	}
	public void setKennelName(String kennelName) {
		this.kennelName = kennelName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Kennel [dogs=" + dogs + 
				",\n kennelName=" + kennelName + ", city=" + city + ", state=" + state + "]";
	}
	

}
