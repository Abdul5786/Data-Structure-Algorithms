class Solution {
    public int numSpecial(int[][] mat) {
        int special = 0;

        for (int i = 0; i < mat.length; i++) {
            int index = checkRow(mat, i);  // Find column index where '1' is present
            if (index >= 0 && checkColumns(mat, i, index)) {  
                special++;
            }
        }

        return special;  // ✅ Return the count of special positions
    }

    public int checkRow(int[][] mat, int i) {
        int index = -1;  

        for (int j = 0; j < mat[0].length; j++) {  // ✅ Loop through columns
            if (mat[i][j] == 1) {
                if (index >= 0) {
                    return -1;  // ✅ If another '1' is found, return -1 (invalid row)
                }
                index = j;  // ✅ Store the column index of '1'
            }
        }
        return index;  // ✅ Return the column index where '1' is found
    }

    public boolean checkColumns(int[][] mat, int i, int index) {
        for (int j = 0; j < mat.length; j++) {  // ✅ Loop through rows
            if (mat[j][index] == 1 && j != i) {  
                return false;  // ✅ If another '1' found in same column, return false
            }
        }
        return true;  // ✅ Return true if column is valid
    }
}
