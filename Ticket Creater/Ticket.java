public class Ticket {   
   
   private static int nextTicket = 1;
   private int price;
   private int seat;
   private String owner;
   private String discount;
   
   public Ticket () {
      price = 10;
      seat = nextTicket++;
      owner = "Owner's Name Here";    
     
   }
   
   public Ticket(String n) {
      this();
      owner = n;
   }
   
   //getters
   public int getCost(){ return price;}
   public int getSeat(){ return seat; }
   public String getOwner(){ return owner;}
   public String getType(){ return "General Admission";}
   
   //setters
   public void setName(String name){ owner = name; }
   
   
   //Other behavior
   public String discount(){ 
      return "No Discount";
   }
   
   public String toString(){
      return "*********************\n== Seat # " + getSeat() + "\n== $ " + getCost() + "\n== " +
      getOwner() + "\n== " + getType() + "\n********************\n ** " + discount() + " **\n********************";
   }

   


}