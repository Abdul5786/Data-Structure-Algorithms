class Solution {
    public int eraseOverlapIntervals(int[][] intervals) 
    {
        Arrays.sort(intervals,(a,b)->a[1]-b[1]); // sorted on the bases of end time
        int count=0;
        int prev = intervals[0][1]; // prev end time 

        for(int i=1;i<intervals.length;i++)
        {
            if(intervals[i][0]<prev)  // start time is lees than prevois end time mean 1,4-> 2,-3 overlapp
            {
               count++;
            }

            else 
            {
               prev =intervals[i][1];
            }
        }

        return count;
    }
}