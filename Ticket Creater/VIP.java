public class VIP extends Ticket {
      
   public VIP (){
      super();
   }
    
   public VIP(String n){
      super(n);
   } 
   
   public int getCost() {
      return super.getCost() * 3;
   }
   
   public String getType(){
      return "VIP";
   }
   
   public String discount(){ 
      return "Free Drink";
   }
}