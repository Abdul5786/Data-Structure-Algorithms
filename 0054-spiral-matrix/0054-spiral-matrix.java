class Solution {
    public List<Integer> spiralOrder(int[][] matrix) 
    {
       List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return ans;  // ✅ Handle empty matrix

        int m = matrix.length, n = matrix[0].length;  // ✅ Proper declaration
        int minRow = 0, maxRow = m - 1;
        int minCol = 0, maxCol = n - 1;

        while (ans.size() < m * n) {  // ✅ Correct condition
            // Top row
            for (int c = minCol; c <= maxCol && ans.size() < m * n; c++) {
                ans.add(matrix[minRow][c]);
            }
            minRow++;  // ✅ Move boundary after loop

            // Right column
            for (int r = minRow; r <= maxRow && ans.size() < m * n; r++) {
                ans.add(matrix[r][maxCol]);
            }
            maxCol--;  // ✅ Move boundary after loop

            // Bottom row
            for (int c = maxCol; c >= minCol && ans.size() < m * n; c--) {
                ans.add(matrix[maxRow][c]);
            }
            maxRow--;  // ✅ Move boundary after loop

            // Left column
            for (int r = maxRow; r >= minRow && ans.size() < m * n; r--) {
                ans.add(matrix[r][minCol]);
            }
            minCol++;  // ✅ Move boundary after loop
        }

        return ans;
}

}