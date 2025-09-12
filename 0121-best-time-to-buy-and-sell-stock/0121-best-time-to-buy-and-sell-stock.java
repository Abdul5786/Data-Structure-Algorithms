class Solution {
    public int maxProfit(int[] prices) 
    {
     
        int minPrice = prices[0],  profit=0;

        for(int i=0;i<prices.length;i++)
        {
              int currentCost = prices[i]-minPrice;

              profit = Math.max(currentCost,profit);

              minPrice =Math.min(minPrice,prices[i]); 
        }

        return profit;

    }

}