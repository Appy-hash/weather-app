import java.util.LinkedList;
import java.util.Queue;

public class RottenNumberOfOranges {


    static  boolean visited[][];

    public static int orangesRotting(int[][] grid) {

        if(null == grid || grid.length == 0){
            return -1;
        }
        visited = new boolean[grid.length][grid[0].length];

        Queue<RotPosition> oranges = new LinkedList<>();
        RotPosition position = null;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[i].length ; j++){
                if(grid[i][j] == 2){
                    position = new RotPosition(i,j);
                    oranges.add(position);
                }
            }
        }

        int minutes = 0;

        while(!oranges.isEmpty()){
            int size = oranges.size();

            while(size > 0){
                RotPosition topPosition = oranges.poll();



                    if(topPosition.row + 1 < grid.length){

                            if(grid[topPosition.row + 1][topPosition.col] == 1){
                                grid[topPosition.row + 1][topPosition.col] = 2;
                                oranges.add(new RotPosition(topPosition.row + 1, topPosition.col));
                            }



                    }



                    if(topPosition.row - 1 >= 0){

                            if(grid[topPosition.row - 1][topPosition.col] == 1){
                                grid[topPosition.row - 1][topPosition.col] = 2;
                                oranges.add(new RotPosition(topPosition.row - 1, topPosition.col));
                            }


                    }



                if(topPosition.col +1 < grid[topPosition.row].length){

                        if(grid[topPosition.row][topPosition.col + 1] == 1){
                            grid[topPosition.row][topPosition.col + 1] = 2;
                            oranges.add(new RotPosition(topPosition.row, topPosition.col + 1));
                        }


                }

                if(topPosition.col - 1 >= 0){


                        if(grid[topPosition.row][topPosition.col - 1] == 1){
                            grid[topPosition.row][topPosition.col - 1] = 2;
                            oranges.add(new RotPosition(topPosition.row, topPosition.col - 1));
                        }


                }

                size--;


            }
            if( oranges.size() > 0){
                minutes++;
            }

        }

        for (int[] ints : grid) {
            for (int anInt : ints) {
                if (anInt == 1) {
                    return -1;
                }
            }
        }
        return minutes;
    }


    public static void main(String[] args){
        int[][] grid = {{2,1,1,1},{0,1,2,1},{0,1,0,1}};
        System.out.println(orangesRotting(grid));
    }
}


class RotPosition{
    int row;
    int col;


    RotPosition(int row, int col){
        this.row = row;
        this.col = col;
    }

}
