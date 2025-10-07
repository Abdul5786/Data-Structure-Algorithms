class Solution {
    public boolean checkValidString(String s) 
    {
        int low=0; // represent minimum number of open of braces
        int high=0; // represent minimum number of closing braces

        for(char c : s.toCharArray())
        {

            if(c=='(')
            {
                low++;
                high++;
            }

            else if( c==')')
            {
                 low--;
                 high--;
            }

            else   // *
            {
               low--; // kyuki closing bhi ho sakta h *
               high++; // kyuki open bhi hosakta h *
            }

            if(high<0) return false;

        if(low<0) low=0;

        }

        
        return low==0;
    }
}