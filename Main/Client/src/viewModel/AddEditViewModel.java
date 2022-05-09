package viewModel;

import javafx.beans.property.*;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import model.Model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class AddEditViewModel {
    private StringProperty roomId;
    private RoomTypes type;
    private ArrayList<RoomTypes> types;
    private StringProperty nrOfBeds;
    private ViewState viewState;
    private Model model;
    private StringProperty errorProperty;

    public AddEditViewModel(Model model, ViewState state) {
        this.model = model;
        this.viewState = state;

        roomId = new SimpleStringProperty();
        nrOfBeds = new SimpleStringProperty();
        types = new ArrayList<>();

        //List.of() makes a collection out of the simple Array.
        types.addAll(List.of(RoomTypes.values()));
        errorProperty = new SimpleStringProperty();
        type = RoomTypes.FAMILY;
        }


    public void reset(){


    }

    public String getRoomId() {
        return roomId.get();
    }

    public StringProperty getRoomIdProperty(){
        return roomId;
    }


    public ViewState getViewState() {
        return viewState;
    }

    public String getNumberOfBeds() {
        return nrOfBeds.get();
    }

    public StringProperty numberOfBedsProperty() {
        return nrOfBeds;
    }

    public void addRoom() {
        model.addRoom(roomId.get(), type, nrOfBeds.get());
    }


    public void editRoomInfo(){
        model.editRoomInfo(roomId.get(), type, nrOfBeds.get());
    }

    public ArrayList<RoomTypes> getTypes() {
        return types;
    }

    public String getErrorProperty() {
        return errorProperty.get();
    }

    public StringProperty errorPropertyProperty() {
        return errorProperty;
    }
}
