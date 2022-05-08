package viewModel;

import jdk.jshell.execution.LoaderDelegate;
import model.Room;
import model.RoomBooking;

import java.time.LocalDate;
import java.util.ArrayList;

public class TemporaryInformation
{
  private LocalDate startDate;
  private LocalDate endDate;
  private String roomID;
  private String roomType;
  private int numberOfBeds;

  public TemporaryInformation()
  {
    this.startDate = null;
    this.endDate = null;
    this.roomID = null;
    this.roomType = null;
    this.numberOfBeds = -1;
  }

  public void setEndDate(LocalDate endDate)
  {
    this.endDate = endDate;
  }

  public void setRoomID(String roomID)
  {
    this.roomID = roomID;
  }

  public void setStartDate(LocalDate startDate)
  {
    this.startDate = startDate;
  }

  public String getRoomType()
  {
    return roomType;
  }

  public void setRoomType(String roomType)
  {
    this.roomType = roomType;
  }

  public int getNumberOfBeds()
  {
    return numberOfBeds;
  }

  public void setNumberOfBeds(int numberOfRooms)
  {
    this.numberOfBeds = numberOfRooms;
  }

  public LocalDate getStartDate()
  {
    return startDate;
  }

  public LocalDate getEndDate()
  {
    return endDate;
  }

  public String getRoomID()
  {
    return roomID;
  }

}
