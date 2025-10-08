class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) 
    {
        Arrays.sort(potions);

        int n = spells.length;

        int ans[] = new int[n];


        for(int i=0;i<spells.length;i++)
        {

            int idx = binarySearch(spells[i],potions,success);
            if(idx!=-1) ans[i] = potions.length-idx;
        }

        return ans;
    }

    public int binarySearch(long spell,int potions[],long success)
    {
        int low=0 , high=potions.length-1, idx=-1;
        
        

        while(low<=high)
        {
            int mid = low+(high-low)/2;
        if((long)potions[mid]*spell>=success)
        {
            idx =mid;
            high=mid-1; // try for more smaller idx
        }

        else 
        {
             low = mid+1;
        }
    }
    
    return idx;
}

}