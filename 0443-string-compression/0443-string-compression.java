class Solution {

   

    public int compress(char[] chars) 
    {
         int i=0;
         int index=0;
         int n =  chars.length;
        while(i<n)
        {

            char currentChar = chars[i];
            int count=0;

            while(i<n && currentChar==chars[i])
            {

                i++;
                count++;
            }


             chars[index++] = currentChar;

             if(count>1)
             {

                for(char ch : Integer.toString(count).toCharArray())
                {
                     
                     chars[index++] = ch;
                }
             }

           
        }

          return index;
    }
}