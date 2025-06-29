class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;
}
class Solution {
    TrieNode root = new TrieNode();
    void insert(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if(node.children[idx] == null) node.children[idx] = new TrieNode();
            node = node.children[idx];
        }
        node.isEnd = true;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        for(String word : wordDict) insert(word);
        Boolean[] dp = new Boolean[s.length() + 1];
        return dfs(s, 0, dp);
    }
    boolean dfs(String s, int start, Boolean[] dp) {
        if(start == s.length()) return true;
        if(dp[start] != null) return dp[start];
        TrieNode node = root;
        for(int i = start; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if(node.children[idx] == null) break;
            node = node.children[idx];
            if(node.isEnd && dfs(s, i + 1, dp)) return dp[start] = true;
        }
        return dp[start] = false;
    }
}