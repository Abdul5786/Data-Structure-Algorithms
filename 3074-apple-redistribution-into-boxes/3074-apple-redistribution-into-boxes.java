class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int res=0,sum=0,curr=0;
        PriorityQueue<Integer> q=new PriorityQueue<>(Collections.reverseOrder());
        for(int n:capacity) q.offer(n);
        for(int n:apple) sum+=n;
        while(curr<sum&&!q.isEmpty()){
            res++;
            curr+=q.poll();
        }
        return res; 
    }
}