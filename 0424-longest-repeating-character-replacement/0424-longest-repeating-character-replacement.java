class Solution {
    public int characterReplacement(String s, int k) 
    {
       int start=0;
       HashMap<Character,Integer> map =  new HashMap<>();
       int maxFreq=Integer.MIN_VALUE;
       int res=0;

       for(int end=0;end<s.length();end++)
       {
              char ch = s.charAt(end);
              map.put(ch,map.getOrDefault(ch,0)+1); // {A:2.B:2}
              maxFreq = Math.max(maxFreq,map.get(ch));

              while((end-start+1)-maxFreq>k)
              {

                  char left = s.charAt(start);

                  map.put(left,map.get(left)-1);

                  if(map.get(left)==0)
                  {

                    map.remove(left);
                  }

                  start++;

              }

             res = Math.max(res,end-start+1);  
       }

      return res;

    }
}