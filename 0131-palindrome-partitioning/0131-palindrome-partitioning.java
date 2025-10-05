class Solution {
    List<List<String>> res   = new ArrayList<>();
    public List<List<String>> partition(String s) 
    {
        helper(s,0,new ArrayList<>());
        return res;
    }

    public void helper(String s, int partIndex,List<String> ans)
    {
        // base case 

        if(partIndex==s.length())
        {
            res.add(new ArrayList<>(ans));
            return;
        }
     
        for(int i=partIndex;i<s.length();i++)
        {
            if(isPalindrome(s,partIndex,i))
            {
                ans.add(s.substring(partIndex,i+1));
                helper(s,i+1,ans);
                //bactrack
                ans.remove(ans.size()-1);
            }
        }

    }

    // palindrome check

    public boolean isPalindrome(String s,int start,int end)
    {
         while(start<=end)
         {
            if(s.charAt(start)!=s.charAt(end))
            {
                return false;
            }
            start++;
            end--;
         }

         return true;
    }
}