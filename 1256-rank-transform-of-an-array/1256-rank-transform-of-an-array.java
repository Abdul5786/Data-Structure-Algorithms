class Solution {
    public int[] arrayRankTransform(int[] arr) 
    {
        // step 1 copy array and sort

        int sorted[]= arr.clone();

        Arrays.sort(sorted);

        // step 2 : map bnate hain element 

       Map<Integer,Integer> rankMap = new HashMap<>();

       int rank=1;
       for(int num:sorted)
       {
            if(!rankMap.containsKey(num))
            {
                rankMap.put(num,rank++);
            }
       }

      // step 3 

       int res[]  = new int[arr.length];

       for(int i=0;i<arr.length;i++)
       {
          res[i]= rankMap.get(arr[i]);
       }

       return res;
    }
}