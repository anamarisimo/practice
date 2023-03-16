package Graphs;

public class NumberOfIslands {

    private int islandsCount = 0;
    private boolean[][] seen;

    public int numIslands(char[][] grid) {
        seen = new boolean[grid.length][grid[0].length];
        for(int i=0; i< grid.length; i++)
        {
            for(int j=0; j < grid[0].length; j++)
            {
                if(seen[i][j] && grid[i][j] == '1')
                {
                    islandsCount++;
                    checkIsland(i,j, grid);
                }
            }
        }
        return islandsCount;

    }

    private void checkIsland(int line, int col, char[][] grid)
    {
        if(grid[line][col] == '0' ||  seen[line][col])
            return;

        seen[line][col] = true;

        if(line-1 >= 0)
            checkIsland(line-1,col, grid);
        if(line+1 < grid.length)
            checkIsland(line+1,col, grid);
        if(col-1 >= 0)
            checkIsland(line,col-1, grid);
        if(col+1 < grid[0].length)
            checkIsland(line,col+1, grid);
    }
}
