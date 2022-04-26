import Model.Model;
import View.ViewHandler;
import javafx.application.Application;
import javafx.stage.Stage;
import Model.ModelManager;
import viewModel.ViewModelFactory;


import java.io.IOException;

public class MyApplication extends Application
{
  public void start(Stage primaryStage) throws InterruptedException, IOException {
    Model model = new ModelManager();
    ViewModelFactory viewModelFactory = new ViewModelFactory(model);
    ViewHandler view = new ViewHandler(viewModelFactory);

    view.start(primaryStage);

  }
}
