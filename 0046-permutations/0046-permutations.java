class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) 
    {
     helper(nums, new ArrayList<>());
     return ans;
    }

    private void helper(int[] arr, List<Integer> used) {
    if (used.size() == arr.length) {  // Base case
        ans.add(new ArrayList<>(used));
        return;
    }

    for (int i = 0; i < arr.length; i++) {
        if (!used.contains(arr[i])) {  // If condition
            used.add(arr[i]);          // Add element
            helper(arr, used);         // Recursive call
            used.remove(used.size() - 1); // Backtrack
        }

    }

    }

}

    
