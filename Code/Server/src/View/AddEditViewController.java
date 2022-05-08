package View;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import viewModel.AddEditViewModel;
import viewModel.ViewModelFactory;

import java.rmi.RemoteException;

public class AddEditViewController extends ViewController
{
  @FXML private TextField idField;
  @FXML private ComboBox<String> typeDropdown;
  @FXML private TextField nrOfBedsField;
  private Region root;
  private ViewHandler viewHandler;
  private AddEditViewModel viewModel;

  @Override public void init()
  {
    // Binding
    idField.textProperty().bind(viewModel.roomNumberProperty());
    typeDropdown.getItems().add("Single");
    typeDropdown.getItems().add("Double");
    typeDropdown.getItems().add("Family");
    typeDropdown.getItems().add("Suite");
    typeDropdown.getItems();
  }

  /**
   * A void method initializing instance variables.
   *
   * @param viewHandler      A ViewHandler object which will be used to set the instance variable.
   * @param viewModelFactory A ViewModelFactory object which will be used to set the instance variable.
   * @param root             A Region object which will be used to set the instance variable.
   */
  public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory,
      Region root) throws RemoteException
  {
    this.root = root;
    this.viewHandler = viewHandler;
    this.viewModelFactory = viewModelFactory;
    this.viewModel = viewModelFactory.getAddEditViewModel();
    init();
  }

  public Region getRoot()
  {
    return root;
  }

  @Override public void reset()
  {

  }

  @FXML private void confirmButton()
  {
  }

}
