class Solution {
    List<List<Integer>>  res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) 
    {
       helper(1,n,k,new ArrayList<>());
       return res;
    }


    public void  helper(int start, int n, int k , List<Integer> ans)
    {
        // base case 

        if(ans.size()==k)
        {
             res.add(new ArrayList<>(ans));
             return ;
        }

        for(int i=start;i<=n;i++)
        {
            ans.add(i);
            helper(i+1,n,k,ans);
             // backtrack
            ans.remove(ans.size()-1);
        }
    }
}