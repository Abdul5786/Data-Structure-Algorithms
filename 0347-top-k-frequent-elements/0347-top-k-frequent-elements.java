class Solution {
    public int[] topKFrequent(int[] nums, int k) 
    {
         HashMap<Integer,Integer> map = new HashMap<>();
         ArrayList<Integer> res =  new ArrayList<>();

         for(int num:nums)
         {
            map.put(num,map.getOrDefault(num,0)+1);
         }
         
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        
        for(int i : map.keySet()){
            pq.offer(i);
        }

        int[] ans = new int[k];
        for(int i=0; i<k; i++){
            ans[i] = pq.poll();
        }

        
        return ans;
    }
}