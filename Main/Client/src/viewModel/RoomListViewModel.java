package viewModel;

import model.Model;

public class RoomListViewModel {
    private ViewState state;
    private Model model;

    public RoomListViewModel(Model model, ViewState state) {
        this.state = state;
        this.model = model;
    }


    public void setAdd() {
     state.setAdd(true);
    }

    public void setEdit(){
        state.setAdd(false);
    }
}
