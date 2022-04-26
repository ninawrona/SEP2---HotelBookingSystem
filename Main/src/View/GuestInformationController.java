package View;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import viewModel.GuestInformationViewModel;
import viewModel.ReservationViewModel;
import viewModel.ViewModelFactory;

import java.rmi.RemoteException;
/**
 * A class creating an GuestInformationController object.
 *
 * @author
 * @version 26/04/2022
 */

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

    /**
     * A none argument, void method initializing instance variables.
     */
    @Override
    public void init() {

    }

    /**
     * A void method initializing instance variables.
     *
     * @param viewHandler A ViewHandler object which will be used to set the instance variable.
     * @param viewModelFactory  A ViewModelFactory object which will be used to set the instance variable.
     * @param root        A Region object which will be used to set the instance variable.
     */
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


    /**
     * A getter method returning the Region object.
     *
     * @return A Region object called root.
     */
    public Region getRoot(){
        return root;
    }

    //todo
    @Override
    public void reset() {
        //viewModel.clear();
    }
    /**
     * A void method closing this view and setting guest information
     * for currently running booking.
     */
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
