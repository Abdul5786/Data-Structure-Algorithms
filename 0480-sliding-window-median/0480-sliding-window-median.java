class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] ans = new double[n - k + 1];
        List<Integer> window = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            window.add(nums[i]);
        }

        Collections.sort(window);
        ans[0] = getMedian (window, k);

        for (int i = k; i < n; i++) {
            int out = nums[i - k];
            int idx = binarySearch(window, out);
            window.remove(idx);
            int in = nums[i];
            int insertIdx = binarySearch(window, in);

            if (insertIdx < 0) {
                insertIdx = -insertIdx - 1;
            }

            window.add(insertIdx, in);
            ans[i - k + 1] = getMedian(window, k);
        }
        return ans;  
    }

    private double getMedian(List<Integer> window, int k) {
        if (k % 2 == 1) {
           return window.get(k / 2);
        } else {
            return ((double) window.get(k/2 - 1) + window.get(k / 2)) / 2.0;
        }
    }

    private int binarySearch(List<Integer> list, int target) {
        int l = 0, r = list.size() - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int midVal = list.get(mid);
            if (midVal == target) {
                return mid;
            } else if (midVal < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -l -1;
    }
}