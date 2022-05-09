package viewModel;

import model.Model;

public class ViewModelFactory {

    private GuestInformationViewModel guestInformationViewModel;
    private ReservationViewModel reservationViewModel;
<<<<<<< Updated upstream:Main/src/viewModel/ViewModelFactory.java

    public ViewModelFactory(Model model){
        this.reservationViewModel = new ReservationViewModel(model);
        this.guestInformationViewModel = new GuestInformationViewModel(model);
=======
    private RoomListViewModel roomListViewModel;
    private AddEditViewModel addEditViewModel;
    private LogInViewModel logInViewModel;

    public ViewModelFactory(Model model){
        TemporaryInformation tempInfo = new TemporaryInformation();
        this.reservationViewModel = new ReservationViewModel(model,tempInfo);
        this.guestInformationViewModel = new GuestInformationViewModel(model,tempInfo);
        this.roomListViewModel = new RoomListViewModel(model, tempInfo);
        this.addEditViewModel = new AddEditViewModel(model, tempInfo);
        this.logInViewModel = new LogInViewModel(model);
>>>>>>> Stashed changes:Main/Client/src/viewModel/ViewModelFactory.java
    }

    public GuestInformationViewModel getGuestInformationViewModel(){
        return guestInformationViewModel;
    }

    public ReservationViewModel getReservationViewModel() {
        return reservationViewModel;
    }
<<<<<<< Updated upstream:Main/src/viewModel/ViewModelFactory.java
=======

    public RoomListViewModel getRoomListViewModel() {
        return roomListViewModel;
    }

    public AddEditViewModel getAddEditViewModel() {
        return addEditViewModel;
    }

    public LogInViewModel getLogInViewModel() {return logInViewModel;}
>>>>>>> Stashed changes:Main/Client/src/viewModel/ViewModelFactory.java
}
