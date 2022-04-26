package viewModel;

import jdk.jshell.execution.LoaderDelegate;
import model.Room;

import java.time.LocalDate;
import java.util.ArrayList;

public class TemporaryInformation
{
  private LocalDate startDate;
  private LocalDate endDate;
  private String roomID;

  public TemporaryInformation()
  {
    this.startDate = null;
    this.endDate = null;
    this.roomID = null;
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
