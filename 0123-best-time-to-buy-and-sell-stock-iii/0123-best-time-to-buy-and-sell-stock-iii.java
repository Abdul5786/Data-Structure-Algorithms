class Solution {
    public int maxProfit(int[] prices) 
    {
        int n = prices.length;
       int dp[][][] = new int[n][2][3];
       for(int arr[][]: dp)
       {
          for(int row[]:arr)
           Arrays.fill(row,-1);
       }
       return helper(prices,0,0,dp,2); 
    }


    public int helper(int prices[],int day,int hold,int dp[][][],int trans)
    {
        //base case 
        if(day==prices.length || trans==0) return 0;

        if(dp[day][hold][trans]!=-1) return dp[day][hold][trans];


        int ans=0;
        if(hold==0) // i am purchasing the stocks   pick or not pic  1 -> for having stock 0 for not having
        {
            int buy = -prices[day]+helper(prices,day+1,1,dp,trans); // pick case

            int notBuy = helper(prices,day+1,0,dp,trans);

            ans = Math.max(buy,notBuy); 
        }

        else 
        {

            int sold = prices[day]+helper(prices,day+1, 0,dp,trans-1); 

            int notSold = helper(prices,day+1,1,dp,trans);

            ans = Math.max(sold,notSold);
        }

        dp[day][hold][trans] = ans;

        return ans;
    }
}