class Solution {
    public int numEnclaves(int[][] grid) 
    {

      int m = grid.length;
      int n= grid[0].length;
      int count=0;

      for(int i=0;i<m;i++)
      {
         dfs(grid,i,0,m,n);   // 1c-> 0,0 c-> 1,0 ->2,0
         dfs(grid,i,n-1,m,n); // 2c-> 0,3 , 1,3 ,2,3, 3,3
      }

      for(int i=0;i<n;i++)
      {

        dfs(grid,0,i,m,n);  // r-> 0,0  r-> 0,1 r-> 0,2 0,3
        dfs(grid,m-1,i,m,n); // r-> 3,0 r-> 3,1 
      }
       
       for(int i=0;i<m;i++)
       {
         for(int j=0;j<n;j++)
         {
            if(grid[i][j]==1)
            {
                count++;
            }
         }
       }

        return count;
    }
   
   public void dfs(int grid[][], int i,int j,int m,int n)
   {

      if(i<0 || i>=m || j<0 || j>=n || grid[i][j]==0) return ;
      
      grid[i][j]=0;
      dfs(grid,i+1,j,m,n);
      dfs(grid,i-1,j,m,n);
      dfs(grid,i,j+1,m,n);
      dfs(grid,i,j-1,m,n);
   }
}