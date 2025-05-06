class Solution {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        helper(s, 0, new ArrayList<>());
        return res;
    }

    public boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public void helper(String s, int partIndex, List<String> sublist) {
        // Base case
        if (partIndex == s.length()) {
            res.add(new ArrayList<>(sublist));
            return;
        }

        for (int i = partIndex; i < s.length(); i++) {
            // Check palindrome
            if (isPalindrome(s, partIndex, i)) {
                sublist.add(s.substring(partIndex, i + 1));
                helper(s, i + 1, sublist);
                sublist.remove(sublist.size() - 1);
            }
        }
    }
}