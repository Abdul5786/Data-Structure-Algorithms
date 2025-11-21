class Solution {
    public int countPalindromicSubsequence(String s) {
        if (s.length() <= 2)
            return 0;
        HashSet<Character> chars = new HashSet<>();
        for (char c : s.toCharArray())  
            chars.add(c);
        int res = 0;
        for (char c : chars){
            int left = s.indexOf(c);
            int right = s.lastIndexOf(c);
            if (left != right){
                HashSet<Character> mid = new HashSet<>();
                for (int i = left + 1; i < right; i++){
                    mid.add(s.charAt(i));
                }
                res += mid.size();
            }
        }
        return res;
    }
}