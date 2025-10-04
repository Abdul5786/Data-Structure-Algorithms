class Solution {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) 
    {
         Arrays.sort(candidates);
        combinationSum(candidates,0,target,new ArrayList<>());
        return res;
    }


    public void combinationSum(int candidates[],int start , int target,List<Integer> ans)
    {

        if(target==0)
        {
           res.add(new ArrayList<>(ans));
           return;
        }

        for(int i=start;i<candidates.length;i++)
        {

           if(i>start && candidates[i]==candidates[i-1]) continue; // skip 
          
            
            if(candidates[i]>target) break;

            ans.add(candidates[i]);
            combinationSum(candidates,i+1,target-candidates[i],ans);

            // backtrack

            ans.remove(ans.size()-1);

        }
    }
}