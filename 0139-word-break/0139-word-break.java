import java.util.*;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict); // Dictionary ko Set mein convert karo
        Boolean[] memo = new Boolean[s.length()]; // Memoization array
        return helper(s, 0, dict, memo); // Recursive helper function
    }

    private boolean helper(String s, int start, Set<String> dict, Boolean[] memo) {
        if (start == s.length()) return true; // Base case: string break ho chuki hai

        if (memo[start] != null) return memo[start]; // Memoization check

        for (int end = start + 1; end <= s.length(); end++) {
            String substring = s.substring(start, end); // Substring extract karo
            if (dict.contains(substring) && helper(s, end, dict, memo)) {
                memo[start] = true; // Result store karo
                return true;
            }
        }
        memo[start] = false; // Agar substring nahi mili toh false mark karo
        return false;
    }
}