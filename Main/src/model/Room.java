package model;

/**
 * A class that creates room object
 *
 * @author Group 5
 * @version 04/05/2022
 */
public class Room
{
  private String roomId;

  /**
   * One-argument contructor
   * A constructor that initializes instance variable.
   * @param roomId room number
   */
  Room(String roomId)
  {
    this.roomId = roomId;
  }

  /**
   * A method meant for calling room ID (room number)
   * @return roomId
   */
  public String getRoomId()
  {
    return roomId;
  }

  /**
   * A method meant for making a copy of a room object
   * @return a copy of room object
   */
  public Room copy()
  {
    Room other = new Room(roomId);
    return other;
  }
}
