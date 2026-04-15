class Solution {

    int[][] grid;

    public Node construct(int[][] grid) {
        this.grid = grid;
        return build(0, 0, grid.length);
    }

    private Node build(int row, int col, int size) {

        if (isUniform(row, col, size)) {
            return new Node(
                grid[row][col] == 1,
                true,
                null, null, null, null
            );
        }

        int half = size / 2;

        Node topLeft = build(row, col, half);
        Node topRight = build(row, col + half, half);
        Node bottomLeft = build(row + half, col, half);
        Node bottomRight = build(row + half, col + half, half);

        return new Node(
            true,
            false,
            topLeft, topRight, bottomLeft, bottomRight
        );
    }

    private boolean isUniform(int row, int col, int size) {
        int val = grid[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (grid[i][j] != val) return false;
            }
        }
        return true;
    }
}