package model;

import java.util.ArrayList;

public class RoomList
{
  private ArrayList<Room> roomList;

  RoomList()
  {
    this.roomList = new ArrayList<>();
    createDummyData();
  }

  public void createDummyData()
  {
    addRoom(new Room("1-lux-room"));
    addRoom(new Room("2-room"));
    addRoom(new Room("3-super-lux-room"));
    addRoom(new Room("4-super-max-lux-room"));
  }

  public ArrayList<Room> getRoomList()
  {
    return new ArrayList<Room>(roomList);
  }


//  public void removeRoomById(String id)
//  {
//    for (int i = 0; i<roomList.size(); i++)
//    {
//      if (roomList.get(i).getRoomId().equals(id))
//      {
//        roomList.remove(i);
//        return;
//      }
//    }
//  }

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
