class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) 
    {
          // Sort the array to handle duplicates
        Arrays.sort(nums);
        helper(nums, new ArrayList<>(), new boolean[nums.length]);
        return ans;    
    }

    private void helper(int[] nums, List<Integer> used, boolean[] usedFlags) {
        // Base case: if permutation size equals array length
        if (used.size() == nums.length) {
            ans.add(new ArrayList<>(used));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // Skip duplicates: if current element is same as previous and previous is not used
            if (i > 0 && nums[i] == nums[i - 1] && !usedFlags[i - 1]) {
                continue;
            }
            // Only use if the element at this index is not already used
            if (!usedFlags[i]) {
                used.add(nums[i]);          // Add element
                usedFlags[i] = true;        // Mark as used
                helper(nums, used, usedFlags); // Recursive call
                used.remove(used.size() - 1); // Backtrack
                usedFlags[i] = false;       // Unmark as used
            }
        }
    }
}