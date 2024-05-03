class SumCountPair{


    int sum;
    int count ;

    public SumCountPair(int sum, int count){
        this.sum = sum;
        this.count = count;

    }
}


public class CountNodesEqualToAverageOfSubtree {

    static int totalNumOfNodes;
    public static int averageOfSubtree(TreeNode root) {
        double rootVal = root.val;
        dfs(root );

        return totalNumOfNodes;
    }


    public static SumCountPair dfs(TreeNode root){

        if(root == null){
            return new SumCountPair(0,0);
        }

        if(root.left == null && root.right == null){
            double leafNodeAvg = root.val/1.0;
            if(leafNodeAvg == root.val){
                totalNumOfNodes++;
            }
            return new SumCountPair(root.val, 1);
        }
        double sum = 0.0;
        int totalCount = 0;
        SumCountPair left = dfs(root.left);
        SumCountPair right = dfs(root.right);


        sum = left.sum + right.sum + root.val;
        totalCount = 1 + left.count + right.count;
        if((int)(sum/totalCount) == root.val){
            totalNumOfNodes++;
        }


        return new SumCountPair((int)(sum),totalCount);


    }


    public static void main(String[] args){
        TreeNode node = new TreeNode(4);
//        node.left = new TreeNode(8);
//        node.right = new TreeNode(5);
//        node.left.left = new TreeNode(0);
//        node.left.right = new TreeNode(1);
//
//        node.right = new TreeNode(5);
//        node.right.right = new TreeNode(6);

        System.out.println(averageOfSubtree(node));
    }







}
