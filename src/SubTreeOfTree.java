public class SubTreeOfTree {

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null){
            return true;
        }

        if(root == null || subRoot == null){
            return false;
        }

        boolean ifSubTreeStartsWithNode = checkIfSubtreeStartswithNode(root,subRoot);
        if(!ifSubTreeStartsWithNode){
            return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
        }
        return ifSubTreeStartsWithNode;

    }


    public static boolean checkIfSubtreeStartswithNode(TreeNode root, TreeNode subTreeRoot){
        if(root == null && subTreeRoot == null){
            return true;
        }

        if(root == null || subTreeRoot == null){
            return false;
        }

        if(root.val == subTreeRoot.val){
            boolean left =  checkIfSubtreeStartswithNode(root.left,subTreeRoot.left);
            boolean right =  checkIfSubtreeStartswithNode(root.right,subTreeRoot.right);
            return left && right;
        }
        return false;



    }


    public static void main(String... args){
        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(4);
        t.right = new TreeNode(5);
        t.left.left = new TreeNode(1);
        t.left.right = new TreeNode(2);

        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);

        System.out.println(isSubtree(t,subRoot));
    }
}
