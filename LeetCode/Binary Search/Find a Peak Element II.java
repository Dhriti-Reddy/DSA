class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int midCol = low + (high - low) / 2;

            int maxRow = 0;
            for (int i = 0; i < m; i++) {
                if (mat[i][midCol] > mat[maxRow][midCol]) {
                    maxRow = i;
                }
            }

            int left = (midCol - 1 >= 0) ? mat[maxRow][midCol - 1] : -1;
            int right = (midCol + 1 < n) ? mat[maxRow][midCol + 1] : -1;

            if (mat[maxRow][midCol] > left && mat[maxRow][midCol] > right) {
                return new int[]{maxRow, midCol};
            }
            else if (mat[maxRow][midCol] < right) {
                low = midCol + 1;
            }
            else {
                high = midCol - 1;
            }
        }
        return new int[]{-1, -1}; 
    }
}