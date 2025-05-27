public class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        if (t.length() > n) {
            return "";
        }
        Map<Character, Integer> mp = new HashMap<>();
        // Store frequencies of t
        for (char ch : t.toCharArray()) {
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }
        int requiredCount = t.length();
        int i = 0, j = 0;
        int minWindowSize = Integer.MAX_VALUE;
        int start_i = 0;
        // Sliding window
        while (j < n) {
            char ch = s.charAt(j);
            if (mp.containsKey(ch) && mp.get(ch) > 0) {
                requiredCount--;
            }
           
            mp.put(ch, mp.getOrDefault(ch, 0) - 1);

            while (requiredCount == 0) {
                int currWindowSize = j - i + 1;
                if (minWindowSize > currWindowSize) {
                    minWindowSize = currWindowSize;
                    start_i = i;
                }
                char startChar = s.charAt(i);
                mp.put(startChar, mp.getOrDefault(startChar, 0) + 1);
                if (mp.containsKey(startChar) && mp.get(startChar) > 0) {
                    requiredCount++;
                }
                i++;
            }
            j++;
        }
        return minWindowSize == Integer.MAX_VALUE ? "" : s.substring(start_i, start_i + minWindowSize);
    }
}