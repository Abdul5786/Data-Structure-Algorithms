class Solution {
    

    List<List<Integer>> res= new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) 
    {
         findSubsets(nums,0,new ArrayList<>());  
         return res; 
    }


    private void findSubsets(int array[],int index,List<Integer> sublist)
    {

        if(index==array.length)
        {
            res.add(new ArrayList<>(sublist));
            return;
        }


        // pick 

        sublist.add(array[index]);
        findSubsets(array,index+1,sublist);
        // back track
        sublist.remove(sublist.size()-1);
        // no pick
        findSubsets(array,index+1,sublist);


    }
}