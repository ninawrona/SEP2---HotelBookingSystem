package viewModel;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import model.Model;


public class AddEditViewModel {

    private Model model;
    private TemporaryInformation temporaryInformation;

    private SimpleStringProperty roomNumber;
    private SimpleIntegerProperty numberOfBeds;
    private String roomType;


    public AddEditViewModel(Model model, TemporaryInformation tempInfo) {
        this.model = model;
        this.temporaryInformation = tempInfo;

        roomNumber = new SimpleStringProperty();
        numberOfBeds = new SimpleIntegerProperty();
        load();
    }

    private void load()
    {
        System.out.println("LOADING");
        roomNumber.set(temporaryInformation.getRoomID());
        System.out.println("LOADING: " + temporaryInformation.getRoomID());
        numberOfBeds.set(temporaryInformation.getNumberOfBeds());
        roomType = temporaryInformation.getRoomType();
    }

    public SimpleStringProperty roomNumberProperty()
    {
        return roomNumber;
    }


    public SimpleIntegerProperty numberOfBedsProperty()
    {
        return numberOfBeds;
    }

    public String getRoomType()
    {
        return roomType;
    }

}
