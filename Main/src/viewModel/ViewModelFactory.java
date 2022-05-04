package viewModel;

import model.Model;

public class ViewModelFactory {

    private GuestInformationViewModel guestInformationViewModel;
    private ReservationViewModel reservationViewModel;

    public ViewModelFactory(Model model){
        TemporaryInformation tempInfo = new TemporaryInformation();
        this.reservationViewModel = new ReservationViewModel(model,tempInfo);
        this.guestInformationViewModel = new GuestInformationViewModel(model,tempInfo);
    }

    public GuestInformationViewModel getGuestInformationViewModel(){
        return guestInformationViewModel;
    }

    public ReservationViewModel getReservationViewModel() {
        return reservationViewModel;
    }
}
