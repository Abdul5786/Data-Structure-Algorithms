class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ll=new ArrayList<>();
        long ncr=1;
        for(int j=0;j<=rowIndex;j++){
            ll.add((int)(ncr));
            ncr=((rowIndex-j)*ncr)/(j+1);
        }
        return ll;
    }
    
}