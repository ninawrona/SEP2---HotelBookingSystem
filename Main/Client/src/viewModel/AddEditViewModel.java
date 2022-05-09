package viewModel;

import javafx.beans.property.*;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import model.Model;
import model.Room;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A class providing functionality for AddEditViewController.
 *
 * @version 09/05/2022
 */
public class AddEditViewModel {
    private StringProperty roomId;
    private RoomTypes type;
    private ArrayList<RoomTypes> types;
    private StringProperty nrOfBeds;
    private ViewState viewState;
    private Model model;
    private StringProperty errorProperty;

    /**
     * Constructor initializing instance variables.
     *
     * @param model    model interface
     * @param state    shared object with a ReservationViewModel
     *                 that checks if the view needs to be filled with information
     *                 of the selected view or empty.
     */
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

    /**
     * A non argument method that that checks if the view needs to be filled with information
     * of the selected view or empty and creates the view accurately.
     */
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

    /**
     * A getter method that returns a String object
     * taken from a StringProperty.
     * @return a String object
     */
    public String getRoomId() {
        return roomId.get();
    }

    /**
     * A getter method that returns a StringProperty object
     * @return a StringProperty object called roomId
     */
    public StringProperty getRoomIdProperty(){
        return roomId;
    }

    /**
     * A getter method that returns a ViewState object
     * @return a ViewState object called viewState
     */
    public ViewState getViewState() {
        return viewState;
    }

    /**
     * A getter method that returns a Integer object
     * @return an Integer object
     */
    public String getNumberOfBeds() {
        return nrOfBeds.get();
    }

    /**
     * A getter method that returns a IntegerProperty object
     * @return a IntegerProperty object called nrOfBeds
     */
    public StringProperty numberOfBedsProperty() {
        return nrOfBeds;
    }

    /**
     * A non argument method calls an addRoom(String roomId, RoomTypes type, int nrBeds)
     * from the model
     */
    public void addRoom() {
        model.addRoom(roomId.get(), type, nrOfBeds.get());
        System.out.println(model.getAllRooms());
    }

    /**
     * A non argument method calls an editRoomInfo(String roomId, RoomTypes type, int nrBeds)
     * from the model
     */
    public void editRoomInfo(){
        model.editRoomInfo(roomId.get(), type, nrOfBeds.get());
    }

    /**
     * A non argument method setting a RoomTypes instance valuable called type.
     */
    public void setType(RoomTypes type){
        this.type = type;
    }

    /**
     * A getter method that returns a String object
     * @return a String object
     */
    public String getErrorProperty() {
        return errorProperty.get();
    }

    /**
     * A getter method that returns a StringProperty object
     * @return a StringProperty object called nrOfBeds
     */
    public StringProperty errorPropertyProperty() {
        return errorProperty;
    }
}
