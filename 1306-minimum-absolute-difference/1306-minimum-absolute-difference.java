class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) 
    {
        int mindifference=Integer.MAX_VALUE;

        List<List<Integer>>     ans   =  new ArrayList<>();
        Arrays.sort(arr); 
        for(int i=0 ;i<arr.length-1;i++)
        {
            int currentMindifference= Math.abs(arr[i]-arr[i+1]);
             mindifference= Math.min(currentMindifference,mindifference);
        }

        for(int i=0 ;i<arr.length-1;i++)
        {
            if(Math.abs(arr[i]-arr[i+1])==mindifference)
            {
                ans.add(Arrays.asList(arr[i],arr[i+1]));
            }

            
        }

        return ans;
    }
}