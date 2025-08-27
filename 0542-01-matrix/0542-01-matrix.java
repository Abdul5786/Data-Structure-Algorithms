class Pair
{
    int row;
    int col;
    int dist;

    Pair(int row, int col, int dist)
    {
        this.row=row;
        this.col=col;
        this.dist=dist;
    }
}

class Solution 
{
    public int[][] updateMatrix(int[][] mat) 
    {
          int m  = mat.length;
          int n= mat[0].length;

         Queue<Pair>  q = new LinkedList<>();
         boolean visited[][] = new boolean[m][n];
         int ans[][] = new int[m][n];

         for(int i=0;i<m;i++)
         {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j]==0)
                {
                    q.add(new Pair(i,j,0));
                    visited[i][j]=true;
                    ans[i][j]=0;
                }
            }
         }

         int dirs[][] = {{1,0},{-1,0},{0,1},{0,-1}};

         while(!q.isEmpty())
         {
          
             Pair curr = q.poll();
             int r = curr.row;
             int c =curr.col;
             int dist = curr.dist;

              // check neigbours

              for(int dir[]:dirs)
              {
                  int row = r+dir[0];
                  int col = c+dir[1];

                 if (row >= 0 && row < m && col >= 0 && col < n && !visited[row][col])
                  {

                    visited[row][col]= true;
                    ans[row][col]=dist+1;
                    q.add(new Pair(row,col,dist+1));
                  }
              }

          

         }

          return ans;
    }
}