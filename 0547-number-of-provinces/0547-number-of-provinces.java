class Solution {
    public int findCircleNum(int[][] isConnected) 
    {
        int n = isConnected.length;
         
        boolean visited[] = new boolean[n];

        int count =0;

        for(int i=0;i<n;i++)
        {
            if(!(visited[i]))
            {

                dfs(isConnected,visited,n,i);
                count++;
            }
        }

         return count;
    }

    public void dfs(int isConnected[][], boolean visited[], int n, int i)
    {

        visited[i] =true;

        for(int k=0;k<n;k++)
        {

            if(!(visited[k]) && isConnected[i][k]==1)
            {
                dfs(isConnected,visited,n,k);
            }
        }
    }
}