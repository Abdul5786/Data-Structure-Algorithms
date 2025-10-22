class Solution {
    public String longestCommonPrefix(String[] strs) 
    {
        // sorted -> [flight,flow,flower]
          
        // after sorting if i get common this will be common in all ex ab abc abcd 


        Arrays.sort(strs);

        int idx =0;

        String s1 = strs[0]; // starting string

        String s2 = strs[strs.length-1];

        while(idx < s1.length() && idx <s2.length())
        {
            if(s1.charAt(idx) == s2.charAt(idx))
            {
                idx++;
            }
            else 
            {
                break;
            }
        }


        return s1.substring(0,idx);

    }
}