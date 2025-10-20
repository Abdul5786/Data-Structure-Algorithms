class Solution {
    public List<List<String>> groupAnagrams(String[] strs) 
    {
       HashMap<String,List<String>> map =  new HashMap<>();


       for(String  ch: strs)
       {
           
           char[] charArray  = ch.toCharArray();
           Arrays.sort(charArray);
           String sortedString  = new String(charArray);
          
          if(!map.containsKey(sortedString))
          {
               map.put(sortedString,new ArrayList<>());             
          }

          map.get(sortedString).add(ch);

       }

       return new ArrayList<>(map.values());
    }
}