class Solution {
    public int minEatingSpeed(int[] piles, int h) 
    {
        int low=1; // minimum eating speed of  koko 
        int high=getMaxPiles(piles);
        int ans=0;


        while(low<=high)
        {
            int mid = low+(high-low)/2;

            if(iscanEatAllBananas(piles,h,mid))
            {
                ans = mid; 
                // try for more minimum value
                high= mid-1;
            }

            else 
            {
                low =mid+1;
            }
        }

       return ans;
    }

    public int getMaxPiles(int piles[])
    {
      
        int max=Integer.MIN_VALUE;

        for(int pile:piles)
        {
         max  = Math.max(max,pile);
        }

        return max;
    }

    public boolean iscanEatAllBananas(int piles[], int time,int speed)
    {
        int totalHours=0;

        for(int pile:piles)
        {
             totalHours  +=Math.ceil((double)pile/speed);
        }
        
        return  totalHours<=time;
    }
}