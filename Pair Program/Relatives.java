
import java.util.*;


public class Relatives
{
   //  Map instance variable map
   private Map<String,Set<String>> map;

   // TODO: finish the constructor method which instantiates the map as aTreeMap
	public Relatives()
	{
		
   }

   // precondition: line contains a personname and a relativename separated by a space
   // ex. line = "Almas Brian"
   // postcondtion: the person(Almas) is placed into the map as a key and the relative(Brian) is added 
   // to the relative set for this person
	public void setPersonRelative(String line)
	{
      //TODO: Use the split method to break apart the person from his relative
      //For example: after the split method is called personrelative[0] = "Almas" and personrelative[1] = "Brian"
		// TODO: if the map does NOT contain the person(key)
	
         //TODO: then put this person and a new empty TreeSet for the relatives into the map
			      
      // TODO:  Always Add the relative to the TreeSet for this Person
		
                
      
   }	

   // TODO:  This method returns a String represention of the Set of relatives for the passed in
   // person.  If the person is not in the map, the method returns no known relatives
	public String getRelatives( String person)
	{
     
     
   }

	// The toString() returns a string representation for the entire contents of the map
   // listing 
    public String toString()
	{
		String result="";
        // TODO:  for every person in the map keySet
		         // TODO: add this person to the return string with a "is related to "
			
         // TODO: call getRelatives and add relatives for this person to return string
      
          // TODO: concatenate the relative to the return string separated by a newline
          
		    // return the string representation for the entire contents of the map listing
	}
}