class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] arr = new int[1001];
        for(int i : nums1){
            arr[i] = 1;
        }
        int count = 0;
        for(int i : nums2){
            if(arr[i] == 1){
                arr[i] = 2;
                count++;
            }
        }
        int[] result = new int[count];
        int j=0;
        for(int i : nums2){
            if(arr[i] == 2){
                arr[i] = 1;
                result[j] = i;
                j++;
            }
        }
        return result;
    }
    }
