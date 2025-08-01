class Solution {
    public int maximumWealth(int[][] accounts) 
    {
        int maxWealth = Integer.MIN_VALUE;

        int m = accounts.length;

        int n = accounts[0].length;


        for(int i=0;i<m;i++)
        {
             int currentMax=0;
            for(int j=0;j<n;j++)
            {
                currentMax += accounts[i][j];

               maxWealth = Math.max(currentMax,maxWealth);
            }
        }

        return maxWealth;
    }
}