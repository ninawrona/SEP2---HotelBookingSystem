package model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * A class that implements the Model interface and manages the bookings.
 *
 * @author Group 5
 * @version 04/05/2022
 */

public class ModelManager implements Model
{
  private RoomBookingList allBookings;
  private RoomList roomList;

  /**
   * A constructor that is meant to initialize
   * the instance variables as a new array lists
   * that will store a list of all rooms and a list of booked rooms.
   */
  public ModelManager()
  {
    allBookings = new RoomBookingList();
    roomList = new RoomList();
    createDummyData();
  }

  private void createDummyData()
  {
    roomList.addRoom(new Room("1.01", RoomType.SINGLE, 1));
    roomList.addRoom(new Room("1.02", RoomType.DOUBLE, 1));
    roomList.addRoom(new Room("1.03", RoomType.FAMILY, 3));
    roomList.addRoom(new Room("1.04", RoomType.DOUBLE, 1));
    roomList.addRoom(new Room("1.05", RoomType.SUITE, 3));
  }

  /**
   * A method that returns all available rooms by selected date
   *
   * @param startDate start date
   * @param endDate   end date
   * @return available rooms
   */
  @Override public ArrayList<Room> availableRooms(LocalDate startDate,
      LocalDate endDate)
  {
    ArrayList<Room> notAvailableRooms = allBookings.getBookedRoomsBy(startDate,
        endDate);
    ArrayList<Room> allRooms = roomList.getRoomList();
    ArrayList<Room> finalList = roomList.getRoomList();

    for (int i = 0; i < allRooms.size(); i++)
    {
      for (int j = 0; j < notAvailableRooms.size(); j++)
      {
        if (allRooms.get(i).getRoomId()
            .equals(notAvailableRooms.get(j).getRoomId()))
        {
          finalList.remove(allRooms.get(i));
        }
      }
    }
    return finalList;
  }

  /**
   * A method that checks if the room is available right before bookings after the personal information is entered
   *
   * @param roomId    room number
   * @param startDate start date
   * @param endDate   end date
   * @return true if rooms is allowed to be booked and false is room is not allowed to be booked
   */
  public boolean isBookingAllowed(String roomId, LocalDate startDate,
      LocalDate endDate)
  {
    ArrayList<Room> notAvailableRooms = allBookings.getBookedRoomsBy(startDate,
        endDate);

    for (int i = 0; i < notAvailableRooms.size(); i++)
    {
      if (notAvailableRooms.get(i).getRoomId().equals(roomId))
      {
        return false;
      }
    }
    return true;
  }

  @Override public boolean addRoom(String roomId, String type, int nrBeds)
  {
    //TODO
    return false;
  }

  /**
   * Method removing a room from the list of rooms in the system.
   * To prevent data-corruption, it checks if the room corresponding to the ID passed as an argument has any current or future bookings
   * using the isBookingAllowed method, and if this is not the case - removes it from the list.
   * @param roomId the ID of the room to be removed
   * @return true if room is removed successfully
   * @throws IllegalArgumentException if room to be removed has any current or future bookings.
   */
  @Override public boolean removeRoom(String roomId)
  {
    if (isBookingAllowed(roomId, LocalDate.now(), LocalDate.MAX))
    {
      roomList.removeRoom(roomId);
      return true;
    }

    //TODO make something fancy regarding this -> when we have booking id,
    // return conflicting booking id's.

    else
    {
      throw new IllegalArgumentException("ERROR: Room is part of current or future bookings. Room not deleted.");
    }
  }

  /**
   * Method returning the list of all rooms currently in the system.
   * @return list of all rooms.
   */
  @Override public ArrayList<Room> getAllRooms()
  {
    return roomList.getRoomList();
  }

  @Override public boolean editRoomInfo(String roomId, String type, int nrBeds)
  {
    //TODO
    return false;
  }



  /**
   * A method that is meant for booking a room.
   *
   * @param roomId    room number
   * @param startDate start date
   * @param endDate   end date
   * @param guest     guest
   * @return true if the room is booked and false if the room is not booked
   */
  @Override public boolean book(String roomId, LocalDate startDate,
      LocalDate endDate, Guest guest)
  {
    if (isBookingAllowed(roomId, startDate, endDate))
    {
      allBookings.addBooking(
          new RoomBooking(startDate, endDate, roomList.getRoom(roomId), guest));
      return true;
    }

    else
    {
      throw new IllegalArgumentException(
          "Selected Room is no longer available for selected dates.");
    }
  }


}
