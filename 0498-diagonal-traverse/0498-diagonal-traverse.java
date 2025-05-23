class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] result = new int[m * n];
        int row = 0, col = 0, idx = 0;
        boolean upward = true;

        while (idx < m * n) {
            result[idx++] = mat[row][col];

            if (upward) {
                if (col == n - 1) { // Hit the right boundary
                    row++;
                    upward = false;
                } else if (row == 0) { // Hit the top boundary
                    col++;
                    upward = false;
                } else {
                    row--;
                    col++;
                }
            } else {
                if (row == m - 1) { // Hit the bottom boundary
                    col++;
                    upward = true;
                } else if (col == 0) { // Hit the left boundary
                    row++;
                    upward = true;
                } else {
                    row++;
                    col--;
                }
            }
        }

        return result;
    }
}