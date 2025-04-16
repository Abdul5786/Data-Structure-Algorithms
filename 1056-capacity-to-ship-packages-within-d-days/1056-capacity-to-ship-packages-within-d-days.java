class Solution {
    public int shipWithinDays(int[] weights, int days) 
    {
          int max = 0; 
        int sum = 0;

        // Calculate max and total sum of weights
        for (int val : weights) {
            sum += val;
            max = Math.max(max, val);
        }

        int lo = max, hi = sum, res = 0;

        // Binary search for minimum capacity
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (isPossible(weights, mid, days)) {
                res = mid;
                hi = mid - 1; // try for smaller capacity
            } else {
                lo = mid + 1; // need more capacity
            }
        }

        return res;
    }

   // Check if we can ship within given days using given capacity (mid)
    public static boolean isPossible(int[] wt, int mid, int days) {
        int d = 1; // at least 1 day
        int sum = 0;

        for (int i = 0; i < wt.length; i++) {
            sum += wt[i];

            if (sum > mid) {
                d++;           // increase day count
                sum = wt[i];   // start new day with current weight
            }
        }

        return d <= days;
    }


}


    