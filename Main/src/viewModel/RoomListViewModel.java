package viewModel;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Model;
import model.ModelManager;

public class RoomListViewModel
{
    private Model model;
    // TODO do we need this??
    private TemporaryInformation temporaryInfo;
    private ObservableList<String> allRoomsByID;
    private SimpleStringProperty errorLabel;

  public RoomListViewModel(Model model, TemporaryInformation tempInfo)
  {
   this.model = model;
   this.temporaryInfo = tempInfo;
   this.allRoomsByID = FXCollections.observableArrayList();
   this.errorLabel = new SimpleStringProperty("");
  }

  /**
   * Method for updating the list of rooms shown.
   * It clears the current list, and then gets all rooms from the model and adds them.
   */
  public void updateRoomList()
  {
    allRoomsByID.clear();
    for (int i = 0; i < model.getAllRooms().size(); i++ )
    {
      allRoomsByID.add(model.getAllRooms().get(i).getRoomId());
    }
  }

  /**
   * Method used for removing a room, by calling the corresponding method from the model.
   * After method has completed, the list of rooms is updated to reflect the changes.
   *
   * If an exception is caught during this process, the error-label will be updated accordingly.
   *
   * @param roomId the id of the room to be deleted.
   *
   */
  public void removeRoom(String roomId)
  {
    try
    {
      model.removeRoom(roomId);
      errorLabel.setValue("Room: " + roomId + " deleted successfully");
      updateRoomList();
    }
    catch (Exception e)
    {
      errorLabel.setValue(e.getMessage());
    }

  }

  /**
   * Method for getting the errorlabel.
   * @return errorlabel
   */
  public SimpleStringProperty getErrorLabel()
  {
    return errorLabel;
  }

  /**
   * Method for getting the ObservableList containing all Rooms listed by ID's
   * @return allRoomsByID.
   */
  public ObservableList<String> getAllRoomsByID()
  {
    return allRoomsByID;
  }
}
