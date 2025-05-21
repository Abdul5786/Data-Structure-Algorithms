class Solution {
    public int[] findErrorNums(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        int duplicate = -1;
        for(int i=0;i<nums.length;i++){
            if(!hs.contains(nums[i])){
                hs.add(nums[i]);
            }else{
                duplicate = nums[i];
            }
        }
        int missing = -1;
        for(int i=1;i<=nums.length;i++){
            if(!hs.contains(i)){
                missing = i;
            }
        }
        int ans[] = {duplicate, missing};
        return ans;
    }
}