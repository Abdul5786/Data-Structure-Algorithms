class Solution {
    //memoization approach
    public boolean solve(String s1, String s2, String s3, int i, int j, Boolean[][] dp){
        //if all the indexes become out of boud together means we can create s3 by interleaving s1 and s2, so return true
        if(i == s1.length() && j == s2.length() && i+j == s3.length()) return true;
        //if any of the string from s1 or s2 is empty and we can get all characters of s3 from one string only then return false, bcz we should create s3 by using both s1's and s2's characters
        if(i+j >= s3.length()) return false;
        if(dp[i][j] != null) return dp[i][j];
        boolean result = false; // we will store the result
        //if char at i in s1 is equal to the s3's character means we got that char from s1 so move i to next index,
        //we should also take care of index out of bound
        if(i < s1.length() && s1.charAt(i) == s3.charAt(i+j)) result = solve(s1, s2, s3, i+1, j, dp);
        //in between only if our result becomes true then we won't check next string
        if(result == true) return dp[i][j] = result;
// else it means character at j in s2 is equal to the s3's character means we got that char from s2 so move j to next index,
       else if(j < s2.length() && s2.charAt(j) == s3.charAt(i+j)) result = solve(s1, s2, s3, i, j+1, dp);

       return dp[i][j] = result;
    }
    //main method
    public boolean isInterleave(String s1, String s2, String s3) {
        //if s3.length() > s.length() + s3.length(), means we cannot create s3 from characters of s1 and s2, bcz s3 is having more characters than s1 and s2
        if(s3.length() > s1.length() + s2.length()) return false;
        Boolean[][] dp = new Boolean[s1.length()+1][s2.length()+1];
        //we will start traversing all 3 strings from 0th index
        //s3's index would be i+j, bcz either we will take char from s1 or s2, to match with s3
        return solve(s1, s2, s3, 0, 0, dp);
    }
}