package viewModel;

import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class RoomListViewModel implements PropertyChangeListener
{
    private Model model;
    // TODO do we need this??
    private TemporaryInformation temporaryInfo;
    private ObservableList<SimpleRoomViewModel> allRooms;

    private ObjectProperty<SimpleRoomViewModel> selectedRoomProperty;
    private SimpleStringProperty errorLabel;



  public RoomListViewModel(Model model, TemporaryInformation tempInfo)
  {
   this.model = model;
   // Uncomment this when server/client has been implemented.. Right now it gives errors because it is trying to remove the room twice.
   //model.addListener(this);
   this.temporaryInfo = tempInfo;

   this.allRooms = FXCollections.observableArrayList();
   updateRoomList();

   this.errorLabel = new SimpleStringProperty("");
   this.selectedRoomProperty = new SimpleObjectProperty<>();
  }

  /**
   * Method for updating the list of rooms shown.
   * It clears the current list, and then gets all rooms from the model and adds them.
   */
  public void updateRoomList()
  {
    allRooms.clear();
    for (int i = 0; i < model.getAllRooms().size(); i++ )
    {
      allRooms.add(new SimpleRoomViewModel(model.getAllRooms().get(i)));
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
  public ObservableList<SimpleRoomViewModel> getAllRooms()
  {
    return allRooms;
  }

  public void setSelected(SimpleRoomViewModel roomVm)
  {
    selectedRoomProperty.set(roomVm);
  }

  public ObjectProperty<SimpleRoomViewModel> getSelectedProperty()
  {
    return selectedRoomProperty;
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    Platform.runLater(() -> {
      switch (evt.getPropertyName())
      {
        case "RemoveRoom": removeRoom((String) evt.getNewValue());
        break;
      }
    });
  }
}


