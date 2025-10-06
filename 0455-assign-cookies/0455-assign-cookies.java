class Solution {
    int count=0;
    public int findContentChildren(int[] g, int[] s) {
        if(s.length==0){
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);

        int left=0;
        int right=0;
        
        while(left<g.length&&right<s.length)
         {
            if(s[right]>=g[left])
            {
               count++;
               left++;
               right++;
            }

            else 
            {
                right++;
            }
         }

         return count;

}
}