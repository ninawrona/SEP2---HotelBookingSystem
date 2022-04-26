package View;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import viewModel.GuestInformationViewModel;
import viewModel.ViewModelFactory;

import java.io.IOException;
import java.rmi.RemoteException;

public class GuestInformationController extends ViewController
{
    public TextField firstNameFields;
    public TextField lastNameField;
    public TextField emailField;
    public TextField phoneNumberField;
    public Label errorLabel;
    private GuestInformationViewModel viewModel;
    private Region root;
    private ViewHandler viewHandler;

    @Override
    public void init() {

    }

    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory, Region root)
            throws RemoteException {
        this.root = root;
        this.viewHandler = viewHandler;
        this.viewModelFactory = viewModelFactory;
        this.viewModel = viewModelFactory.getGuestInformationViewModel();

        init();

        // Binding
        firstNameFields.textProperty().bindBidirectional(viewModel.getFirstNameField());
        lastNameField.textProperty().bindBidirectional(viewModel.getLastNameField());
        emailField.textProperty().bindBidirectional(viewModel.getEmailField());
        phoneNumberField.textProperty().bindBidirectional(viewModel.getPhoneNumberField());
        errorLabel.textProperty().bindBidirectional(viewModel.getErrorLabel());
    }

    public Region getRoot(){
        return root;
    }

    @Override
    public void reset() {
        //viewModel.clear();
    }

    public void confirmButton(ActionEvent actionEvent) {
        viewModel.bookRoomWithGuest();
    }

    public void goBack() throws IOException {
        viewHandler.openView("ReservationView.fxml");
    }
}
