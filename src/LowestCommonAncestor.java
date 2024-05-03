public class LowestCommonAncestor {


    static TreeNode lca;
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root != null){
            lca = null;
            findLCA(root,p,q);
        }
        return lca;

    }


    public static boolean findLCA(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return false;
        }


        boolean left = findLCA(root.left, p, q);
        boolean right = findLCA(root.right, p, q);


        boolean found = left || right;
        if((root.val == p.val && found) || (root.val == q.val && found) || (left && right)){
            if(lca == null){
                lca = root;
            }
        }

        if(root.val == p.val || root.val == q.val){
            return true;
        }


        return found;
    }


    public static void main(String[] args){
        TreeNode t = new TreeNode(6);

        t.left = new TreeNode(2);
        t.right = new TreeNode(8);
        t.left.left = new TreeNode(0);
        t.left.right = new TreeNode(4);
        t.left.right.left = new TreeNode(3);
        t.left.right.right = new TreeNode(5);
        t.right.right = new TreeNode(9);
        t.right.left = new TreeNode(7);
        lowestCommonAncestor(t,new TreeNode(2),new TreeNode(4));

    }
}
