class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // important for duplicate handling
        helper(nums, 0, new ArrayList<>());
        return res;
    }

    private void helper(int[] nums, int index, List<Integer> subset) {
        res.add(new ArrayList<>(subset)); // add current subset

        for (int i = index; i < nums.length; i++) {
            // Skip duplicates
            if (i > index && nums[i] == nums[i - 1]) continue;

            subset.add(nums[i]);
            helper(nums, i + 1, subset);
            subset.remove(subset.size() - 1); // backtrack
        }
    }
}
