package Model;

import java.time.LocalDate;

public class ModelManager implements Model
{
    @Override
    public int availableRooms(LocalDate startDate, LocalDate endDate) {
        return 0;
    }

    @Override
    public void book(String roomId, LocalDate startDate, LocalDate endDate, Guest guest) {

    }
}
