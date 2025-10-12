class Solution 
{
    public int totalFruit(int[] fruits) 
    {
        int left=0;
        int max =Integer.MIN_VALUE;

       HashMap<Integer,Integer> map =  new HashMap<>();
       
       for(int right=0;right<fruits.length;right++)
       {
           map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);  // [1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2]

           while(map.size()>2)
           {
               int leftFruits =  fruits[left];
               map.put(leftFruits,map.get(leftFruits)-1);
               if(map.get(leftFruits)==0)
               {
                  map.remove(leftFruits); // remove 
               }

               left++;  
           }

           max  = Math.max(right-left+1,max);
       }

       return max;
    }
}