class Solution {
    public int lengthOfLongestSubstring(String s) 
    {
        HashSet<Character>  set  = new HashSet<>();

        int right=0 , left=0;

        int maxLen = Integer.MIN_VALUE;


        while(right<s.length())
        {

           if(!set.contains(s.charAt(right)))
           {
                set.add(s.charAt(right));
                maxLen = Math.max(maxLen, right-left+1);
                right++;
           }
           else
           {             
                 set.remove(s.charAt(left));
                 left++; // window shrink
           }

        }

        return (maxLen==Integer.MIN_VALUE) ? 0 : maxLen;
    }
}