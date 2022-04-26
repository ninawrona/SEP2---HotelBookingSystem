package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class ModelManager implements Model
{
  private RoomBookingList allBookings;
  private RoomList roomList;

  public ModelManager()
  {
    allBookings = new RoomBookingList();
    roomList = new RoomList();
  }

  @Override public ArrayList<Room> availableRooms(LocalDate startDate, LocalDate endDate)
  {
    return allBookings.getBookedRoomsBy(startDate, endDate);
  }

  @Override public void book(String roomId, LocalDate startDate,
      LocalDate endDate, Guest guest)
  {
    allBookings.addBooking(new RoomBooking(startDate, endDate, roomList.getRoom(roomId), guest));
  }
}
