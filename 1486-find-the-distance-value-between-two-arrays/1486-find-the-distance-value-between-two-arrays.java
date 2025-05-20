import java.util.Arrays;

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        // Step 1: Sort arr2 for binary search
        Arrays.sort(arr2);
        int count = 0;

        // Step 2: Iterate through arr1
        for (int num : arr1) {
            // Step 3: Check if no element in arr2 satisfies |arr1[i] - arr2[j]| <= d
            if (isValid(num, arr2, d)) {
                count++;
            }
        }

        return count;
    }

    private boolean isValid(int num, int[] arr2, int d) {
        // Binary search for elements within the range [num - d, num + d]
        int low = num - d;
        int high = num + d;

        int left = Arrays.binarySearch(arr2, low);
        int right = Arrays.binarySearch(arr2, high);

        // Binary search returns negative if no exact match; adjust indices
        left = (left < 0) ? -left - 1 : left;
        right = (right < 0) ? -right - 1 : right;

        // Check if there's any element in the range
        return (left >= arr2.length || arr2[left] > high);
    }
}