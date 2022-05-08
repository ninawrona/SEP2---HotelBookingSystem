package View;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import viewModel.RoomListViewModel;
import viewModel.SimpleRoomViewModel;
import viewModel.ViewModelFactory;

import java.rmi.RemoteException;
import java.util.Optional;

public class RoomListViewController extends ViewController
{

  @FXML private TableView<SimpleRoomViewModel> roomTable;
  @FXML private TableColumn<SimpleRoomViewModel, String> numberColumn;
  @FXML private TableColumn<SimpleRoomViewModel, String> typeColumn;
  @FXML private TableColumn<SimpleRoomViewModel, Integer> numberOfBedsColumn;
  @FXML private Label errorLabel;
  private Region root;
  private ViewHandler viewHandler;
  private RoomListViewModel viewModel;




  @Override public void init()
  {
    // Bindings
      numberColumn.setCellValueFactory(cellData -> cellData.getValue()
          .roomNumberProperty());
      typeColumn.setCellValueFactory(cellData -> cellData.getValue()
          .roomTypeProperty());
      numberOfBedsColumn.setCellValueFactory(cellData ->  cellData.getValue().numberOfBedsProperty().asObject());
      errorLabel.textProperty().bindBidirectional(viewModel.getErrorLabel());

      roomTable.setItems(viewModel.getAllRooms());

      roomTable.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) -> viewModel.setSelected(newValue));
  }


  /**
   * A void method initializing instance variables.
   *
   * @param viewHandler      A ViewHandler object which will be used to set the instance variable.
   * @param viewModelFactory A ViewModelFactory object which will be used to set the instance variable.
   * @param root             A Region object which will be used to set the instance variable.
   */
  public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory,
      Region root) throws RemoteException
  {
    this.root = root;
    this.viewHandler = viewHandler;
    this.viewModelFactory = viewModelFactory;
    this.viewModel = viewModelFactory.getRoomListViewModel();
    init();
  }

  public Region getRoot()
  {
    return root;
  }

  @Override public void reset()
  {
    /*
    viewModel.clear();


     */

  }

    public void addButton()
    {
    }

    public void editButton()
    {
    }

  /**
   * Method called when clicking the delete button.
   * If a room is not selected, the error-label will be set with instructions for selecting a room,
   * if a room is selected, a pop-up will show, and if confirm is pressed the removeRoom-method from RoomListViewModel will be called.
   * After successfully removing a room, a confirmation message will show.
   */
  public void removeButton()
    {
      if (roomTable.getSelectionModel().getSelectedItem() == null)
      {
        errorLabel.setTextFill(Color.RED);
        errorLabel.setText("Please select a room to remove before clicking.");
      }

      else
      {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Confirm deletion of room: " + roomTable.getSelectionModel().getSelectedItem().roomNumberProperty().get());

        ButtonType confirm = new ButtonType("Confirm");
        ButtonType cancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(confirm, cancel);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == confirm)
        {
          errorLabel.setTextFill(Color.GREEN);
          viewModel.removeRoom(roomTable.getSelectionModel().getSelectedItem().roomNumberProperty().get());
          viewModel.updateRoomList();
        }
        else
        {
          alert.close();
        }
      }

    }
}
