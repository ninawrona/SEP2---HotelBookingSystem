package model;

import viewModel.RoomTypes;

import java.time.LocalDate;
import java.util.ArrayList;

public interface Model
{
  ArrayList<Room> availableRooms(LocalDate startDate, LocalDate endDate);
  boolean book(String roomId, LocalDate startDate, LocalDate endDate, Guest guest);
  boolean isBookingAllowed(String roomId, LocalDate startDate, LocalDate endDate);
  boolean editRoomInfo(String roomId, RoomTypes type, String nrOfBeds);
  boolean addRoom(String roomId, RoomTypes type, String nrBeds);
}
