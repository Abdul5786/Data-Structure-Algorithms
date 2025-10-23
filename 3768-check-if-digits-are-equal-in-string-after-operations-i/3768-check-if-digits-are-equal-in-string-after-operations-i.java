class Solution {
    public boolean hasSameDigits(String s) 
    {
       
         if(s==null || s.length()<2)  return false;

        // first i need to convert thi into int array to perform arthmetic operations

        int curr[] = new int[s.length()]; 

        for(int i=0;i<s.length();i++)
        {
            curr[i] = s.charAt(i)-'0';
        }


        while(curr.length>2)
        {

            int next[] = new int[curr.length-1]; // it will  hold reduced array valuse

            for(int i=0;i<curr.length-1;i++)
            {
                next[i] = (curr[i]+curr[i+1])%10;

            }

            curr= next; // now curr will point to next 
        }

        return curr[0]==curr[1] && curr.length==2;
    }
}