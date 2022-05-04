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
   * A constructor that initializes instance variable using the setRoomId method.
   *
   * @param roomId room number
   */
  public Room(String roomId)
  {
    setRoomId(roomId);
  }

  /**
   * Method setting the roomId variable to the string given as argument.
   * @throws IllegalArgumentException if argument is null or an empty String.
   * @param roomId
   */
  public void setRoomId(String roomId)
  {
    if (roomId == null || roomId.isBlank())
    {
      throw new IllegalArgumentException(
          "Room ID should not be empty. Please add a valid Room ID.");
    }

    this.roomId = roomId;
  }

  /**
   * A method meant for calling room ID (room number)
   *
   * @return roomId
   */
  public String getRoomId()
  {
    return roomId;
  }

  /**
   * A method meant for making a copy of a room object
   *
   * @return a copy of room object
   */
  public Room copy()
  {
    Room other = new Room(roomId);
    return other;
  }

  @Override public String toString()
  {
    return "Room number: " + roomId;
  }
}
