package model;

import java.util.ArrayList;

public class RoomList
{
  private ArrayList<Room> roomList;

  RoomList()
  {
    this.roomList = new ArrayList<>();
  }

  public ArrayList<Room> getRoomList()
  {
    return roomList;
  }

  public void addRoom (Room room)
  {
    roomList.add(room);
  }

  public Room getRoom(String roomID)
  {
    for (int i = 0; i < roomList.size(); i++)
    {
      if (roomList.get(i).getRoomId().equals(roomID))
      {
        return roomList.get(i);
      }
    }
    return null;
  }

  public Room getRoomByNr(int index)
  {
    return roomList.get(index);
  }

  public int getRoomListSize()
  {
    return roomList.size();
  }
}
