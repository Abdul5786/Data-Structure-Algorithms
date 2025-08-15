class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        int[][] dp = new int[n+1][m+1];
        // LCS DP table fill
        for(int i=1;i<=n;i++)
            for(int j=1;j<=m;j++)
                dp[i][j] = str1.charAt(i-1)==str2.charAt(j-1) ? 1+dp[i-1][j-1] : Math.max(dp[i-1][j],dp[i][j-1]);
        // SCS build
        StringBuilder sb = new StringBuilder();
        int i=n, j=m;
        while(i>0 && j>0){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                sb.append(str1.charAt(i-1)); i--; j--;
            }else if(dp[i-1][j]>dp[i][j-1]){
                sb.append(str1.charAt(i-1)); i--;
            }else{
                sb.append(str2.charAt(j-1)); j--;
            }
        }
        while(i>0) sb.append(str1.charAt(--i));
        while(j>0) sb.append(str2.charAt(--j));
        return sb.reverse().toString();
    }
}