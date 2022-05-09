package viewModel;

import javafx.beans.property.*;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import model.Model;
import model.Room;

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
        type = null;
        types = new ArrayList<>();

        //List.of() makes a collection out of the simple Array.
        types.addAll(List.of(RoomTypes.values()));
        errorProperty = new SimpleStringProperty();

        reset();
        }


    public void reset(){
        errorProperty.set("");

        if(viewState.isAdd()){
            roomId = null;
            nrOfBeds = null;
            type = null;
        }
        else{
            for(int i = 0; i<model.getAllRooms().size(); i++){
                if(model.getAllRooms().get(i).getRoomId() == roomId.get()){
                    model.getAllRooms().get(i).setType(type);
                    model.getAllRooms().get(i).setNrOfBeds(nrOfBeds.get());
                }
            }
        }

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
        System.out.println(model.getAllRooms());
    }


    public void editRoomInfo(){
        model.editRoomInfo(roomId.get(), type, nrOfBeds.get());
    }

    public ArrayList<String> getTypes() {

        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i< types.size(); i++) {
            list.add(types.get(i).toString());
        }
        return list;
    }

    public void setType(RoomTypes type){
        this.type = type;
    }

    public String getErrorProperty() {
        return errorProperty.get();
    }

    public StringProperty errorPropertyProperty() {
        return errorProperty;
    }
}
