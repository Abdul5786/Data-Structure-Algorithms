class Solution {
    public boolean hasSameDigits(String s) 
    {
        if (s == null || s.length() < 2) return false; // no two digits to compare

        // convert string to int array of digits
        int n = s.length();
        int[] curr = new int[n];
        for (int i = 0; i < n; i++) curr[i] = s.charAt(i) - '0';

        // reduce until length == 2
        while (curr.length > 2) {
            int[] next = new int[curr.length - 1];
            for (int i = 0; i < curr.length - 1; i++) {
                next[i] = (curr[i] + curr[i + 1]) % 10;
            }
            curr = next;
        }

        return curr.length == 2 && curr[0] == curr[1];
    }
}