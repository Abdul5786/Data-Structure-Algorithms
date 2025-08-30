class Solution {
    public int maxProfit(int[] prices) 
    {

         int minPrice = prices[0] , profit = 0;

         for(int i=1;i<prices.length;i++)
         {
            
             int cost = prices[i]-minPrice; //  1 - 7 cost -6

             profit = Math.max(cost,profit);

             minPrice = Math.min(minPrice,prices[i]);

         }

         return profit;
    }

}