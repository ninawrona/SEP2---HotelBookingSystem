package View;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import viewModel.GuestInformationViewModel;
import viewModel.ReservationViewModel;
import viewModel.ViewModelFactory;

import java.rmi.RemoteException;

public class GuestInformationController extends ViewController
{
    public TextField firstNameField;
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
        firstNameField.textProperty().bind(viewModel.getFirstNameField());
        lastNameField.textProperty().bind(viewModel.getLastNameField());
        emailField.textProperty().bind(viewModel.getEmailField());
        phoneNumberField.textProperty().bind(viewModel.getPhoneNumberField());
        errorLabel.textProperty().bind(viewModel.getErrorLabel());
    }

    public Region getRoot(){
        return root;
    }

    @Override
    public void reset() {
        //viewModel.clear();
    }

    public void confirmButton(ActionEvent actionEvent) {
        /*String possibleErrorMessage = viewModel.createGuest();
        if (possibleErrorMessage.equals("Success")) {
            // Go to next window
            // viewHandler.openView(".fxml");
        } else {
            errorLabel.setText(possibleErrorMessage);
        }

         */
    }
}
