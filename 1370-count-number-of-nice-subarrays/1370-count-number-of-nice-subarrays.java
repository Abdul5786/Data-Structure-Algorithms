class Solution {
    public int numberOfSubarrays(int[] nums, int k) 
    {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int count=0, odd=0;
        for(int num:nums)
        {
           if(num%2!=0)
           {
              odd++;
           }

           count +=map.getOrDefault(odd-k,0);
           map.put(odd,map.getOrDefault(odd,0)+1);
        }

        return count;    
    }
}