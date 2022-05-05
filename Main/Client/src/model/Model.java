package model;

import java.time.LocalDate;
import java.util.ArrayList;

public interface Model
{
  ArrayList<Room> availableRooms(LocalDate startDate, LocalDate endDate);
  boolean book(String roomId, LocalDate startDate, LocalDate endDate, Guest guest);
  boolean isBookingAllowed(String roomId, LocalDate startDate, LocalDate endDate);
}
