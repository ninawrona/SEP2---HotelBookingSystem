package Model;

import java.util.ArrayList;

public class RoomList
{
  private Room room;
  private ArrayList<Room> roomList;

  RoomList()
  {
    this.roomList = new ArrayList<>();
  }

  public ArrayList<Room> getRoomList()
  {
    return roomList;
  }


}
