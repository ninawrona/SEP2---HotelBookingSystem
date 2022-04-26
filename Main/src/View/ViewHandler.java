package View;

import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;


public class ViewHandler extends ViewCreator{

    private Scene currentScene;
    private Stage primaryStage;
    private ViewModelFactory viewModelFactory;

    public ViewHandler(ViewModelFactory viewModelFactory){
        this.viewModelFactory = viewModelFactory;
    }

    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.currentScene = new Scene(new Region());

        openView("ReservationView.fxml");

    }

    public void openView(String id) throws IOException {
        Region root = getViewController(id).getRoot();

        currentScene.setRoot(root);
        String title = "";
        if(root.getUserData() != null){
            title += root.getUserData();
        }

        primaryStage.setTitle(title);
        primaryStage.setScene(currentScene);
        primaryStage.setWidth(root.getPrefWidth());
        primaryStage.setHeight(root.getPrefHeight());
        primaryStage.show();
    }

    @Override
    protected void initViewController(ViewController viewController, Region root) {
        viewController.init(this, viewModelFactory, root);
    }

}
