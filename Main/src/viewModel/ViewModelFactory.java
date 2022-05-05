package viewModel;

import model.Model;

public class ViewModelFactory {

    private GuestInformationViewModel guestInformationViewModel;
    private ReservationViewModel reservationViewModel;
    private RoomListViewModel roomListViewModel;
    private AddEditViewModel addEditViewModel;

    public ViewModelFactory(Model model){
        TemporaryInformation tempInfo = new TemporaryInformation();
        this.reservationViewModel = new ReservationViewModel(model,tempInfo);
        this.guestInformationViewModel = new GuestInformationViewModel(model,tempInfo);
        this.roomListViewModel = new RoomListViewModel(model, tempInfo);
        this.addEditViewModel = new AddEditViewModel(model, tempInfo);
    }

    public GuestInformationViewModel getGuestInformationViewModel(){
        return guestInformationViewModel;
    }

    public ReservationViewModel getReservationViewModel() {
        return reservationViewModel;
    }

    public RoomListViewModel getRoomListViewModel() {
        return roomListViewModel;
    }

    public AddEditViewModel getAddEditViewModel() {
        return addEditViewModel;
    }
}
