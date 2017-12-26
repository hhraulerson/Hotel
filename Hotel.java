/**
Program that creates a Hotel class which creates a Hotel
object that stores up to 10 rooms per object. 

@author Hiram Raulerson
@version 4.0
 
E-mail Address: hhr3@students.uwf.edu.
 
Last Changed: September 20, 2015.
 
COP5007	Project #: 2
File Name: Hotel.java
*/

public class Hotel
{
   /**
   What will be returned when a reservation isn't found
   */
   private static final int NOT_FOUND = -1;
   
   /**
   Constant used to set the array size
   */
   private final int ARRAY_SIZE = 10;
   
   /**
   Creates an array of Room objects
   */
   private Room[] theRooms;
   
   /**
   Stores the name of the hotel
   */
   private String name;
   
   /**
   Stores the geographical location of the hotel
   */
   private String location;
   
   /**
   Tracks how many rooms in the hotel are occupied
   */
   private int occupiedCnt;
   
   /**
   Tracks how many rooms the hotel has
   */
   private int numOfRooms;
   
   /**
   Default constructor constructs a Hotel object with default values for 
   all instance variables, except the size of the Room array which is set 
   with the constant ARRAY_SIZE
   */
   public Hotel()
   {
      theRooms = new Room[ARRAY_SIZE];
      setName("");
      setLocation("");
      setOccupiedRooms(0);
      setNumRooms(0);
   }
   
   /**
   Constructs a Hotel object with the hotel name equal to the first parameter value 
   and the hotel's geographical location set to second parameter value.  The other 
   instance variables are set to their default values, while the size of the Room 
   array is set using the constant ARRAY_SIZE.
   @param theName the hotel's name
   @param theLocation the hotel's geographical location
   */
   public Hotel(String theName, String theLocation)
   {
      theRooms = new Room[ARRAY_SIZE];
      setName(theName);
      setLocation(theLocation);
      setOccupiedRooms(0);
      setNumRooms(0);
   }
   
   /**
   Returns whether all hotel rooms are occupied
   @return whether all hotel rooms are occupied
   */
   public boolean isFull()
   {
      if (getOccupiedRooms() < getNumRooms())
      {
         return false;
      }
      else
      {
         return true;
      }
   }
   
