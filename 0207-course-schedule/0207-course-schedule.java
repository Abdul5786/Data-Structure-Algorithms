class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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

    public boolean bfs(ArrayList<ArrayList<Integer>> adj, int[] inDegree, int n) {
        Queue<Integer> q = new LinkedList<>();
        int count = 0;

        // Add all nodes with indegree 0
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        // Process the queue
        while (!q.isEmpty()) {
            int node = q.poll();
            count++;

            // Decrease indegree of neighbors
            for (int nbr : adj.get(node)) {
                inDegree[nbr]--;
                if (inDegree[nbr] == 0) {
                    q.offer(nbr);
                }
            }
        }

        // If we processed all nodes, no cycle
        return count == n;
    }
}
