package View;

import javafx.scene.layout.Region;
import viewModel.RoomListViewModel;
import viewModel.ViewModelFactory;

import java.io.IOException;
import java.rmi.RemoteException;

public class RoomListViewController extends ViewController{
    private Region root;
    private ViewHandler viewHandler;
    private RoomListViewModel viewModel;

    public void addButton() throws IOException {
        viewHandler.openView("AddEditView.fxml");
    }

    public void editButton() throws IOException {
        viewHandler.openView("AddEditView.fxml");
    }

    public void removeButton() {
    }

    @Override
    public void init() {
        // Binding
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
        this.viewModel = viewModelFactory.getRoomListViewModel();
        init();
    }

    @Override
    public void reset() {

    }
}
