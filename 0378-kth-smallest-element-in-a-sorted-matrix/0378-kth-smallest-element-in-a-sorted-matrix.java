class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int n = mat.length,m=mat[0].length;
        int arr[] = new int[n*m];
        int a=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[a++]=mat[i][j];
            }
        }
        Arrays.sort(arr);
        return arr[k-1];
    }
}