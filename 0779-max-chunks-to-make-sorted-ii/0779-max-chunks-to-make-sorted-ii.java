class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;

        int[] leftMax = new int[n];
        int[] rightMin = new int[n + 1]; // n+1 to safely access rightMin[i+1]

        // Step 1: Fill leftMax array
        leftMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }

        // Step 2: Fill rightMin array from the end
        rightMin[n] = Integer.MAX_VALUE; // dummy value at end
        for (int i = n - 1; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], arr[i]);
        }

        // Step 3: Count valid chunks
        int chunks = 0;
        for (int i = 0; i < n; i++) {
            if (leftMax[i] <= rightMin[i + 1]) {
                chunks++;
            }
        }

        return chunks;
    }
}
