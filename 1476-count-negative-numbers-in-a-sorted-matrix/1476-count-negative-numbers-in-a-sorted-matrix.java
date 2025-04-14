class Solution {
    public int countNegatives(int[][] grid) 
    {
          
    int count = 0;
        for (int[] row : grid) {
            count += countRowWise(row);
        }
        return count;
    }

    private int countRowWise(int[] mat) {
        int lo = 0, hi = mat.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (mat[mid] >= 0) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return mat.length - hi - 1;
    }

}