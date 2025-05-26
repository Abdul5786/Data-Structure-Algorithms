class Solution {
    public int lengthOfLongestSubstring(String s) 
    {
        int left=0 , maxLen=0;

       HashMap<Character,Integer> seen =  new HashMap<>();

        for(int right=0;right<s.length();right++)
        {
              char ch  =  s.charAt(right);

              if(seen.containsKey(ch)&& seen.get(ch)>=left)
              {
                 left= seen.get(ch)+1;
              }
              seen.put(ch,right);
              maxLen= Math.max(maxLen,right-left+1);
        }
        return maxLen;
    }
}