/*
 * Condenser
 * This Part Handles the Creation and Condensing of Meetings
 * Run Time O(N*lg(N))
 */

import java.lang.Math;
import java.util.ArrayList;

public class Condenser
{
    public static void main(String[] args) 
    {
        ArrayList <Meeting> meetings = new ArrayList<Meeting>(); //Create List of Meetings
        meetings.add(new Meeting(1, 10)); //Add Meeting
        meetings.add(new Meeting(2, 6)); //Add Meeting
        meetings.add(new Meeting(3, 5)); //Add Meeting
        meetings.add(new Meeting(7, 9)); //Add Meeting
        
        System.out.println("Meetings: "+meetings); //Print List of Meetings
        System.out.println("Condensed Meetings: "+condenseMeetingTimes(meetings)); //Condense and Print New Meetings List
    }
    
    static ArrayList <Meeting> condenseMeetingTimes(ArrayList <Meeting> mts) //Meeting Condenser, Runs in O(N*lg(N))
    {
        mts.sort((m1, m2) -> (m1.startTime - m2.startTime)); //Merge Sort Meetings by Start Time, O(N*lg(N))
        
        for (int i=1; i<mts.size();) //Loop Through List, O(N)
        {
            if (mts.get(i).startTime<=mts.get(i-1).endTime) //If Meeting Starts When or Before Previous Ends
            {
                mts.get(i-1).endTime = Math.max(mts.get(i).endTime, mts.get(i-1).endTime); //Condense Meeting into Previous
                mts.remove(i); //Remove Meeting
            }
            else i++; //Move to Next Meeting
        }
        
        return mts; //Returned Condensed List
    }
}
