/**
Program that creates a driver class to test the
Hotel and Room classes.

@author Hiram Raulerson
@version 2.0
 
E-mail Address: hhr3@students.uwf.edu.
 
Last Changed: September 20, 2015.
 
COP5007	Project #: 2
File Name: HotelTest.java
*/

import java.text.DecimalFormat;

public class HotelTest
{
   public static void main(String [] args)
   {
      
      Hotel bestWestern = new Hotel("Best Western", "Okeechobee, FL");
      
      DecimalFormat dailyRateFormat = new DecimalFormat("00.00"); 
      
      System.out.println(bestWestern.getHotelName());
      System.out.println(bestWestern.getLocation());
      
      bestWestern.addRoom(1, "queen", 'n', 200.99);
      bestWestern.addReservation("raulie", 'n', "queen");
      
      System.out.println("\nisEmpty = " + bestWestern.isEmpty() + "\n");
      System.out.println("\nisFull = " + bestWestern.isFull() + "\n");
      
      bestWestern.addRoom(2, "queen", 'n', 2009);
      bestWestern.addRoom(3, "king", 'y', 300);
      bestWestern.addRoom(4, "double", 'n', 225);
      bestWestern.addRoom(5, "king", 'n', 90);
      bestWestern.addRoom(6, "cot", 's', 26);
      bestWestern.addRoom(7, "king", 'n', 300);
      bestWestern.addRoom(8, "queen", 'n', 220.09);
      bestWestern.addRoom(9, "california king", 'S', 300.98);
      bestWestern.addRoom(10, "2 queens", 'n', 200.99);
      bestWestern.addRoom(11, "number 10", 'y', 300);
      bestWestern.addRoom(12, "number 11", 'n', 200.99);
      bestWestern.addRoom(13, "12", 'y', 300);
      
      bestWestern.addReservation("rachel", 'n', "queen");
      
      System.out.println("\nisEmpty = " + bestWestern.isEmpty() + "\n");
      System.out.println("\nisFull = " + bestWestern.isFull() + "\n");
      
      System.out.println(bestWestern);
   
      bestWestern.setName("The Best Best Western");
      bestWestern.setLocation("New Orleans, LA");      
      
      bestWestern.addReservation("hank", 'n', "queen");
      bestWestern.addReservation("Suzanne", 's', "CALIFORNIA KING");
      bestWestern.addReservation("Jake", 'N', "QUEEN");
      bestWestern.addReservation("Linda", 'y', "QUEEN");
      
      System.out.println(bestWestern);
            
      System.out.println("Daily Sales: $" + 
                           dailyRateFormat.format(bestWestern.getDailySales()));
      System.out.println("Occupancy Percentage: " + 
                         dailyRateFormat.format(bestWestern.occupancyPercentage()) + "%");
      
      bestWestern.cancelReservation("Rachel");
      
      //repeat cancelReservation to determine if method works properly
      bestWestern.cancelReservation("Rachel");
      
      System.out.println(bestWestern);
      bestWestern.printReservationList();
      System.out.println("\nDaily Sales: $" + 
                           dailyRateFormat.format(bestWestern.getDailySales()) + "\n");
      System.out.println("\nOccupancy Percentage: " + 
                         dailyRateFormat.format(bestWestern.occupancyPercentage()) + "%" + "\n");
      
      bestWestern.cancelReservation("raulie");
      bestWestern.cancelReservation("HANK");
      bestWestern.cancelReservation("sUzAnnE");
      bestWestern.cancelReservation("Harold");
      
      System.out.println(bestWestern);
      bestWestern.printReservationList();
      System.out.println("\nDaily Sales: $" + 
                           dailyRateFormat.format(bestWestern.getDailySales()));
      System.out.println("\nOccupancy Percentage: " + 
                         dailyRateFormat.format(bestWestern.occupancyPercentage()) + "%");
      
      System.out.println("\nisEmpty = " + bestWestern.isEmpty());
      System.out.println("\nisFull = " + bestWestern.isFull());
   }
}