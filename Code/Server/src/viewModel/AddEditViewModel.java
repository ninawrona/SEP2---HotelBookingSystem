package viewModel;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import model.Model;


public class AddEditViewModel {

    private Model model;
    private TemporaryInformation temporaryInformation;

    private SimpleStringProperty roomNumber;
    private SimpleIntegerProperty numberOfBeds;
    private SimpleStringProperty roomType;


    public AddEditViewModel(Model model, TemporaryInformation tempInfo) {
        this.model = model;
        this.temporaryInformation = tempInfo;

        this.roomNumber = new SimpleStringProperty();
        this.roomType = new SimpleStringProperty();
        this.numberOfBeds = new SimpleIntegerProperty();
    }

    private void load()
    {

    }

    public SimpleStringProperty roomNumberProperty()
    {
        return roomNumber;
    }


    public SimpleIntegerProperty numberOfBedsProperty()
    {
        return numberOfBeds;
    }

    public SimpleStringProperty getRoomType()
    {
        return roomType;
    }

}
