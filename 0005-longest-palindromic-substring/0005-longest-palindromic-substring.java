class Solution {
    Boolean[][] memo;

    public String longestPalindrome(String s) {
        int n = s.length();
        memo = new Boolean[n][n];

        int maxLen = 0;
        String res = "";

        for (int left = 0; left < n; left++) {
            for (int right = left; right < n; right++) {

                if (s.charAt(left) == s.charAt(right) && isPalin(s, left + 1, right - 1)) {
                    if (maxLen < right - left + 1) {
                        maxLen = right - left + 1;
                        res = s.substring(left, right + 1); // right+1 since substring is exclusive
                    }
                }
            }
        }

        return res;
    }

    public boolean isPalin(String s, int left, int right) {
        // Base case: single char or empty range is always a palindrome
        if (left > right) return true;

        // Already computed?
        if (memo[left][right] != null) return memo[left][right];

        if (s.charAt(left) != s.charAt(right)) {
            return memo[left][right] = false;
        }

        // if chars match and length is small (like "aa", "aba"), then it's palin
        if (right - left <= 1) return memo[left][right] = true;

        // recursive check
        return memo[left][right] = isPalin(s, left + 1, right - 1);
    }
}
