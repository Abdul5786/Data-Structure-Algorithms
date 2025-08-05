class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        
        List<Integer> result = new ArrayList<>();
        int pFreq[] = new int[26];
        int sFreq[] = new int[26];
        if (s.length() < p.length()) return result;

        for(char ch: p.toCharArray())
        {
          pFreq[ch-'a']++;
        }

        for(int i=0;i<s.length();i++)
        {
            sFreq[s.charAt(i)-'a']++;

            if(i>=p.length())
            {
                // shrink the window means decrease frequeny 

                sFreq[s.charAt(i-p.length())-'a']--;
            }

            if(Arrays.equals(sFreq,pFreq))
                {
                    result.add(i - p.length() + 1);
                }
        }
        
        return result;
    }
}


       