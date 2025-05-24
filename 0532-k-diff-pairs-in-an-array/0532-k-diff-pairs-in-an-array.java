class Solution {
    public int findPairs(int[] nums, int k) 
    {
    //     HashMap<Integer,Integer> map =  new HashMap<>();

    //     for(int num:nums)
    //     {
    //         map.put(num,map.getOrDefault(num,0)+1);  //  created frequency array
    //     }

    //     int count=0;

    //     for(int key:map.keySet())
    //     {
    //        if(k>0 && map.containsKey(key+k))
    //        {
    //         count++;
    //        }

    //        else if(k==0 && map.get(key)>1)
    //        {

    //         count++;
    //        }
    //     }

    //     return count;
    // }
     
      int count = 0;
        int left = 0;
        int right = 1;

        Arrays.sort(nums);

        while (right < nums.length) {
            int differ = nums[right] - nums[left];

            if (differ == k) {
                count++;
                left++;
                right++;

                // skip duplicates
                while (right < nums.length && nums[right] == nums[right - 1]) {
                    right++;
                }
            } else if (differ < k) {
                right++;
            } else {
                left++;
            }

            if (left == right) {
                right++;
            }
        }

        return count;
    }


}