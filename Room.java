/**
Program that creates a Room class for rooms in a hotel.

@author Hiram Raulerson
@version 3.0
 
E-mail Address: hhr3@students.uwf.edu.
 
Last Changed: September 20, 2015.
 
COP5007	Project #: 2
File Name: Room.java
*/

import java.text.DecimalFormat;

public class Room
{
   /**
   Stores the room number
   */
   private int roomNum;
   
   /**
   Stores the bed type (i.e., double, queen)
   */
   private String bedType;
   
   /**
   Stores the cost of the room per day (in dollars)
   */
   private double rate;
   
   /**
   Stores the name of the person that booked the room 
   */
   private String occupantName;
   
   /**
   Stores S or N to denote a smoking or non-smoking room
   */
   private char smoking;
   
   /**
   Stores whether the room is occupied or vacant
   */
   private boolean occupied;
   
   /**
   Stores a DecimalFormat object for formatting room rate
   */
   private DecimalFormat rateFormatter; 
   
   /**
   Default constructor constructs a Hotel object with default values for 
   all instance variables.  The constructor also creates a DecimalFormat
   object for formatting the room rate.  
   */
   public Room()
   {
       setRoomNum(0);
       setBedType("queen");
       setRate(100);
       setOccupant("");
       setSmoking('N');
       setOccupied(false);
       rateFormatter = new DecimalFormat("00.00");
   }
   
   /**
   Constructs a Room object with room number equal to the theRoomNo parameter value,
   bed type equal to the theBedType parameter value, smoking or non-smoking room equal
   the smokingType parameter value, the daily room rate equal to the roomRate 
   parameter value, and the occupant set to an empty string. The constructor 
   also creates a DecimalFormat object for formatting the room rate. 
   @param theRoomNo the room number
   @param theBedType the type of bed in the room
   @param smokingType whether the room is smoking or non-smoking
   @param roomRate the daily rate for the room
   */
   public Room(int theRoomNo, String theBedType, char smokingType, double roomRate)
   {
       setRoomNum(theRoomNo);
       setBedType(theBedType);
       setRate(roomRate);
       setSmoking(smokingType);
       setOccupant("");
       rateFormatter = new DecimalFormat("00.00");
   }
   
   /**
   Returns the room number
   @return the number of the room
   */
   public int getRoomNum()
   {
      return roomNum;
   }
   
   /**
   Returns the type of bed in the room
   @return the bed type of the room
   */
   public String getBedType()
   {
      return bedType;
   }
   
   /**
   Returns the daily rate of the room 
   @return the room rate
   */
   public double getRoomRate()
   {
      return rate;
   }
   
   /**
   Returns the name of the person that booked the room 
   @return the person's name that booked the room
   */
   public String getOccupant()
   {
      return occupantName;
   }
  
   /**
   Returns whether the room is smoking or non-smoking
   @return smoking or non-smoking room
   */
   public char getSmoking()
   {
      return smoking;
   }
   
   /**
   Returns whether the room is booked
   @return whether the room is occupied
   */
   public boolean isOccupied()
   {
      return occupied;
   }
   
   /**
	Sets the room number
	@param theRoomNo the number of the room
   */
   public void setRoomNum(int theRoomNo)
   {
      if (theRoomNo >= 0)
      {
         roomNum = theRoomNo;
      }
      else
      {
         System.out.println("Error: not a valid room number.");
         roomNum = 0;
      }
   }
   
   /**
	Sets the room's bed type
	@param theBedType the type of the room's bed
   */
   public void setBedType(String theBedType)
   {
      if (theBedType == null || theBedType.equals(""))
      {
         System.out.println("Error: not a valid bed type.");
      }
      else if (theBedType.equals(""))
      {
         bedType = "queen";
      }
      else
      {
         bedType = theBedType;
      }
   }
   
   /**
	Sets the name of the person who booked the room
	@param name the name of the person who booked the room
   */
   public void setOccupant(String name)
   {
      if (name == null)
      {
         System.out.println("Error: not a name.");
         occupantName = "No Name";
      }
      else if (name.equals(""))
      {
         occupantName = "Not Occupied";
      }
      else
      {
         occupantName = name;
      }
   }
   
   /**
	Sets whether the room is smoking or non-smoking
	@param smokeOrNot if room allows smoking or not
   */
   public void setSmoking(char smokeOrNot)
   {
      switch(smokeOrNot)
      {
         /*
         user can put variations of 'Y' or 'S' for a smoking room
         or 'N' or 'n' for a non-smoking room
         */
         case 'y':
         case 'Y':
         case 's':
         case 'S': 
            smoking = 'S';
            break;
         case 'n':
         case 'N':
            smoking = 'N';
            break;
         default:
            System.out.println("Error: not a valid smoking type.");
            smoking = 'N';
            break;
      }
   }
   
   /**
	Sets the room's daily rate
	@param theRate daily rate for the room
   */
   public void setRate(double theRate)
   {
      if (theRate >= 0)
      {
         rate = theRate;
      }
      else
      {
         rate = 100;
         System.out.println("Error: not a valid room rate.  Room rate " +
                             "set by default to $100.00");
      }
   }
   
   /**
	Sets the state of the room (i.e., occupied or vacant)
	@param occupy the state of the room
   */
   public void setOccupied(boolean occupy)
   {
      if (occupy)
      {
         occupied = true;
      }
      else
      {
         occupied = false;
      }
   }
   
   /**
	Returns a nicely formatted String composed of all the Room's
   instance variables, except the NumberFormat object
	@return the details of a room
   */
   public String toString()
   {
      return ("Room Number: " + getRoomNum() + "\n" +
              "Occupant Name: " + getOccupant() + "\n" +
              "Smoking Room: " + getSmoking() + "\n" +
              "Bed Type: " + getBedType() + "\n" +  "Rate: $"
              + rateFormatter.format(getRoomRate()) + "\n");
   }
   
}