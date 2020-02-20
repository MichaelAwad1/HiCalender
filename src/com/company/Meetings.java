package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public final class Meetings {
    private int startTime;
    private int endTime;
    ArrayList<Meetings> meetings;

    public static Comparator<Meetings> comparator = (o1, o2) -> {
        int m1 = o1.startTime;
        int m2 = o2.startTime;
        return m1 - m2;
    };

    public Meetings(ArrayList<Meetings> meetings) {
        this.meetings = meetings;
    }

    public Meetings(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Meetings() {

    }

    public void readMeetings() {
        int n;
        System.out.println("Please enter number of meetings");
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            Meetings m = new Meetings();
            System.out.println("Enter start time for event #" + (i + 1) + " ");
            m.startTime = scanner.nextInt();
            System.out.println("Enter end time for event #" + (i + 1) + " ");
            m.endTime = scanner.nextInt();
            meetings.add(i, m);
        }
    }

    public static void print(ArrayList<Meetings> printedList) {
        System.out.println("Array of meetings -------->");
        for (int i = 0; i < printedList.size(); i++) {
            System.out.println("Start time for event #" + (i + 1) + " = " + printedList.get(i).startTime);
            System.out.println("End time for event #" + (i + 1) + " = " + printedList.get(i).endTime);
        }
    }

    public static ArrayList<Meetings> sort(ArrayList<Meetings> unsorted) {
        Collections.sort(unsorted, comparator);
        System.out.println("Sort donee");
        return unsorted;
    }

    public static ArrayList<Meetings> mergeTimes(ArrayList<Meetings> unmerged, ArrayList<Meetings> merged) {

        for (int i = 0; i < unmerged.size(); i++) {
            Meetings m = new Meetings();
            m.startTime = unmerged.get(i).startTime;
            m.endTime = unmerged.get(i).endTime;
            int j = 1;
            while (true) {
                if (j < unmerged.size() - i && unmerged.get(i + j).startTime <= m.endTime) {
                    // System.out.println(" in");
                    if (unmerged.get(i + j).endTime > m.endTime) {
                        m.endTime = unmerged.get(i + j).endTime;
                    }
                    j++;
                } else {
                    if (j > 1) {
                        i = j + i - 1;
                    }
                    break;
                }
            }
            merged.add(m);
        }
        return merged;
    }

    public static boolean equal(ArrayList<Meetings> m1, ArrayList<Meetings> m2) {

        for (int i = 0; i < m1.size(); i++) {
            if (m1.get(i).startTime != m2.get(i).startTime || m1.get(i).endTime != m2.get(i).endTime) {
                return false;
            }
        }
        return true;
    }
}
