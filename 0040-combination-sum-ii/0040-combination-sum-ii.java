class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) 
    {
         List<List<Integer>> res=  new ArrayList<>();
         Arrays.sort(candidates);
         helper(candidates,target,0,new ArrayList<>(),res);
         return res;
    }

   private void  helper(int candidates[],int target,int start,List<Integer> curr,List<List<Integer>> res)
    {

        if(target==0)
        {
            res.add(new ArrayList<>(curr));
        }

        for(int i=start;i<candidates.length;i++)
        {
              // skip duplicates
            if(i>start && candidates[i]==candidates[i-1])
              continue;
              
              // if current is greater then target
              if(candidates[i]>target)
              break;

              curr.add(candidates[i]);
              helper(candidates,target-candidates[i],i+1,curr,res);
              //back track 

              curr.remove(curr.size()-1);
        }
    }
}