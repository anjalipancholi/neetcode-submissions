class Solution {
    int max = 0;
    public int maxAreaOfIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                grid[i][j] = 0;
                bfs(grid, i, j);
                }
            }
        }
        return max;
    }

    private void bfs(int[][] grid, int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        int sum = 1;
        int[][] directions = new int[][]{
            {0,1} // right
        ,{0,-1} // left
        ,{1,0} // down
        ,{-1,0}}; // lefupt
        q.add(new int[]{i,j});
while (!q.isEmpty()) {
    int[] cell = q.poll();
        for (int[] direction: directions) {
            int newRow = direction[0] + cell[0];
            int newCol = direction[1] + cell[1];
            if (newRow >= 0 && newCol >= 0 && newRow < grid.length &&
            newCol < grid[0].length && grid[newRow][newCol] == 1) {
                sum++;
                q.add(new int[]{newRow,newCol});
                grid[newRow][newCol] = 0;
            }
        }
    }
    max = Math.max(max,sum);
    }
}
