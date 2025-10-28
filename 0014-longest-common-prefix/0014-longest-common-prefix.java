class Solution {
    public String longestCommonPrefix(String[] strs) 
    {
        

        Arrays.sort(strs); // [flight,flow,flower]

        String s  = strs[0];
        String t =  strs[strs.length-1];
        int idx=0;


      while(idx<s.length() && idx<t.length())
      {

        if(s.charAt(idx)==t.charAt(idx))

        {
            idx++;
        }

        else
        {
            break;
        }

      }

      return  s.substring(0,idx);

}

}