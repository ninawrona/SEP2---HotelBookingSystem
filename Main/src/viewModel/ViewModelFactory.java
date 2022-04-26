package viewModel;

import model.Model;

public class ViewModelFactory {

    private GuestInformationViewModel guestInformationViewModel;
    private ReservationViewModel reservationViewModel;

    public ViewModelFactory(Model model){
        this.reservationViewModel = new ReservationViewModel(model);
        this.guestInformationViewModel = new GuestInformationViewModel(model);
    }

    public GuestInformationViewModel getGuestInformationViewModel(){
        return guestInformationViewModel;
    }

    public ReservationViewModel getReservationViewModel() {
        return reservationViewModel;
    }
}
