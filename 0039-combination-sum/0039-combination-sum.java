class Solution {

    List<List<Integer>> res =  new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) 
    {
        
        combinationsSum(candidates,0,target,new ArrayList<>());
        return res;
    }


    public void combinationsSum(int candidates[], int index, int target, List<Integer> ans)
    {

        if(index==candidates.length)
        {
            if(target==0)
            {
                res.add(new ArrayList<>(ans));
            }
            return;
        }

        // pick  format will remain same 

        if(candidates[index]<=target) // this cindition depencds on requirement vairable changeable
        {
            ans.add(candidates[index]);
            combinationsSum(candidates,index,target-candidates[index],ans);
            // backtrack
            ans.remove(ans.size()-1);
        }

        // no pick   means skip 2 see for next value

        combinationsSum(candidates,index+1,target,ans);
    }
}