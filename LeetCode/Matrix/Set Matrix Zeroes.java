class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean zeroinrow = false;
        boolean zeroincol = false;
        //check if first row has zeroes
        for (int j = 0; j < n; j++) {
           if(matrix[0][j] == 0){
            zeroinrow = true;
           }
        }
        //check if first col has zeroes
        for (int i = 0; i < m; i++) {
            if(matrix[i][0] == 0){
                zeroincol = true;
            }
        }
        //mark any rows and columns which have zeroes
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        //convert only inner rows n cols into zeroes
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if((matrix[i][0] == 0) || (matrix[0][j] == 0)){
                    matrix[i][j] = 0;
                }
            }
        }
        //convert first row to 0
        for (int j = 0; j < n; j++) {
           if(zeroinrow){
            matrix[0][j] = 0;
           }
        }
        //convert first col to 0
        for (int i = 0; i < m; i++) {
            if(zeroincol){
                matrix[i][0] = 0;
            }
        }
    }
}