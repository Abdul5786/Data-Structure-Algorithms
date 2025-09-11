import java.util.*;

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length, m = heights[0].length;
        int[][] effort = new int[n][m];
        for (int[] row : effort) Arrays.fill(row, Integer.MAX_VALUE);

        // Priority Queue: [effort, row, col]
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.effort - b.effort);
        pq.add(new Pair(0, 0, 0)); // start at (0,0) with 0 effort
        effort[0][0] = 0;

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}}; // 4 directions

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int r = curr.row, c = curr.col, currEff = curr.effort;
            if (r == n-1 && c == m-1) return currEff; // destination reached

            for (int[] d : dir) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
                    int diff = Math.abs(heights[r][c] - heights[nr][nc]);
                    int nextEff = Math.max(currEff, diff);
                    if (nextEff < effort[nr][nc]) {
                        effort[nr][nc] = nextEff;
                        pq.add(new Pair(nr, nc, nextEff));
                    }
                }
            }
        }
        return 0; // unreachable (shouldn’t happen as per constraints)
    }
}

// Custom Pair class
class Pair {
    int row, col, effort;
    Pair(int row, int col, int effort) {
        this.row = row;
        this.col = col;
        this.effort = effort;
    }
}