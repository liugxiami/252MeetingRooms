package com.ccsi;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Interval[] intervals={new Interval(25,34),new Interval(15,20),new Interval(25,30)};
        System.out.println(canAttendMeeting(intervals));
    }
    //Given an array of meeting time intervals consisting of start and end times[[s1,e1],[s2,e2]...]
    //(si<ei), determine if a person could attend all meetings.
    public static boolean canAttendMeeting(Interval[] intervals){
        Map<Integer,Integer> map=new TreeMap<>();
        for(Interval i:intervals){
            if(map.containsKey(i.start)) return false;
            map.put(i.start,i.end);
        }
        int furthestEnd=-1;
        for(Integer start:map.keySet()){
            if(start<furthestEnd) return false;
            int end=map.get(start);
            if(end>furthestEnd) furthestEnd=end;
        }

        return true;
    }
}
class Interval{
    int start;
    int end;

    public Interval() {
        this.start = 0;
        this.end = 0;
    }
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
