public class Solution {
     List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtrack("", 0, 0, n);
        return result;
    }

    private void backtrack( String current, int open, int close, int max) {
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }
        if (open < max) {
            backtrack(current + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(current + ")", open, close + 1, max);
        }
    }
}