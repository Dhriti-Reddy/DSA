class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] copy = new int[m][n];

        int[][] directions = {
            {-1,-1}, {-1,0}, {-1,1},
            {0,-1},          {0,1},
            {1,-1},  {1,0},  {1,1}
        };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int liveNeighbors = 0;

                for (int[] dir : directions) {
                    int newRow = i + dir[0];
                    int newCol = j + dir[1];

                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                        if (board[newRow][newCol] == 1) {
                            liveNeighbors++;
                        }
                    }
                }

                if (board[i][j] == 1) {
                    if (liveNeighbors < 2) {
                        copy[i][j] = 0;
                    } else if (liveNeighbors == 2 || liveNeighbors == 3) {
                        copy[i][j] = 1;
                    } else {
                        copy[i][j] = 0;
                    }
                } else {
                    if (liveNeighbors == 3) {
                        copy[i][j] = 1;
                    } else {
                        copy[i][j] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = copy[i][j];
            }
        }
    }
}