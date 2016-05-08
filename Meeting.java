/*
 * Meeting Class
 * This Class is the Meeting Objects
 */

class Meeting 
{
    int startTime; //Meeting Start Time
    int endTime; //Meeting End Time

    public Meeting(int startTime, int endTime) //Declare New Meeting
    {
        // number of 30 min blocks past 9:00 am
        this.startTime = startTime; //Set Start Time
        this.endTime   = endTime; //Set End Time
    }

    public String toString() 
    	{return String.format("(%d, %d)", startTime, endTime);} //Print Meeting
}