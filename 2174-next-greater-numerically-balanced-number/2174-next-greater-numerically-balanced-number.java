class Solution 
{
    public int nextBeautifulNumber(int n) 
    {
       // we will iterate till i will get next smallest balanced Number
       for(int i = n+1;i<Integer.MAX_VALUE;i++)
       {     
           if(isBalanced(i))
           {
              return i;
           }
       }
       return -1; 
    }

    public boolean isBalanced(int number)
    {
       int frequencyCount [] = new int[10]; 
      while(number>0)
      {

        // number can be 0 to 9

          int digit = number%10;

          if(digit==0) return false;
           frequencyCount[digit]++;
           number/=10;
      }

      for(int i=1;i<=9;i++)
      {
          if(frequencyCount[i]>0 && frequencyCount[i]!=i)
          {
             return false;
          }
      }

      return true;

    }
}