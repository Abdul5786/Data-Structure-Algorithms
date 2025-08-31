class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;

        int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}, {1,1}, {-1,-1}, {1,-1}, {-1,1}};
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0, 1));
        grid[0][0] = 1; // mark as visited

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int r = curr.row, c = curr.col, len = curr.len;
            if (r == n-1 && c == n-1) return len;

            for (int[] d : dir) {
                int nr = r + d[0], nc = c + d[1];
                // check bounds and if cell is not visited (0)
                if (nr >= 0 && nc >= 0 && nr < n && nc < n && grid[nr][nc] == 0) {
                    q.add(new Pair(nr, nc, len + 1));
                    grid[nr][nc] = 1; // mark as visited
                }
            }
        }
        return -1;
    }
}

class Pair {
    int row, col, len;
    Pair(int row, int col, int len) {
        this.row = row;
        this.col = col;
        this.len = len;
    }
}