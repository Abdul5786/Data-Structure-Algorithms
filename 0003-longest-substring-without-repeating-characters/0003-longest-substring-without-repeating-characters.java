class Solution {
    public int lengthOfLongestSubstring(String s) 
    {
       Set<Character> window = new HashSet<>();
       int right=0 , left=0; // pointers required to shifting
       // check if already exist 
       
       int maxLen=0;
       while(right<s.length())
       {
        
        if(!window.contains(s.charAt(right)))
        {
            window.add(s.charAt(right));
            maxLen = Math.max(maxLen,right-left+1);
            right++;
        }
        
        else {
            window.remove(s.charAt(left));
            left++;
        }
       }
       
       return maxLen;
    }
}