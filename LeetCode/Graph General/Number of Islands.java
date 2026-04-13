class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i,j);
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid, int a, int b){
        if(a<0 || b<0 || a>=grid.length || b>=grid[0].length) return;
        if(grid[a][b] == '0') return;
        grid[a][b] = '0';
        dfs(grid, a+1, b);
        dfs(grid, a-1, b);
        dfs(grid, a, b+1);
        dfs(grid, a, b-1);
    }
}