package com.company;

public class Main {
    public static void main(String[] args) {
        ConferenceManager conferenceManager = ConferenceManager.getInstance();
        conferenceManager.createDefaultSessions();
        conferenceManager.displayAllSessions();

        AttendeesManager attendeesManager = AttendeesManager.getInstance();
        attendeesManager.createDefaultAttendees();
        attendeesManager.viewAllAttendees();

        // Book seat in a session for attendee
        BookingsManager bookingsManager = BookingsManager.getInstance();
        Attendee attendee = attendeesManager.getRandomAttendee();
        Session session = ConferenceManager.findSessionById(1);
        session.setBookingsManager(bookingsManager);
        System.out.printf("Book seat for %s in session \n %s", attendee, session);

        if (session.seatIsAvailable()) {
            Booking booking = new Booking(session.getId(), attendee.getId());
            bookingsManager.saveBooking(booking);
            System.out.printf("Seat booked for %s in session - %s\n", attendee, session.getName());
            System.out.printf("Seats remaining in session - %d/%d\n", session.seatsRemaining(), session.getTotalNumberOfSeats());
        } else {
            System.out.println("Sorry no seats available for the requested session");
        }
    }
}