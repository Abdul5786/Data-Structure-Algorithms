class Solution {

    int transposeMatrix[][];
    public int[][] transpose(int[][] matrix) 
    {
        transposeMatrix=new int[matrix[0].length][matrix.length];
          for(int r=0; r<matrix.length;r++)
          {
            for(int c=0;c<matrix[0].length;c++)
            {
                 transposeMatrix[c][r]=matrix[r][c];
            }
          }

          return transposeMatrix;
    }
}