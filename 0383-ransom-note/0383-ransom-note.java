class Solution {
    public boolean canConstruct(String ransomNote, String magazine) 
    {
        HashMap<Character,Integer> map =   new HashMap<>();

        for(char ch:magazine.toCharArray())
        {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        for(char ch2:ransomNote.toCharArray())
        {
            if(!map.containsKey(ch2) || map.get(ch2)==0)
            {
                return false;
            }

            map.put(ch2,map.get(ch2)-1);
        }

        return true;
    }
}