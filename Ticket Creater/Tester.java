import java.util.*;

public class Tester {
   
   public static void main(String[] args) {
      Ticket one = new Ticket("Scott");
      VIP two = new VIP("Scooby Doo");
      
      
      System.out.println("Default ticket = \n" + one);
      System.out.println();
      System.out.println(one.getCost());
      System.out.println(one.getSeat());
      System.out.println(one.getOwner());
      System.out.println(one.getType());
      
      System.out.println();     
      System.out.println("Default VIP: \n" + two);
      System.out.println();
      System.out.println(two.getSeat());
      System.out.println(two.getOwner());
      System.out.println(two.getType());
      System.out.println(two.getCost());     
        
      

     
   }

}