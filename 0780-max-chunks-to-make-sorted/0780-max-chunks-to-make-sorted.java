class Solution {
    public int maxChunksToSorted(int[] arr) 
    {
        int chunks=0 , max=Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++)
        {
             max = Math.max(max,arr[i]);
             if(max==i)
             {
                chunks++;
             }  
        }

        return chunks;
    }
}