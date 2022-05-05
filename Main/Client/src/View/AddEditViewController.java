package View;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import viewModel.AddEditViewModel;
import viewModel.ViewModelFactory;

import java.rmi.RemoteException;

public class AddEditViewController extends ViewController{
    public TextField idField;
    public ComboBox typeDropdown;
    public TextField nrOfBedsField;
    private Region root;
    private ViewHandler viewHandler;
    private AddEditViewModel viewModel;

    public void confirmButton() {
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
        this.viewModel = viewModelFactory.getAddEditViewModel();
        init();
    }

    @Override
    public void reset() {

    }
}
