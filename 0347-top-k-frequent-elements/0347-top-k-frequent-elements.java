class Solution {
    public int[] topKFrequent(int[] nums, int k) 
    {
        HashMap<Integer,Integer>  map = new HashMap<>(); // to store frequencies

        for(int num :nums)
        {
           map.put(num,map.getOrDefault(num,0)+1);
        }


       PriorityQueue<Integer> pq =  new PriorityQueue<>((a,b)-> map.get(b)-map.get(a));

       for( int key : map.keySet())
       {
          pq.offer(key);
       }


       int ans[] = new int[k];

       for(int i=0;i<k;i++)
       {
          ans[i] = pq.poll();
       }

       return ans;
    }
}