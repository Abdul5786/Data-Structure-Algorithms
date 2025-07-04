class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        int[] pFreq = new int[26];
        int[] sFreq = new int[26];

        for (char ch : p.toCharArray()) {
            pFreq[ch - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            sFreq[s.charAt(i) - 'a']++;
            

            // shrink  window
            if (i >= p.length()) {
                sFreq[s.charAt(i - p.length()) - 'a']--;
            }

            if (Arrays.equals(pFreq, sFreq)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }
}
