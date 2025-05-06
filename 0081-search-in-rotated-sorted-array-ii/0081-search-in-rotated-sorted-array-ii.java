class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        
        while (l <= h) {
            int mid = l + (h - l) / 2;
            
            if (nums[mid] == target) {
                return true;
            }
            
            // Skip duplicates
            if (nums[l] == nums[mid] && nums[mid] == nums[h]) {
                l++;
                h--;
            } else if (nums[l] <= nums[mid]) { // Left part is sorted
                if (nums[l] <= target && nums[mid] >= target) {
                    h = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else { // Right part is sorted
                if (nums[mid] < target && nums[h] >= target) {
                    l = mid + 1;
                } else {
                    h = mid - 1;
                }
            }
        }
        
        return false;
    }
}