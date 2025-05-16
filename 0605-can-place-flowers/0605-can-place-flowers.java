class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0; // Counter to track how many flowers we can plant

        for (int i = 0; i < flowerbed.length; i++) {
            // Check if the current plot is empty
            if (flowerbed[i] == 0) {
                // Check the left and right neighbors
                boolean emptyLeft = (i == 0) || (flowerbed[i - 1] == 0); // True if left is empty or it's the first plot
                boolean emptyRight = (i == flowerbed.length - 1) || (flowerbed[i + 1] == 0); // True if right is empty or it's the last plot

                if (emptyLeft && emptyRight) {
                    flowerbed[i] = 1; // Plant a flower here
                    count++; // Increment the counter
                }
            }

            // If we've already planted enough flowers, return true
            if (count >= n) {
                return true;
            }
        }

        // If we finish the loop and haven't planted enough flowers, return false
        return count >= n;
    }
}