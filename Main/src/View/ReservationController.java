package View;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import viewModel.ReservationViewModel;
import java.rmi.RemoteException;

public class ReservationController extends ViewController{
    @FXML private DatePicker startDate;
    @FXML private DatePicker endDate;
    @FXML private Label errorLabel;
    @FXML private ListView<String> availableRoom;
    private ReservationViewModel viewModel;
    private Region root;
    private ViewHandler viewHandler;

    @Override
    public void init() {

    }

    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory, Region root)
            throws RemoteException
    {
        this.viewHandler = viewHandler;
        this.viewModelFactory = viewModelFactory;
        this.viewModel = viewModelFactory.getReservationViewModel();
        this.root = root;
        init();

        // Binding
        availableRoom.setItems(viewModel.getRooms());
        startDate.valueProperty().bindBidirectional(viewModel.getStartDatePicker());
        endDate.valueProperty().bindBidirectional(viewModel.getEndDatePicker());
        errorLabel.textProperty().bind(viewModel.getErrorLabel());
    }

    @Override
    public void reset() {
        viewModel.clear();
    }

    public void lookForAvailableRooms(ActionEvent actionEvent) {
        viewModel.getAllAvailableRooms();
    }

    public void reservationButton(ActionEvent actionEvent) {
        String selectedRoomFromListView = availableRoom.getSelectionModel().getSelectedItem();
        viewModel.reserveRoom(selectedRoomFromListView);
    }

}
