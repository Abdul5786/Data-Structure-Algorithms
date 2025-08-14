import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int freshCount = 0;

        Queue<int[]> queue = new LinkedList<>();

        // count fresh & push rotten
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    freshCount++;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // no fresh -> time = 0
        if (freshCount == 0) return 0;

        int time = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] rottenLoc = queue.poll();   // int[] (na ki int)
                int r = rottenLoc[0];
                int c = rottenLoc[1];

                int[][] nbr = {{r - 1, c}, {r, c + 1}, {r + 1, c}, {r, c - 1}};

                for (int[] nb : nbr) {
                    int nr = nb[0];
                    int nc = nb[1];

                    // sirf fresh (1) ko rot karo; 0/2 skip
                    if (nr < 0 || nr >= n || nc < 0 || nc >= m || grid[nr][nc] != 1) continue;

                    queue.offer(new int[]{nr, nc});
                    grid[nr][nc] = 2;
                    freshCount--; // yahin kam karo
                }
            }

            time++;
            if (freshCount == 0) break;
        }

        return (freshCount == 0) ? time : -1;
    }
}
