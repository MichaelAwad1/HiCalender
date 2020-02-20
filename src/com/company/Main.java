package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Meetings> meetings = new ArrayList<>();
        ArrayList<Meetings> meetingsSorted = new ArrayList<>();
        Meetings m = new Meetings(meetings);
        m.readMeetings();
        m.print(meetings);
        m.sort(meetings);
        m.print(meetings);
        m.mergeTimes(meetings, meetingsSorted);
        m.print(meetingsSorted);
    }
}
