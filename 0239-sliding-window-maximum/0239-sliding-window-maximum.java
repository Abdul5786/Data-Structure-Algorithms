class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // Remove all smaller elements from the back
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.removeLast();
            }

            dq.addLast(i);

            // Remove elements out of the current window
            while (dq.peekFirst() <= i - k) {
                dq.removeFirst();
            }

            // Add the max element to the result once we have at least k elements
            if (i >= k - 1) {
                ans[i - k + 1] = nums[dq.peekFirst()];
            }
        }

        return ans;
    }
}
