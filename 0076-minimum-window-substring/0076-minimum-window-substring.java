public class Solution {
    public String minWindow(String s, String t) {
       if (s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> mp = new HashMap<>();
        for (char ch : t.toCharArray()) {
            mp.put(ch, mp.getOrDefault(ch, 0) + 1); // Insert t's characters with frequency
        }

        int requiredCount = t.length();
        int minWindowSize = Integer.MAX_VALUE;
        int start_i = 0;
        int left = 0, right = 0;

        while (right < s.length()) {
            char ch = s.charAt(right);

            if (mp.containsKey(ch) && mp.get(ch) > 0) {
                requiredCount--;
            }

            mp.put(ch, mp.getOrDefault(ch, 0) - 1);

            while (requiredCount == 0) {
                int currentWindowSize = right - left + 1;
                if (currentWindowSize < minWindowSize) {
                    minWindowSize = currentWindowSize;
                    start_i = left;
                }

                char startChar = s.charAt(left);
                mp.put(startChar, mp.getOrDefault(startChar, 0) + 1);

                if (mp.containsKey(startChar) && mp.get(startChar) > 0) {
                    requiredCount++;
                }

                left++;
            }

            right++;
        }

        return minWindowSize == Integer.MAX_VALUE ? "" : s.substring(start_i, start_i + minWindowSize);
    }
}
