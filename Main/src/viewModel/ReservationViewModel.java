package viewModel;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.DatePicker;

import java.rmi.RemoteException;
import java.time.LocalDate;

public class ReservationViewModel {

    private Model model;
    private ObservableList<String> availableRooms;
    private ObjectProperty<LocalDate> startDatePicker;
    private ObjectProperty<LocalDate> endDatePicker;
    private SimpleStringProperty errorLabel;

    public ReservationViewModel(Model model) {
        this.model = model;
        this.availableRooms = FXCollections.observableArrayList();
        startDatePicker = new SimpleObjectProperty<>();
        endDatePicker = new SimpleObjectProperty<>();
        this.errorLabel = new SimpleStringProperty("");
    }

    public void getAllAvailableRooms() {
        RoomList roomList = model.avaliableRooms(dateFromDatePicker(startDatePicker.getValue().toString()),
                dateFromDatePicker(endDatePicker.getValue().toString()));

        // Clear old values
        availableRooms.clear();

        // Add new rooms with selected date to the list
        for (int i = 0; i < roomList.size(); i++) {
            availableRooms.add(roomList.getRoom(i).getId());
        }
    }

    public void reserveRoom(String roomName) {
        // todo In this window we don't have "Guest"
        model.book(roomName, dateFromDatePicker(startDatePicker.getValue().toString()),
                dateFromDatePicker(endDatePicker.getValue().toString()));
    }

    private LocalDate dateFromDatePicker(String datePicker) {
        // DatePicker (values) -> DateTimeObject
        String lines[] = datePicker.split("-");
        int year = Integer.parseInt(lines[0].trim());
        int month = Integer.parseInt(lines[1].trim());
        int day = Integer.parseInt(lines[2].trim());
        return LocalDate.of(year, month, day);
    }


    // Init ListView
    public ObservableList<String> getRooms() throws RemoteException {
        return availableRooms;
    }

    public SimpleStringProperty getErrorLabel() {
        return errorLabel;
    }

    public ObjectProperty<LocalDate> getStartDatePicker() {
        return startDatePicker;
    }

    public ObjectProperty<LocalDate> getEndDatePicker() {
        return endDatePicker;
    }

}
