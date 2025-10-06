class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        
        // Sabko 1-1 candy de do
        for (int i = 0; i < n; i++) {
            candies[i] = 1;
        }

        // Left to right: agar right wala zyada hai toh ek candy extra do
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Right to left: agar left wala zyada hai toh max le lo
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // Total candies ka sum nikal lo
        int total = 0;
        for (int c : candies) {
            total += c;
        }
        return total;
    }
}