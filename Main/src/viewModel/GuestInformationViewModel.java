package viewModel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Guest;
import model.Model;

public class GuestInformationViewModel {

    private Model model;
    private StringProperty firstNameField;
    private StringProperty lastNameField;
    private StringProperty emailField;
    private StringProperty phoneNumberField;
    private StringProperty errorLabel;
    private TemporaryInformation temp;

    public GuestInformationViewModel(Model model) {
        this.model = model;
        this.firstNameField = new SimpleStringProperty();
        this.lastNameField = new SimpleStringProperty();
        this.emailField = new SimpleStringProperty();
        this.phoneNumberField = new SimpleStringProperty();
        this.errorLabel = new SimpleStringProperty();
        this.temp = new TemporaryInformation();
    }

    public void bookRoomWithGuest() {
        model.book(temp.getRoomID(), temp.getStartDate(), temp.getEndDate(), new Guest(
            firstNameField.getValue(), lastNameField.getValue(),
            emailField.getValue(),Integer.parseInt(phoneNumberField.getValue()))
        );
    }

    public StringProperty getFirstNameField() {
        return firstNameField;
    }

    public StringProperty getLastNameField() {
        return lastNameField;
    }

    public StringProperty getEmailField() {
        return emailField;
    }

    public StringProperty getPhoneNumberField() {
        return phoneNumberField;
    }

    public StringProperty getErrorLabel() {
        return errorLabel;
    }
}
