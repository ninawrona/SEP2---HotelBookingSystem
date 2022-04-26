package model;

public class Room
{
  private String roomId;

  Room(String roomId)
  {
    this.roomId = roomId;
  }

  public String getRoomId()
  {
    return roomId;
  }

  public Room copy()
  {
    Room other = new Room(roomId);
    return other;
  }
}
