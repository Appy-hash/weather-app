import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


class Position {
    int row;
    int col;

    Position(int row, int col){
        this.row = row;
        this.col = col;
    }

}
public class WallsAndGates {



    public static void wallsAndGates(int[][] rooms) {

        Queue<Position> queue = new LinkedList<>();
        boolean[][]  visited = new boolean[rooms.length][rooms[0].length];
        for(int i = 0 ; i < rooms.length ; i++){
            for(int j = 0 ; j< rooms[i].length ; j++){
                if(rooms[i][j] == 0){
                    queue.add(new Position(i, j));

                }
            }
        }

        int distance = 0;
        while(!queue.isEmpty()){
            int size = queue.size();

            while(size > 0){
                Position top = queue.poll();
                rooms[top.row][top.col] = distance;


                if(top.row - 1 >= 0 ){

                    if(rooms[top.row -1][top.col] == 2147483647){
                        if(!visited[top.row -1][top.col]){
                            queue.add(new Position(top.row -1,top.col));
                            visited[top.row -1][top.col] = true;
                        }
                    }

                }

                if(top.col - 1 >= 0){
                    if(rooms[top.row][top.col -1] == 2147483647){
                        if(!visited[top.row][top.col -1]){
                            queue.add(new Position(top.row,top.col -1));
                            visited[top.row][top.col -1] = true;
                        }
                    }

                }

                if(top.row +1 < rooms.length){

                    if(rooms[top.row+1][top.col] == 2147483647){
                        if(!visited[top.row +1][top.col]){
                            queue.add(new Position(top.row +1,top.col));
                            visited[top.row + 1][top.col] = true;
                        }
                    }

                }

                if(top.col +1 < rooms[0].length){
                    if(rooms[top.row][top.col +1] == 2147483647){
                        if(!visited[top.row][top.col +1]){
                            queue.add(new Position(top.row , top.col +1));
                            visited[top.row][top.col + 1] = true;
                        }
                    }

                }
                size--;


            }
            distance++;

        }



    }


    public static void main(String[] args){
            int[][] rooms = new int[][]{{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1}, {0,-1,2147483647,2147483647}};
            wallsAndGates(rooms);
    }

}
