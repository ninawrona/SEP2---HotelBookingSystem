package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class RoomBookingList
{
  private ArrayList<RoomBooking> AllBookings;

  public RoomBookingList()
  {
    this.AllBookings = new ArrayList<>();
  }

  public ArrayList<RoomBooking> getAllBookings()
  {
    return AllBookings;
  }

  public void addBooking(RoomBooking booking)
  {
    AllBookings.add(booking);
  }

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

  public int bookedRoomListSize()
  {
    return AllBookings.size();
  }

  public ArrayList<Room> getBookedRoomsBy(LocalDate startDate, LocalDate endDate)
  {
    ArrayList<Room> rooms = new ArrayList<>();
    for (int i = 0; i < AllBookings.size(); i++)
    {
      if (!(AllBookings.get(i).getStartDate().isAfter(startDate) && AllBookings.get(i).getEndDate().isBefore(endDate)))
      {
        rooms.add(AllBookings.get(i).getRoom());
      }
    }
    return rooms;
  }
}
