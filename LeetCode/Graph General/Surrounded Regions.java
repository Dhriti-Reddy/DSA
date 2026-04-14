class Solution {
    public void solve(char[][] board) {
        if(board == null) return;
        int rows = board.length;
        int cols = board[0].length;

        for(int i=0; i<cols; i++){
            if(board[0][i] == 'O'){
                dfs(board, 0, i);
            }
        }
        for(int i=0; i<cols; i++){
            if(board[rows-1][i] == 'O'){
                dfs(board, rows-1, i);
            }
        }
        for(int i=0; i<rows; i++){
            if(board[i][0] == 'O'){
                dfs(board, i, 0);
            }
        }
        for(int i=0; i<rows; i++){
            if(board[i][cols-1] == 'O'){
                dfs(board, i, cols-1);
            }
        }
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                else if(board[i][j] == 'T'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    public void dfs(char[][] board, int a, int b){
        if(a<0 || b<0 || a>=board.length || b>=board[0].length || board[a][b] != 'O') return;
        board[a][b] = 'T';
        dfs(board, a+1, b);
        dfs(board, a-1, b);
        dfs(board, a, b+1);
        dfs(board, a, b-1);
    }
}