class Solution {
      class edges
    {
      int src,dest,wt;  
      public edges(int src, int dest,int wt)
      {
        this.src=src;
        this.dest=dest;
        this.wt=wt;
      }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) 
    {
         int dist[] = new int[n];
         Arrays.fill(dist,Integer.MAX_VALUE);  // distance array created
         dist[src]=0;
         

         // creating adjacency list

         ArrayList<ArrayList<edges>> graph = new ArrayList<>();
         
         for(int i=0;i<n;i++)
         {
            graph.add(new ArrayList<>());  //    --->   [ [],[],[] ]
         }

         // populate the values

         for( int f[]:flights)
         {
            graph.get(f[0]).add(new edges(f[0],f[1],f[2]));  /// list created
            
         }

       Queue<int[]> q =   new LinkedList<>();
       q.add(new int[]{0,src,k+1});

       while(!q.isEmpty())
       {
         int curr[] = q.poll();
         int cost =curr[0], node = curr[1], stops = curr[2];

         if(stops>0)
         {
            for(edges e:graph.get(node))
            {
                int nextCost = cost+e.wt;

                if(nextCost<dist[e.dest])
                {
                    dist[e.dest] = nextCost;
                    q.add(new int[]{nextCost,e.dest,stops-1});
                } 
            }
         }
       }

       return dist[dst]==Integer.MAX_VALUE ? -1: dist[dst];

    }
    
}