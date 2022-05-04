package model;

import java.time.LocalDate;

/**
 * A class that creates a room booking.
 *
 * @author Group 5
 * @version 04/05/2022
 */
public class RoomBooking
{
  private LocalDate startDate;
  private LocalDate endDate;
  private Room room;
  private Guest guest;

  /**
   * A four-argument constructor
   * A constructor meant for initializing instance variable.
   * It makes a copy of a room object and guest object.
   * @param startDate start date
   * @param endDate end date
   * @param room room
   * @param guest guest
   */
  public RoomBooking (LocalDate startDate, LocalDate endDate, Room room, Guest guest)
  {
    this.startDate = startDate;
    this.endDate = endDate;
    this.room = room.copy();
    this.guest = guest.copy();
  }

  /**
   * A method meant for getting an end date.
   * @return endDate
   */
  public LocalDate getEndDate()
  {
    return endDate;
  }

  /**
   * A method meant for getting a start date.
   * @return startDate
   */
  public LocalDate getStartDate()
  {
    return startDate;
  }

  /**
   * A method meant for getting a room.
   * @return room
   */
  public Room getRoom()
  {
    return room;
  }

  /**
   * A method is meant for getting room booking information.
   * @return Organized output of room booking
   */
  @Override public String toString()
  {
    return "RoomBooking{" + "startDate=" + startDate + ", endDate=" + endDate
        + ", room=" + room + ", guest=" + guest + '}';
  }
}
