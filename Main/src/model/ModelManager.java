package model;

import javax.print.DocFlavor;
import java.time.LocalDate;
import java.util.ArrayList;

public class ModelManager implements Model {
    private RoomBookingList allBookings;
    private RoomList roomList;

    public ModelManager() {
        allBookings = new RoomBookingList();
        roomList = new RoomList();
    }

    @Override
    public ArrayList<Room> availableRooms(LocalDate startDate, LocalDate endDate) {
        ArrayList<Room> notAvailableRooms = allBookings.getBookedRoomsBy(startDate, endDate);
        ArrayList<Room> allRooms = roomList.getRoomList();
        ArrayList<Room> finalList = roomList.getRoomList();

        for (int i = 0; i < allRooms.size(); i++) {
            for (int j = 0; j < notAvailableRooms.size(); j++) {
                if (allRooms.get(i).getRoomId().equals(notAvailableRooms.get(j).getRoomId())) {
                    finalList.remove(allRooms.get(i));
                }
            }
        }
        return finalList;
    }

    // Making check right before making a booking (if that room is available)
    public boolean isBookingAllowed(String roomId, LocalDate startDate, LocalDate endDate) {
        ArrayList<Room> notAvailableRooms = allBookings.getBookedRoomsBy(startDate, endDate);

        for (int i = 0; i < notAvailableRooms.size(); i++) {
            if (notAvailableRooms.get(i).getRoomId().equals(roomId)) {
                return false;
            }
        }
        return true;
    }

    // If room is booked successfully return true
    @Override
    public boolean book(String roomId, LocalDate startDate,
                        LocalDate endDate, Guest guest) {
        if (isBookingAllowed(roomId, startDate, endDate)) {
            allBookings.addBooking(new RoomBooking(startDate, endDate, roomList.getRoom(roomId), guest));
            return true;
        }
        return false;
    }

}
