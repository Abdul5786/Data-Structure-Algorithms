class Solution {
    List<List<Integer>> res=  new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) 
    {
         
         Arrays.sort(candidates);
         helper(candidates,target,0,new ArrayList<>());
         return res;
    }

   private void  helper(int candidates[],int target,int start,List<Integer> curr)
    {

        if(target==0)
        {
            res.add(new ArrayList<>(curr));
            return;
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
              helper(candidates,target-candidates[i],i+1,curr);
              //back track 

              curr.remove(curr.size()-1);
        }
    }
}