class Solution {
    public int numSub(String s) {
        final int MOD = 1_000_000_007;
        long count1 = 0;  // current streak of '1's
        long ans = 0;     // total substrings

        for (char c : s.toCharArray()) {
            if (c == '1') {
                count1++;          // extend streak
                ans = (ans + count1) % MOD; // add new substrings
            } else {
                count1 = 0;        // reset streak
            }
        }

        return (int) ans;
    }
}