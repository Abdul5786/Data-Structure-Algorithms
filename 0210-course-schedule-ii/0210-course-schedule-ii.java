class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) 
    {
         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        // Step 1: Create adjacency list
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Step 2: Fill adjacency list and indegree array
        for (int[] edge : prerequisites) {
            int a = edge[0]; // course a depends on b
            int b = edge[1];
            adj.get(b).add(a);
            inDegree[a]++;
        }

        // Step 3: Run BFS (Kahn's Algo)
        return bfs(adj, inDegree, numCourses);
    }

    public int[] bfs(ArrayList<ArrayList<Integer>> adj, int[] inDegree, int n) {
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        ArrayList<Integer> res = new ArrayList<Integer>();

        // Add all nodes with indegree 0
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);

            }
        }

        // Process the queue
        while (!q.isEmpty()) {
            int node = q.poll();
            res.add(node);
            count++;

            // Decrease indegree of neighbors
            for (int nbr : adj.get(node)) {
                inDegree[nbr]--;
                if (inDegree[nbr] == 0) {
                    q.offer(nbr);
                }
            }
        }

       // If we processed all nodes, build result array
        if (res.size() == n) {
            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                ans[i] = res.get(i);
            }
            return ans;
        } else {
            return new int[0];  // cycle exists
        }
    }


    }
