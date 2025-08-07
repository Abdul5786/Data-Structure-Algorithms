class Solution {
    public int maxCoins(int[] nums) 
    {
        // Agar array khali hai, to 0 coins
        if (nums == null || nums.length == 0) return 0;

        // Naya array banaya, start aur end pe 1 add kiya (boundary balloons)
        // Example: nums=[3,1,5,8] -> arr=[1,3,1,5,8,1]
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = arr[n + 1] = 1; // Dono taraf 1 daal do
        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i]; // Original array copy kiya
        }

        // DP table banaya, size n+2 kyunki 1s add kiye
        int[][] dp = new int[n + 2][n + 2];
        // Sab -1 se fill kiya, matlab abhi kuch calculate nahi hua
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Helper call kiya, i=1 se j=n tak (yaha j=4)
        return helper(arr, 1, n, dp);
        
    }

    // Yeh function max coins nikalega i se j tak ke balloons ke liye
    public static int helper(int[] arr, int i, int j, int[][] dp) {
        // Base case: agar i > j, to koi balloon nahi, 0 coins
        if (i > j) {
            return 0; // Khali range, kuch nahi karna
        }

        // Agar dp[i][j] pehle se calculated hai
        if (dp[i][j] != -1) {
            return dp[i][j]; // Direct saved value le lo
        }

        // Max coins rakho, shuru mein chhota number
        int maxCoins = Integer.MIN_VALUE;

        // Har k ko last balloon manke try karo (i se j tak)
        // Yaha k <= j, MCM ke j-1 se alag, kyunki k last balloon hai
        for (int k = i; k <= j; k++) {
            // Left part: i se k-1 tak ke balloons burst karo
            int left = helper(arr, i, k - 1, dp);

            // Right part: k+1 se j tak ke balloons burst karo
            int right = helper(arr, k + 1, j, dp);

            // k last burst hota hai, to coins = arr[i-1] * arr[k] * arr[j+1]
            // i-1 aur j+1 wale balloons abhi bache hain
            // Example: i=1, k=1, j=4, to 1*3*1
            int cost = arr[i - 1] * arr[k] * arr[j + 1];

            // Total: left + right + current cost
            int total = left + right + cost;

            // Max coins update karo
            maxCoins = Math.max(maxCoins, total);
        }

        // Answer dp mein save karo
        dp[i][j] = maxCoins;
        return maxCoins;
}

}