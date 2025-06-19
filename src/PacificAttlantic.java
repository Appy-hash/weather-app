import java.util.ArrayList;
import java.util.List;

public class PacificAttlantic {

    static List<Integer> coordinates;
    static List<List<Integer>> waterFlowPoints;

    static boolean visited[][];

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        coordinates = new ArrayList<>();
        waterFlowPoints = new ArrayList<>();

        coordinates.add(0);
        coordinates.add(heights[0].length-1);
        waterFlowPoints.add(coordinates);
        coordinates = new ArrayList<>();
        coordinates.add(heights.length-1);
        coordinates.add(0);
        waterFlowPoints.add(coordinates);
        coordinates = new ArrayList<>();
        for(int i = 0 ; i < heights.length ; i++){
            for(int j = 0 ; j < heights[i].length ;j++){
                visited = new boolean[heights.length][heights[0].length];
                findWaterFlow(heights[i][j],i,j,heights);
            }
        }
        return waterFlowPoints;
    }


    private static boolean findWaterFlow(int start, int row, int col, int[][] heights){
        if(row < 0 || col < 0 || row >= heights.length || col >= heights[row].length){
            return false;
        }



        if(!visited[row][col]){

            if(row == 0 && col == heights[0].length - 1 || row == heights.length -1 && col == 0){


                return true;
            }


            if(heights[row][col] <= start){
                start = heights[row][col];
                visited[row][col] = true;
                boolean up = findWaterFlow(start, row +1, col, heights);
                boolean down = findWaterFlow(start, row - 1, col, heights);
                boolean left = findWaterFlow(start, row, col +1, heights);
                boolean right = findWaterFlow(start, row, col -1 ,heights);

                if(up || down || left || right){

                    coordinates.add(row);
                    coordinates.add(col);
                    waterFlowPoints.add(new ArrayList<>(coordinates));
                    coordinates = new ArrayList<>();
                }
            }


        }
        return false;
    }


    public  static  void  main(String[] args){

        int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        System.out.println(pacificAtlantic(heights));
    }
}
