package viewModel;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.DatePicker;
import model.Model;
import model.Room;
import model.RoomList;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ReservationViewModel {

    private Model model;
    private ObservableList<String> availableRooms;
    private ObjectProperty<LocalDate> startDatePicker;
    private ObjectProperty<LocalDate> endDatePicker;
    private SimpleStringProperty errorLabel;
    private TemporaryInformation temp;

    public ReservationViewModel(Model model, TemporaryInformation tempInfo) {
        this.model = model;
        this.availableRooms = FXCollections.observableArrayList();
        startDatePicker = new SimpleObjectProperty<>();
        endDatePicker = new SimpleObjectProperty<>();
        this.errorLabel = new SimpleStringProperty("");
        this.temp = tempInfo;
    }

    public void getAllAvailableRooms() {
        ArrayList<Room> newRooms;
        try {
            newRooms = model.availableRooms(dateFromDatePicker(startDatePicker.getValue().toString()),
                    dateFromDatePicker(endDatePicker.getValue().toString()));

            availableRooms.clear(); // Clear old rooms

            // Add new rooms with selected date to the list
            for (int i = 0; i < newRooms.size(); i++) {
                availableRooms.add(newRooms.get(i).getRoomId());
            }
        } catch (Exception e) {
            errorLabel.setValue("Choose start/end dates");
        }
    }

    // Puts reserved room data to TemporaryInformation
    public void reserveRoom(String roomName) {

        temp.setStartDate(dateFromDatePicker(startDatePicker.getValue().toString()));
        temp.setEndDate(dateFromDatePicker(endDatePicker.getValue().toString()));
        temp.setRoomID(roomName);
    }

    private LocalDate dateFromDatePicker(String datePicker) {
        // DatePicker (values) -> DateTimeObject
        String lines[] = datePicker.split("-");
        int year = Integer.parseInt(lines[0].trim());
        int month = Integer.parseInt(lines[1].trim());
        int day = Integer.parseInt(lines[2].trim());
        return LocalDate.of(year, month, day);
    }

    public ObservableList<String> getRooms()  {
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
