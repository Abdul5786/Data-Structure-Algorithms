class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) 
    {
        int n1 = nums1.length;
        int n2 = nums2.length;

        int index1=0 , index2=0;

       List<Integer> res = new ArrayList<>();

        while(index1<n1 && index2<n2)
        {

            if(nums1[index1]<nums2[index2])
            {
               res.add(nums1[index1]);
               index1++;
            }

            else 
            {
                res.add(nums2[index2]);
                index2++;
            }
        }

        while(index1<n1)
        {
            res.add(nums1[index1++]);
        }

        while (index2<n2)
        {
           
           res.add(nums2[index2++]);
        }

        int totalLength = n1+n2;

        if(totalLength%2==1) // --> odd
        {
           return res.get(totalLength/2);
        }

        else
        {
            return (res.get(totalLength / 2 - 1) + res.get(totalLength / 2)) / 2.0;
        }
    }
}