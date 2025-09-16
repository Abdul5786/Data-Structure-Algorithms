class Solution {
    public boolean isIsomorphic(String s, String t)
     {
        HashMap<Character,Character> sMap =  new HashMap<>();
        HashMap<Character,Character> tMap =  new HashMap<>();
        
        for(int i=0;i<s.length();i++)
        {
            char s1 = s.charAt(i);
            
            char s2 = t.charAt(i);

            if(!sMap.containsKey(s1))
            {
                sMap.put(s1,s2);
            }
            
            if(!tMap.containsKey(s2))
            {
                tMap.put(s2,s1);
            }

            if(sMap.get(s1)!=s2 || tMap.get(s2)!=s1)
            {
                return false;
            }
        }

        return true;

     }
}