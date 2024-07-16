import com.sun.source.tree.Tree;

public class CountGoodNodes {



    private static int goodNodes;
    public static int goodNodes(TreeNode root) {
        if(root.left == null & root.right == null){
            return 1;
        }
        goodNodes = 0;

        countGoodNodes(root.val, root);
        return goodNodes;

    }


    private static void countGoodNodes(int maxNode, TreeNode root){
        if(root == null){
            return;
        }

        if(root.val >= maxNode){
            goodNodes++;
            maxNode = root.val;
        }


        countGoodNodes(maxNode, root.left);
        countGoodNodes(maxNode, root.right);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        node.right = new TreeNode(4);
        node.right.left = new TreeNode(10);
        node.right.right = new TreeNode(8);
        node.right.right.left = new TreeNode(4);
        System.out.println(goodNodes(node));
    }
}
