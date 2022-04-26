package View;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import viewModel.ReservationViewModel;
import java.rmi.RemoteException;

public class ReservationController {
    @FXML private DatePicker startDate;
    @FXML private DatePicker endDate;
    @FXML private Label errorLabel;
    @FXML private ListView<String> availableRoom;
    private ReservationViewModel viewModel;

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

    public void lookForAvailableRooms(ActionEvent actionEvent) {
        viewModel.getAllAvailableRooms();
    }

    public void reservationButton(ActionEvent actionEvent) {
        String selectedRoomFromListView = availableRoom.getSelectionModel().getSelectedItem();
        viewModel.reserveRoom(selectedRoomFromListView);
    }

}
