import java.io.*; 
import java.util.*;

public class TicketClient {
public static final int TOTAL = 5;

   	public static void main(String[] args) {
         ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        
         percentage(tickets); 
         print(tickets);        
            
      }
          
      public static void percentage(ArrayList<Ticket> tickets){
         double vip = Math.ceil(TOTAL * .05);
        
         for(int i = 0; i < TOTAL - vip; i++){
            Ticket temp = new Ticket();
            tickets.add(i, temp);
         }
         for(int j = 0; j < vip; j++){
            VIP tic = new VIP();
            tickets.add(tic);
         }
      }
      
      public static void print(ArrayList<Ticket> tickets){
         for(int i = 0; i <tickets.size(); i++){
            System.out.print(tickets.get(i) + "\n\n");
         }
      }
}

/*  *********************
 == Seat # 1
 == $ 10
 == Owner's Name Here
 == General Admission
 ********************
  ** No Discount **
 ********************
 
 *********************
 == Seat # 2
 == $ 10
 == Owner's Name Here
 == General Admission
 ********************
  ** No Discount **
 ********************
 
 *********************
 == Seat # 3
 == $ 10
 == Owner's Name Here
 == General Admission
 ********************
  ** No Discount **
 ********************
 
 *********************
 == Seat # 4
 == $ 10
 == Owner's Name Here
 == General Admission
 ********************
  ** No Discount **
 ********************
 
 *********************
 == Seat # 5
 == $ 30
 == Owner's Name Here
 == VIP
 ********************
  ** Free Drink **
 ********************
 */