package View;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import utility.observer.javaobserver.UnnamedPropertyChangeSubject;
import viewModel.AddEditViewModel;
import viewModel.RoomTypes;
import viewModel.ViewModelFactory;

import javax.swing.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.rmi.RemoteException;

public class AddEditViewController extends ViewController {
    public TextField idField;
    public ComboBox<RoomTypes> typeDropdown;
    public TextField nrOfBedsField;
    public RoomTypes selectedType;
    public Label errorLabel;
    private Region root;
    private ViewHandler viewHandler;
    private AddEditViewModel viewModel;
    private PropertyChangeSupport support;


    @Override
    public void init() {
        // Binding
        idField.textProperty().bindBidirectional(viewModel.getRoomIdProperty());
        nrOfBedsField.textProperty().bindBidirectional(viewModel.numberOfBedsProperty());
        typeDropdown.getItems().removeAll(typeDropdown.getItems());
        typeDropdown.getItems().add(RoomTypes.FAMILY);
        typeDropdown.getItems().add(RoomTypes.DOUBLE);
        typeDropdown.getItems().add(RoomTypes.SINGLE);
        selectedType = typeDropdown.getSelectionModel().getSelectedItem();
        errorLabel.textProperty().bind(viewModel.errorPropertyProperty());
    }

    /**
     * A void method initializing instance variables.
     *
     * @param viewHandler A ViewHandler object which will be used to set the instance variable.
     * @param viewModelFactory  A ViewModelFactory object which will be used to set the instance variable.
     * @param root        A Region object which will be used to set the instance variable.
     */
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory, Region root)
            throws RemoteException
    {
        this.root = root;
        this.viewHandler = viewHandler;
        this.viewModelFactory = viewModelFactory;
        this.viewModel = viewModelFactory.getAddEditViewModel();
        this.support = new PropertyChangeSupport(this);
        init();
    }

    @Override
    public void reset() {
        viewModel.reset();
    }


    public void confirmButton() throws IOException {

        viewModel.setType(selectedType);

        JFrame jframe = new JFrame();
        int result = JOptionPane.showConfirmDialog(jframe, "Are you sure you want to make changes?");

        if (result == 0) {
            viewModel.addRoom();
            System.out.println("You confirmed.");
            viewHandler.openView("RoomListView.fxml");
        }
        else if (result == 1)
            System.out.println("You pressed NO");
    }

    @Override
    public Region getRoot() {
        return root;
    }

    @Override
    public ViewHandler getViewHandler() {
        return viewHandler;
    }

    public void exitButton() throws IOException {
        viewHandler.openView("RoomListView.fxml");
    }

    public RoomTypes getType(){
        return selectedType;
    }

}
