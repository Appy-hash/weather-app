public class QuadTree {

    public static Quad construct(int[][] grid) {
        if(null == grid){
            return null;
        }
        return buildQuadTree(grid,grid[0][0],0, grid.length-1,
        0, grid[0].length-1);
    }


    private static Quad buildQuadTree(int[][] grid,int value, int rowStart, int rowEnd,
                                      int colStart, int colEnd){
        if(colStart < 0 || rowStart < 0  || colEnd > grid[0].length || rowEnd > grid.length){
            return null;
        }

        if(colStart <= colEnd && rowStart <= rowEnd){
            Quad node = new Quad(true,true);
            for(int i = rowStart ; i <= rowEnd; i++){
                for(int j = colStart ; j <= colEnd ; j++){
                    if(grid[i][j] != value){
                        node.isLeaf = false;
                        node.val = grid[rowStart][colStart] == 1;
                        node.topLeft = buildQuadTree(grid, grid[rowStart][colStart],rowStart,rowEnd/2,
                                colStart,colStart + (colEnd-colStart)/2);
                        node.topRight = buildQuadTree(grid, grid[rowStart][(colEnd/2)+1],rowStart,rowEnd/2,
                                (colStart + (colEnd-colStart)/2)+1,colEnd);
                        node.bottomLeft = buildQuadTree(grid, grid[(rowEnd/2)+1][colStart],(rowStart + (rowEnd-rowStart)/2)+1,rowEnd,
                                colStart,colStart + (colEnd-colStart)/2);
                        node.bottomRight = buildQuadTree(grid, grid[(rowEnd/2)+1][(colEnd/2)+1],(rowStart + (rowEnd-rowStart)/2)+1,rowEnd,
                                (colStart + (colEnd-colStart)/2)+1 ,colEnd);
                        return node;
                    }
                }
            }
            node.val = value == 1;
            return node;
        }

        return null;

    }


    public static void main(String[] args){
        int[][] grid = new int[][]{{1,1,1,1,0,0,0,0},
                                   {1,1,1,1,0,0,0,0},
                                   {1,1,1,1,1,1,1,1},
                                   {1,1,1,1,1,1,1,1},
                                   {1,1,1,1,0,0,0,0},
                                   {1,1,1,1,0,0,0,0},
                                   {1,1,1,1,0,0,0,0},
                                   {1,1,1,1,0,0,0,0}};
        System.out.println(construct(grid));
    }
}


















class Quad{

    public boolean val;
    public boolean isLeaf;
    public Quad topLeft;
    public Quad topRight;
    public Quad bottomLeft;
    public Quad bottomRight;


    public Quad() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Quad(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Quad(boolean val, boolean isLeaf, Quad topLeft, Quad topRight, Quad bottomLeft, Quad bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }


}
