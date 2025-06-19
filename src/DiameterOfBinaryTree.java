import java.net.Inet4Address;

public class DiameterOfBinaryTree {

    static int diameter;

    public static int diameterOfBinaryTree(TreeNode root){
        if(root == null){
            return 0;
        }
        diameter = Integer.MIN_VALUE;
        dfs(root);
        return diameter;
    }
    public static  int dfs(TreeNode treeNode){
        if(treeNode == null){
            return 0;
        }

        int left = dfs(treeNode.left);
        int right = dfs(treeNode.right);

        diameter = Math.max(left+right,diameter);

        return 1+ Math.max(left,right);
    }

    public static  void main(String[] args){
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        System.out.println(diameterOfBinaryTree(node));

    }
}
