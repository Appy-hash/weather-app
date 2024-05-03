public class LCANeetCode {



    public static TreeNode lowestCommonAncestor(TreeNode t , TreeNode p, TreeNode q){

        while(t != null){
            if(p.val > t.val && q.val > t.val){
                t = t.right;
            }else if(p.val < t.val && q.val < t.val){
                t = t.left;
            }else{
                return t;
            }
        }
        return null;

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
        lowestCommonAncestor(t,new TreeNode(4),new TreeNode(0));

    }
}
