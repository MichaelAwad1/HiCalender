package com.company;

import org.testng.annotations.Test;

import java.util.ArrayList;

public class Testing {
    final ArrayList<Meetings> meetingsIn = new ArrayList<>();
    final ArrayList<Meetings> meetingsOut = new ArrayList<>();

    @Test
    public void mergeTest() {
        ArrayList<Meetings> meetingsMerged = new ArrayList<>();
        Meetings m11 = new Meetings(0, 1);
        Meetings m12 = new Meetings(3, 5);
        Meetings m13 = new Meetings(4, 8);
        Meetings m22 = new Meetings(10, 12);
        Meetings m33 = new Meetings(9, 10);
//        Meetings m44 = new Meetings(9,15);
//        Meetings m55 = new Meetings(17,19);
//        Meetings m66 = new Meetings(21,22);
//        Meetings m77 = new Meetings(22,24);
//        Meetings m88 = new Meetings(25,27);

        meetingsIn.add(m11);
        meetingsIn.add(m12);
        meetingsIn.add(m13);
        meetingsIn.add(m22);
        meetingsIn.add(m33);
//        meetingsIn.add(m44);
//        meetingsIn.add(m55);
//        meetingsIn.add(m66);
//        meetingsIn.add(m77);
//        meetingsIn.add(m88);

        Meetings.sort(meetingsIn);
        Meetings m1 = new Meetings(0, 1);
        Meetings m2 = new Meetings(3, 8);
        Meetings m3 = new Meetings(9, 12);
//        Meetings m4 = new Meetings(21,24);
//        Meetings m5 = new Meetings(25,27);

        meetingsOut.add(m1);
        meetingsOut.add(m2);
        meetingsOut.add(m3);
//        meetingsOut.add(m4);
//        meetingsOut.add(m5);

        Meetings.mergeTimes(meetingsIn, meetingsMerged);
        System.out.println("merge Test");
        Meetings.print(meetingsMerged);
        assert Meetings.equal(meetingsOut, meetingsMerged);
        System.out.println("Merge Done Successfully");
    }
}
