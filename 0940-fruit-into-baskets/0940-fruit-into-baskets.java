class Solution {
    public int totalFruit(int[] fruits) 
    {
       int max=0 , start=0;

       Map<Integer,Integer> basket =  new HashMap<>();

       for(int end=0;end<fruits.length;end++)
       {
             int  fruit =     fruits[end];
            basket.put(fruit,basket.getOrDefault(fruit,0)+1);

            while(basket.size()>2)
            {
              int leftFruits =   fruits[start];
              basket.put(leftFruits,basket.get(leftFruits)-1);
              if(basket.get(leftFruits)==0)
              {
                 basket.remove(leftFruits);
              }

                start++;
            }
          
          max= Math.max(max,end-start+1);
       }

       return max;
    }
}