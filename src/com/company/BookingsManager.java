package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BookingsManager {
    private static final BookingsManager instance = new BookingsManager();

    // key - sessionID, value - array list of booking objects
    private Map<Integer, ArrayList<Booking>> bookings;

    private BookingsManager() {
        bookings = new HashMap<Integer, ArrayList<Booking>>();
    }

    public static BookingsManager getInstance() {
        return instance;
    }

    public int countOfBookingsForSessionWithId(int sessionId) {
        if (bookings.get(sessionId) == null) {
            return 0;
        } else {
            return bookings.get(sessionId).size();
        }
    }

    public void saveBooking(Booking booking) {
        int sessionId = booking.getSessionId();
        if (bookings.size() == 0) {
            ArrayList <Booking> bookingsList = new ArrayList<Booking>();
            bookingsList.add(booking);
            bookings.put(sessionId, bookingsList);
        } else {
            bookings.get(sessionId).add(booking);
        }
    }
}
