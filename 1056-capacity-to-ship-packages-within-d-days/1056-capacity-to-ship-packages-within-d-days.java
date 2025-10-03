class Solution {
    public int shipWithinDays(int[] weights, int days) 
    {
       int max=0;
       int  ans=0;
       int sum=0;

       for(int weight:weights)
       {
           sum +=weight;

          max =Math.max(max,weight);
       }

       int low=max;
       int high = sum;


       while(low<=high)
       {

           int mid = low+(high-low)/2;

           if(isPossible(weights,mid,days))
           {
               ans = mid;
               // try for minimum

               high= mid-1;
           }

           else
           {
              low =mid+1;
           }
       }

     return ans;
    }


    public boolean isPossible(int weights[],int capacity,int days)
    {
        int day=1;
       int  totalSum=0;

        for(int weight:weights)
        {
            totalSum +=weight;
             
             if(totalSum>capacity)
             {

                day++;
                totalSum = weight;
        }

        }

        return day<=days;
    }
}