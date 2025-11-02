class Solution {
    public boolean wordPattern(String pattern, String s) 
    {

       
        String words[] = s.trim().split("\\s+");
          if (pattern.length() != words.length) return false;
        HashMap<Character,String> map = new HashMap<>();

        for(int i =0 ; i<pattern.length();i++)
        {
            char ch = pattern.charAt(i);  // ->  a
            String word = words[i];  // -> dog

            if(map.containsKey(ch))  // if a already exist 
            {
               if(!map.get(ch).equals(word))
               {
                   return false;
               }
            }

            else
            {
               if(map.containsValue(word))
               {
                   return false; // dog mapped
               }

               map.put(ch,word);
            }
        }

        return true;
    }
}