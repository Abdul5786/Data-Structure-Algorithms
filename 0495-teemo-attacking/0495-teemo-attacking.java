class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) return 0;

        int totalDuration = 0;

        for (int i = 0; i < timeSeries.length - 1; i++) {
            // Add the smaller of the two: duration or gap between attacks
            totalDuration += Math.min(duration, timeSeries[i + 1] - timeSeries[i]);
        }

        // Add the duration for the last attack
        totalDuration += duration;

        return totalDuration;
    }
}