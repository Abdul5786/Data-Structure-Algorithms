class Solution {
    public List<Integer> findAnagrams(String s, String p) 
    {

       // first create freqquwncy arrays to store frqunecy of chars

     List<Integer> list = new ArrayList<>();
      int  freqS[]  =  new int [26];
      int freqP[]   =  new int [26];


      for(char ch:p.toCharArray())
      {
          freqP[ch-'a']++;
      }


      for(int i=0;i<s.length();i++)
      {
          freqS[s.charAt(i)-'a']++;

          if(i>=p.length())
          {
             freqS[s.charAt(i-p.length())-'a']--;
          }

          if(Arrays.equals(freqS,freqP))
          {
            list.add(i-p.length()+1);
          }
      }

      return list;


        
    }
}