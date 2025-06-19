public class NumberOfIsland {
    static boolean visited[][];
    public static int numIslands(char[][] grid) {
        int numOfIsland = 0;
        visited = new boolean[grid.length][grid[0].length];
        if(null != grid && grid.length > 0){
            for(int row = 0 ; row < grid.length; row++){
                for(int col = 0 ; col < grid[row].length; col++){
                    if(grid[row][col] == '1'){
                        if(foundIsland(grid,row,col)){
                            numOfIsland++;
                        }
                    }
                }
            }
        }
        return numOfIsland;
    }

    public static boolean foundIsland(char[][] grid, int row, int col){
        if(row >= 0 && col >= 0 && row < grid.length && col < grid[row].length){
            if(!visited[row][col]){
                if(grid[row][col] == '1'){
                    visited[row][col] = true;
                    foundIsland(grid,row+1,col) ;
                    foundIsland(grid,row-1,col);
                    foundIsland(grid,row,col-1);
                    foundIsland(grid,row,col+1);
                    return true;
                }
                if(grid[row][col] == '0'){
                    return false;
                }
            }
        }
        return false;
    }

    public static  void main(String ... args){
        char[][] grid = {{'1','1','1','1','0'},
                        {'1','1','0','1','0'},
                        {'1','1','0','0','0'},
                        {'0','0','0','0','0'}};
        System.out.println(numIslands(grid));
    }
}
