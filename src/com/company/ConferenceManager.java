package com.company;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ConferenceManager {
    private static final ConferenceManager instance = new ConferenceManager();
    private static Map<Integer, Session> sessions;

    private ConferenceManager() {
        sessions = new HashMap<Integer, Session>();
    }

    public static ConferenceManager getInstance() {
        return instance;
    }

    public void createDefaultSessions() {
        Session session;
        Date date;

        // Adding sessions to conference
        date = new Date();
        session = new Session(1, "Go Agile with Rails", date, "10:00am - 1:00pm", "Dave Martin", 20);
        sessions.put(1, session);

        session = new Session(2, "Object Oriented Design Patterns", date, "2:00pm - 5:00pm", "Andrew James", 10);
        sessions.put(2, session);

        session = new Session(3, "Clean code and refactoring", date, "10:00am - 1:00pm", "David Thomas", 30);
        sessions.put(3, session);
    }

    public static Session findSessionById(int sessionCode) {
        return sessions.get(sessionCode);
    }

    public void displayAllSessions() {
        System.out.println("Sessions conducted:");
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.printf("%-5s %-40s %-15s %-20s %-20s\n", "Code" , "Session" , "Date", "Timings", "Presenter");
        System.out.println("--------------------------------------------------------------------------------------------------------");

        // Traversing sessions map
        for (Map.Entry <Integer, Session> entry:sessions.entrySet()){
            int key=entry.getKey();
            Session session = entry.getValue();
            System.out.print(session);
            System.out.println();
        }

        System.out.println("--------------------------------------------------------------------------------------------------------");
    }
}