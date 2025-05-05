class Solution {
    List<List<Integer>> ans=  new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) 
    {
        List<Integer> curr = new ArrayList<>();
        helper(k,n,1,curr);
        return ans;
    }

    private void helper(int k,int target,int element,List<Integer> curr)
    {

        if(curr.size()==k)
        {
            if(target==0)
            {
                ans.add(new ArrayList<>(curr));
                return ;
            }
        }

        for(int el=element;el<=9;el++)
        {
            if(el<=target)
            {
                curr.add(el);
                // recursion call

                helper(k,target-el,el+1,curr);
                // back track
                curr.remove(curr.size()-1);
            }
        }
    }
}