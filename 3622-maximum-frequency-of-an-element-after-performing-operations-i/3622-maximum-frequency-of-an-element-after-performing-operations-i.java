class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int n=0;
        for(int num :nums) n=Math.max(n,num);
        n++;

        int[] count=new int [n];
        for(int num:nums) count[num]++;

        int total=0;
        for(int i=0;i<Math.min(k,n);i++)
        total+=count[i];

        int result=0;
        for(int i=0;i<n;i++) {
            if(i+k<n) total+=count[i+k];
            result=Math.max(result,count[i] + Math.min(numOperations,total-count[i]));
            if(i-k>=0)
            total-=count[i-k];
        }
        return result ;
    }
}