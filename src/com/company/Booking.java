package com.company;

public class Booking {
    private int sessionId;
    private int attendeeId;

    Booking(int sessionId, int attendeeId) {
        this.sessionId = sessionId;
        this.attendeeId = attendeeId;
    }

    public int getSessionId() {
        return  sessionId;
    }

    @Override
    public String toString() {
        return "Session ID:" + sessionId + "Attendee ID:" + attendeeId;
    }
}