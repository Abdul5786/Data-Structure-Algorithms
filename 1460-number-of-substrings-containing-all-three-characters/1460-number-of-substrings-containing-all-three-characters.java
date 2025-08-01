class Solution {
    public int numberOfSubstrings(String s) 
    {
        int count[]  = new int[3];
        int res=0 , left=0;
        
        for(int right=0;right<s.length();right++)
        {
            count[s.charAt(right)-'a']++;
            while(count[0]>0&& count[1]>0 && count[2]>0)
            {
                res+=s.length()-right;
                count[s.charAt(left) - 'a']--;
                left++;
            }
        }

        return res;
    }
}