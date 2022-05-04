package View;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Region;
import javax.swing.text.View;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

public abstract class ViewCreator {

    private Map<String, ViewController> controllers;

    public ViewCreator(){
        controllers = new HashMap<String, ViewController>();
    }

    public ViewController getViewController(String id) throws IOException {
        ViewController controller = controllers.get(id);
        if(controller == null){
            controller = loadFromFXML(id);
            controllers.put(id, controller);
        }
        else{
            controller.reset();
        }

        return controller;
    }

    private ViewController loadFromFXML(String txtFile) throws IOException{
        ViewController controller = null;
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(txtFile));
            Region root = loader.load();
            controller = loader.getController();
            initViewController(controller, root);

            if (controller == null){
                throw new Exception("controller == null");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return controller;
    }

    protected abstract void initViewController(ViewController viewController, Region root) throws RemoteException;

}
