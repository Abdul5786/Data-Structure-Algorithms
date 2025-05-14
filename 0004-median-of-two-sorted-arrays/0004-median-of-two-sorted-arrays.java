class Solution {
   public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int n1 = nums1.length;
    int n2 = nums2.length;

    List<Integer> mergedArray = new ArrayList<>();
    int i = 0, j = 0;

    while (i < n1 && j < n2) {
        if (nums1[i] < nums2[j]) {
            mergedArray.add(nums1[i++]);
        } else {
            mergedArray.add(nums2[j++]);
        }
    }

    while (i < n1) {
        mergedArray.add(nums1[i++]);
    }

    while (j < n2) {
        mergedArray.add(nums2[j++]);
    }

    int n = n1 + n2;
    if (n % 2 == 1) {
        return mergedArray.get(n / 2);
    } else {
        return (mergedArray.get(n / 2 - 1) + mergedArray.get(n / 2)) / 2.0;
    }
}

}