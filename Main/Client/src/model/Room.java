package model;

import viewModel.RoomTypes;

/**
 * A class that creates room object
 *
 * @author Group 5
 * @version 04/05/2022
 */
public class Room
{
  private String roomId;
  private RoomTypes type;
  private String nrOfBeds;

  /**
   * One-argument contructor
   * A constructor that initializes instance variable using the setRoomId method.
   *
   * @param roomId room number
   */
  public Room(String roomId, RoomTypes type, String nrOfBeds)
  {
    setRoomId(roomId);
    setType(type);
    setNrOfBeds(nrOfBeds);
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
    Room other = new Room(roomId, type, nrOfBeds);
    return other;
  }

  @Override public String toString()
  {
    return "Room number: " + roomId;
  }

  public void setType(RoomTypes type) {
    this.type = type;
  }

  public void setNrOfBeds(String nrOfBeds) {
    this.nrOfBeds = nrOfBeds;
  }

  public RoomTypes getType(){
    return type;
  }

  public String getNrOfBeds(){
    return nrOfBeds;
  }
}