   /**
   Returns whether all hotel rooms are vacant
   @return whether all hotel rooms are vacant
   */
   public boolean isEmpty()
   {
      if (getOccupiedRooms() == 0)
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   
   /**
	Adds a room to the hotel by setting the room number equal to
   the roomNo parameter, setting the bed type equal to
   the bedType parameter, setting whether the room allows
   smoking equal to the smokingType parameter, and by setting the
   room's daily rate to the roomRate parameter value
	@param roomNo the room number
   @param bedType the type of bed in the room
   @param smokingType whether the room allows smoking
   @param roomRate the daily rate of the room
   */
   public void addRoom(int roomNo, String bedType, char smokingType, double roomRate)
   {
      if (getNumRooms() < ARRAY_SIZE)
      {
         theRooms[getNumRooms()] = new Room(roomNo, bedType, smokingType, roomRate);
         theRooms[getNumRooms()].setOccupied(false);
      
         setNumRooms(1);
      }
      else
      {
         System.out.println("\nCannot add another room to the hotel as it has no more space.");
      }
   }
   
   
   /**
	Searches for a hotel room that matches the smoking
   and bed type preferences.  If an unoccupied room is found 
   with the correct preferences, the room is booked with the 
   occupant's name and the room is listed as occupied.
	@param theName the occupant's name
   @param smoke whether the room allows smoking
   @param theBedType the type of bed in the room
   */
   public void addReservation(String theName, char smoke, String theBedType)
   {
      char smokeOrNot = Character.toUpperCase(smoke);
      String bed = theBedType.toUpperCase();
      boolean roomFound = false;
      
      for (int i = 0; i < getNumRooms(); ++i)
      {
         if ( smokeOrNot == theRooms[i].getSmoking() && bed.equals( 
               (theRooms[i].getBedType()).toUpperCase()) &&
               !theRooms[i].isOccupied())
         {
            theRooms[i].setOccupant(theName);
            theRooms[i].setOccupied(true);
            roomFound = true;
            setOccupiedRooms(1);
            break;
         }
      }
      
      if (roomFound)
      {
         String smoking = "";
         
         if (smokeOrNot == 'Y' || smokeOrNot == 'S')
         {
            smoking = "smoking";
         }
         else
         {
            smoking = "non-smoking";
         }
         
         System.out.println("\n" + theName + " has booked a " + smoking 
            + " room with a " + theBedType + " bed.\n");
      }
      else
      {
         System.out.println("\nSorry " + theName +", but we could not find a " +
            "vacant room with your preferences.\n");
      }
   }
   
   /**
	Use the find reservation method to search occupied rooms for a room 
   booked using the occupantName parameter value.  Prints out a message
   indicating whether or not the reservation was cancelled.
   @param occupantName the name of the the room's occupant
   */
   public void cancelReservation(String occupantName)
   {
      int reservation = findReservation(occupantName);
      
      if (reservation == NOT_FOUND)
      {
         System.out.println("\nCould not find a reservation under the name " + 
                            "\"" + occupantName + "\".  Reservation was not" +
                            " cancelled.\n");
      }
      else
      {
         theRooms[reservation].setOccupant("Not Occupied");
         theRooms[reservation].setOccupied(false);
         setOccupiedRooms(-1);
         System.out.println(occupantName + "'s reservation was cancelled.");      
      }
   }
   
   /**
	Searches occupied rooms for a room booked using the name 
   parameter value.  Returns the index of the room, if found.
   Otherwise, returns the constant NOT_FOUND.
   @param aName the name of the the room's occupant
	@return the array index of the room, if the name is found, or 
   the constant NOT_FOUND
   */
   private int findReservation(String aName)
   {
      String theName = aName.toUpperCase();
      
      for (int i = 0; i < getNumRooms(); ++i)
      {
         if ( theRooms[i].isOccupied() &&
               theName.equals((theRooms[i].getOccupant()).toUpperCase()))
         {
            return i;
         }
      }
      
      return NOT_FOUND;
   }
   
   /**
   Prints the details of all the rooms that
   are occupied
   */
   public void printReservationList()
   {
      String intro = "\nDetails for All Occupied Rooms:\n\n";
      String reservationList = "";
      
      for (int i = 0; i < getNumRooms(); ++i)
      {
         if (theRooms[i].isOccupied())
         {
            reservationList += theRooms[i].toString() + "\n";
         }
      }
      
      if (reservationList.equals(""))
      {
         System.out.println("\nNo rooms are currently reserved.\n");
      }
      else
      {
         System.out.println(intro + reservationList);
      }
      
   }
   
   /**
   Sums up daily rates of all occupied rooms and
   returns a total daily sales amount
	@return the total daily sales for all occupied rooms
   */
   public double getDailySales()
   {
      double total = 0;
      
      for (int i = 0; i < getNumRooms(); ++i)
      {
         if (theRooms[i].isOccupied())
         {
            total += theRooms[i].getRoomRate();
         }
      }
      
      return total;
   }
   
   /**
   Calculates and returns the occupancy percentage by dividing 
   the occupied rooms by the total number of rooms in the hotel 
   @return the occupancy percentage for the hotel
   */
   public double occupancyPercentage()
   {
      return (100 * ((double)getOccupiedRooms() / (double)getNumRooms()));
   }
   
   /**
	Returns a nicely formatted String composed of the Hotel object's
   attributes as well as all of the Room objects' attributes that
   are in the Hotel
	@return the details of the hotel and its rooms
   */
   public String toString()
   {
      String roomString = "";
      String asterisks = "*********************";
      
      if ( getNumRooms() != 0)
      {
         for (int i = 0; i < getNumRooms(); ++i)
         {
            roomString += theRooms[i].toString() + "\n";
         }
         
         roomString += asterisks;
      }
      else
      {
         roomString = "There are no rooms in this hotel.";
      }
      
      return (asterisks + "\n\nHotel Name: " + getHotelName() + "\n" +
             "Hotel Location: " + getLocation() + "\n" + 
             "Number of Rooms: " + getNumRooms() + "\n" +
             "Number of Occupied Rooms: " + getOccupiedRooms() + 
             "\n\n\n" + "Room Details are:\n\n" + roomString);
   }
   
   /**
	Sets the hotel's name
	@param hotelName the name of the hotel
   */
   public void setName(String hotelName)
   {
      if (hotelName == null || hotelName.equals(""))
      {
         System.out.println("Error: not a valid name.");
         name = "No name";
      }
      else
      {
         name = hotelName;
      }
   }
   
   /**
	Sets the hotel's geographical location
	@param theLocation the location of the hotel
   */
   public void setLocation(String theLocation)
   {
      if (theLocation == null || theLocation.equals(""))
      {
         System.out.println("Error: not a valid location.");
         location = "No location given";
      }
      else
      {
         location = theLocation;
      }
   }
   
   /**
	Increments the number of occupied rooms by one
   if one is the parameter value.  Decrements the 
   number of occupied rooms by one if the parameter value
   is negative one. Resets the number of occupied rooms 
   to zero when the parameter value is zero.
	@param occupiedRooms indicates whether to increment, decrement,
   or reset the number of occupied rooms
   */
   public void setOccupiedRooms(int occupiedRooms)
   {
      if (occupiedRooms == 1)
      {
         ++occupiedCnt;
      }
      else if (occupiedRooms == -1)
      {
         --occupiedCnt;
      }
      else if (occupiedRooms == 0)
      {
         occupiedCnt = 0;
      }
      else
      {
         System.out.println("Incorrect value passed to the method " +
                              "setOccupiedRooms(). Please try again.");
      }
   }
   
   /**
	Increments the number of rooms by one if one is 
   the parameter value. Resets the number of rooms 
   to zero when the parameter value is zero.
	@param numRooms indicates whether to increment
   or reset the number of rooms
   */
   public void setNumRooms(int numRooms)
   {
      if (numRooms == 1)
      {
         ++numOfRooms;
      }
      else if (numRooms == 0)
      {
         numOfRooms = 0;
      }
      else
      {
         System.out.println("Incorrect value passed to the method " +
                              "setNumRooms(). Please try again.");
      }
   }
   
   /**
   Returns the name of the hotel
   @return the name of the hotel 
   */
   public String getHotelName()
   {
      return name;
   }
   
   /**
   Returns the location of the hotel
   @return the location of the hotel 
   */
   public String getLocation()
   {
      return location;
   }
   
   /**
   Returns the number of occupied rooms in the hotel
   @return the number of occupied rooms in the hotel 
   */
   public int getOccupiedRooms()
   {
      return occupiedCnt;
   }
   
   /**
   Returns the number of rooms in the hotel
   @return the number of rooms in the hotel 
   */
   public int getNumRooms()
   {
      return numOfRooms;
   }
}
