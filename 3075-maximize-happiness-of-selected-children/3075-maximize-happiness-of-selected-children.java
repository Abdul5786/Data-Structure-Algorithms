class Solution {
    public long maximumHappinessSum(int[] happiness, int k) 
    {
       long result =0;
       PriorityQueue<Integer> pq =  new PriorityQueue<>((a,b)->b-a);

      for(int n : happiness)
      {
        pq.offer(n);
      }

      for(int i=0;i<k;i++)
      {

         int num = pq.poll()-i;
          result += (num>0) ? num :0;  
      }

      return result;
    }
}