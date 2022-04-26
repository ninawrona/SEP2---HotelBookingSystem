package model;

import java.time.LocalDate;

public class RoomBooking
{
  private LocalDate startDate;
  private LocalDate endDate;
  private Room room;
  private Guest guest;

  public RoomBooking (LocalDate startDate, LocalDate endDate, Room room, Guest guest)
  {
    this.startDate = startDate;
    this.endDate = endDate;
    this.room = room.copy();
    this.guest = guest.copy();
  }

  public LocalDate getEndDate()
  {
    return endDate;
  }

  public LocalDate getStartDate()
  {
    return startDate;
  }

  public Room getRoom()
  {
    return room;
  }

  @Override public String toString()
  {
    return "RoomBooking{" + "startDate=" + startDate + ", endDate=" + endDate
        + ", room=" + room + ", guest=" + guest + '}';
  }
}
