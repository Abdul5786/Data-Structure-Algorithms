class Solution {
    public boolean isBipartite(int[][] graph) 
    {
        int n = graph.length;

        int colors[] = new int[n];

        Arrays.fill(colors,-1);

        for(int i=0;i<n;i++)
        {
            if(colors[i]==-1)
            {
                if(!(dfs(graph,colors,i,0)))
                {
                    return false;
                }
            }
        }

        return true;
    }


    public boolean dfs(int graph[][], int colors[], int node, int c)
    {

        colors[node]=c;

        for(int nbr: graph[node])
        {
            if(colors[nbr]==-1)
            {
                if(!dfs(graph,colors,nbr,1-c)) return false;
            }

            else if(colors[nbr]==colors[node])
            {
                return false;
            }

           
        }
     return true;
}

}