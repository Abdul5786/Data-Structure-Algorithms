class Solution {
    public int thirdMax(int[] nums) 
    {
      
       long max1 = Long.MIN_VALUE;
       long max2 = Long.MIN_VALUE;
       long max3 = Long.MIN_VALUE;

        

       for(int i=0;i<nums.length;i++)
       {

          if(nums[i]>max1)
          {

             max3=max2;
             max2=max1;
             max1=nums[i];
          }

          else if(nums[i]>max2 && nums[i]!=max1)
          {

            max3=max2;
            max2=nums[i];
          }

          else if(nums[i]>max3 && nums[i]!=max1 && nums[i]!=max2)
          {
            max3=nums[i];
          }
       }

         return max3==Long.MIN_VALUE ? (int) max1 :(int) max3;
     

    //    Set<Integer> s=new HashSet<>();
    //     for(int i:nums){//for removing duplicate
    //         s.add(i);
    //     }
    //     int k=0;
    //     int[] a=new int[s.size()];
    //     for(int i:s){//convert back to array
    //         a[k]=i;
    //         k++;
    //     }
    //     Arrays.sort(a);//sorting the array
    //     if(a.length<3) return a[a.length-1];//if length is less then 3 then return max element 
    //     return a[a.length-3];//return 3rd max element

         
    }
}