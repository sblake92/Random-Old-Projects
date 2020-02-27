import java.util.ArrayList;

public class Kennel {
	private ArrayList<Cat> cats;
	private String kennelName;
	private String city;
	private String state;

	// default constructor creates a kennel with 
	// 5 cats with unknown names
	public Kennel () {
		cats = new ArrayList<Cat>();
		for(int i = 0; i < 5; i++) {
			cats.add(new Cat());
		}
		kennelName = "";
		city = "";
		state = "";
			
	}
	// four parameter constructor receives a populated list of cats, kennelName, city, state
	public Kennel(ArrayList<Cat> cats, String kennelName, String city, String state) {
		this.cats = cats;
		this.kennelName = kennelName;
		this.city = city;
		this.state = state;
	}
	
	//Getters
	public ArrayList<Cat> getCats() {   return cats;   }
	public String getKennelName() {  return kennelName;  }
   public String getCity() {	return city;	}
   public String getState() {	return state;	}
   
   //Setters
   public void setDogs(ArrayList<Cat> cats) {   this.cats = cats;	}
	public void setKennelName(String kennelName) {	this.kennelName = kennelName;	}
	public void setCity(String city) {	this.city = city;	}
	public void setState(String state) {	this.state = state;	}
	
   //toString
	public String toString() {
		return "Kennel [cats: " + cats + ",\n kennel name: " + kennelName + ", city: " + city + ", state: " + state + "]";
	}
	

}
