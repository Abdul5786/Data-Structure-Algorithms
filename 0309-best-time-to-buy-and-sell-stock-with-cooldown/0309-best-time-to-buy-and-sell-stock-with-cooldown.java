class Solution {
    public int maxProfit(int[] prices)  
    {
       int n = prices.length;
       int dp[][] = new int[n][3];
       for(int row[]: dp)
       {
          Arrays.fill(row,-1);
       }
       return helper(prices,0,0,dp);  
    }


    public int helper(int prices[],int day,int hold,int dp[][])
    {
        //base case 
        if(day==prices.length) return 0;

        if(dp[day][hold]!=-1) return dp[day][hold];


        int ans=0;
        if(hold==0) // i am purchasing the stocks   pick or not pic  1 -> for having stock 0 for not having
        {
            int buy = -prices[day]+helper(prices,day+1,1,dp); // pick case

            int notBuy = helper(prices,day+1,0,dp);

            ans = Math.max(buy,notBuy); 
        }

        else if(hold==1)
        {

            int sold = prices[day]+helper(prices,day+1,2,dp); 

            int notSold = helper(prices,day+1,1,dp);

            ans = Math.max(sold,notSold);
        }

        else 
        {
              ans  = helper(prices,day+1,0,dp);
        }

        dp[day][hold] = ans;

        return ans;
    }
}