package com.company;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Session {
    private int id;
    private String name;
    private Date conductedOn;
    private String timings;
    private String presenter;
    private int totalNumberOfSeats;

    private BookingsManager bookingsManager;

    Session(int id, String name, Date conductedOn, String timings, String presenter, int totalNumberOfSeats) {
        this.id = id;
        this.name = name;
        this.conductedOn = conductedOn;
        this.timings = timings;
        this.presenter = presenter;
        this.totalNumberOfSeats = totalNumberOfSeats;
    }

    public String toString() {
        // myDate is the java.util.Date in yyyy-mm-dd format
        // Converting it into String using formatter
        SimpleDateFormat dmyFormat = new SimpleDateFormat("dd MMM,yyyy");
        String strDate = dmyFormat.format(conductedOn);

        String s = String.format("%-5s %-40s %-15s %-20s %-20s\n", id, name, strDate, timings, presenter);
        return s;
    }

    public boolean seatIsAvailable() {
        int bookingsCount = bookingsManager.countOfBookingsForSessionWithId(this.id);
        return bookingsCount < totalNumberOfSeats;
    }

    public int seatsRemaining() {
        int bookingsCount = bookingsManager.countOfBookingsForSessionWithId(this.id);
        return totalNumberOfSeats - bookingsCount;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getTotalNumberOfSeats() {
        return totalNumberOfSeats;
    }

    public void setBookingsManager(BookingsManager bookingsManager) {
        this.bookingsManager = bookingsManager;
    }
}



