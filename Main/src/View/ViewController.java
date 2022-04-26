package View;


import javafx.scene.layout.Region;

import java.rmi.RemoteException;

public abstract class ViewController {
    private Region root;
    private ViewHandler viewHandler;
    ViewModelFactory viewModelFactory;


    public abstract void init();

    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory, Region root) throws RemoteException {
        this.viewHandler = viewHandler;
        this.viewModelFactory = viewModelFactory;
        this.root = root;
    }

    public abstract void reset();

    public Region getRoot(){
        return root;
    }

    public ViewModelFactory getViewModelFactory() {
        return viewModelFactory;
    }

    public ViewHandler getViewHandler(){
        return viewHandler;
    }
}
