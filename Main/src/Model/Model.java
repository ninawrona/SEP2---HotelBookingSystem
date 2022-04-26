package Model;

import java.time.LocalDate;

public interface Model
{
  int availableRooms(LocalDate startDate, LocalDate endDate);
  void book(String roomId, LocalDate startDate, LocalDate endDate, Guest guest);
}
