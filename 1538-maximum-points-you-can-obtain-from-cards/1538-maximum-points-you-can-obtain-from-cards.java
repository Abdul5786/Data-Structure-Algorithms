class Solution {
    public int maxScore(int[] cardPoints, int k) 
    {
       int rightSum=0, leftSum=0;
       int maxSum =Integer.MIN_VALUE;
       int end=cardPoints.length-1;

       for(int i=0;i<k;i++)
       {
         leftSum +=cardPoints[i];
       }

         maxSum=leftSum;

       for(int i=k-1;i>=0;i--)
       {

          leftSum -=cardPoints[i];
          rightSum +=cardPoints[end--];
          maxSum = Math.max(maxSum,rightSum+leftSum);
       }

       return maxSum;
    }
}