package model;

import javax.print.DocFlavor;
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
    ArrayList<Room> notAvailableRooms = allBookings.getBookedRoomsBy(startDate, endDate);
    ArrayList<Room> allRooms = roomList.getRoomList();

    for (int i = 0 ; i < notAvailableRooms.size(); i++)
    {
      for (int j = 0 ; j < roomList.getRoomListSize(); j++)
      {
        if (notAvailableRooms.get(i).getRoomId().equals(roomList.getRoomByNr(j).getRoomId()))
        {
          allRooms.remove(i);
        }
      }
    }
    return allRooms;
  }

  // double check before making actual booking
  public boolean isBookingAllowed(String roomId, LocalDate startDate, LocalDate endDate)
  {
    ArrayList<Room> availableRooms = availableRooms(startDate,endDate);
//    for (int i = 0 ; i < availableRooms.size(); i++)
//    {
//      System.out.println(availableRooms.get(i).getRoomId());
//    }
    for (int i = 0 ; i<availableRooms.size(); i++)
    {
      if (availableRooms.get(i).getRoomId().equals(roomId))
      {
        System.out.println("True?");
        return true;
      }
    }
    return false;
  }

  @Override public void book(String roomId, LocalDate startDate,
      LocalDate endDate, Guest guest)
  {
    allBookings.addBooking(new RoomBooking(startDate, endDate, roomList.getRoom(roomId), guest));
  }

}
