class Solution {
    public int countSubstrings(String s) 
    {
        int count=0, totalCount=0;

        for(int i=0;i<s.length();i++)
        {
            count=1;
            for(int j=i+1;j<s.length();j++)
            {

                if(isPalindrome(i,j,s))
                {
                    count++;
                }
            }

            totalCount +=count;
        }

      return totalCount;  
    }


    public boolean isPalindrome(int left,int right,String str)
    {

        while(left<right)
        {

            if(str.charAt(left)!=str.charAt(right))
            {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}