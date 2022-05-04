package model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * A class that is used to store room bookings as well as manipulating the list.
 *
 * @author Group 5
 * @version 04/05/2022
 */
public class RoomBookingList
{
  private ArrayList<RoomBooking> AllBookings;

  /**
   * A constructor meant for initializing instance variable as a new array list
   * that stores all bookings.
   */
  public RoomBookingList()
  {
    this.AllBookings = new ArrayList<>();
  }

  /**
   * A method that returns all bookings.
   * @return AllBookings
   */
  public ArrayList<RoomBooking> getAllBookings()
  {
    return AllBookings;
  }

  /**
   * A method meant for added a new room booking to the list
   * and printing out that it was added.
   * @param booking the booking that is being added
   */
  public void addBooking(RoomBooking booking)
  {
    System.out.println("new booking was added");
    AllBookings.add(booking);
  }

  /**
   * A method that is used for calling a specific booking by index.
   * @param index specified booking number
   * @return specified booking
   */
  public RoomBooking getBooking (int index)
  {
    for (int i = 0; i < AllBookings.size(); i++)
    {
      if (AllBookings.get(i).equals(index))
      {
        return AllBookings.get(i);
      }
    }
    return null;
  }

  /**
   * A method that returns how many rooms are booked.
   * @return size of AllBooking array list.
   */
  public int bookedRoomListSize()
  {
    return AllBookings.size();
  }

  /**
   * A method that is meant for getting a list of rooms in the span of given dates.
   * @param startDate start date
   * @param endDate end date
   * @return rooms
   */
  public ArrayList<Room> getBookedRoomsBy(LocalDate startDate, LocalDate endDate)
  {
    ArrayList<Room> rooms = new ArrayList<>();
    for (int i = 0; i < AllBookings.size(); i++)
    {
      if (AllBookings.get(i).getStartDate().isBefore(endDate) && AllBookings.get(i).getStartDate().isAfter(startDate)
      || AllBookings.get(i).getEndDate().isBefore(endDate) && AllBookings.get(i).getEndDate().isAfter(startDate)
      || (startDate.isBefore(AllBookings.get(i).getEndDate()) && startDate.isAfter(AllBookings.get(i).getStartDate())
        || endDate.isBefore(AllBookings.get(i).getEndDate()) && endDate.isAfter(AllBookings.get(i).getStartDate())) ||
      startDate.equals(AllBookings.get(i).getStartDate()) || endDate.equals(AllBookings.get(i).getEndDate()))
      {
        rooms.add(AllBookings.get(i).getRoom());
      }
    }
    return rooms;
  }
}
