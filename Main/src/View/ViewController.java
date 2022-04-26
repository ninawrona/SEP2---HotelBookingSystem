package View;


import javafx.scene.layout.Region;
import viewModel.ViewModelFactory;

import java.rmi.RemoteException;

public abstract class ViewController {
    private Region root;
    private ViewHandler viewHandler;
    private ViewModelFactory viewModelFactory;

    protected abstract void init();

    public abstract void reset();

    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory, Region root) throws RemoteException {
        this.root = root;
        this.viewHandler = viewHandler;
        this.viewModelFactory = viewModelFactory;
        init();
    }

    public Region getRoot() {
        return root;
    }

    public ViewModelFactory getViewModelFactory() {
        return viewModelFactory;
    }

    public ViewHandler getViewHandler() {
        return viewHandler;
    }
}
