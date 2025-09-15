class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // prefix sum 0 ek baar aata hai initially
        int sum = 0, count = 0;
        for (int num : nums) {
            sum += num;
            count += map.getOrDefault(sum - goal, 0); // kitni baar (sum-goal) aaya hai
            map.put(sum, map.getOrDefault(sum, 0) + 1); // current sum update karo
        }
        return count;
    }
}