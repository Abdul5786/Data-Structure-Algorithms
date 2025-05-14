class Solution {
    public int minEatingSpeed(int[] piles, int h) 
    {
        int low=1;
        int high= getMaxPiles(piles);
        int result=high;
        int ans=-1;

       while(low<=high)
       {
                int mid= low+(high-low)/2;
                if(canEatAllPiles(piles,h,mid))
                {
                    ans=mid;
                    // check for minimum value again
                    high=mid-1;
                }

                else
                {

                    low=mid+1;
                }
       }


      return ans;
    }

    public int getMaxPiles(int piles[])
    {
       int maxPile=0;
        for(int pi:piles)
        {
            maxPile=Math.max(pi,maxPile);
        }
        return maxPile;
    }

    // check if koko can eat all banas at given times

    private boolean canEatAllPiles(int piles[],int h,int speed)
    {

        int totalHours=0;
        for(int pile:piles)
        {
              totalHours+= Math.ceil((double) pile/speed);
        }

        return totalHours<=h;
    }
}