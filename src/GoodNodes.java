import java.util.Map;

public class GoodNodes {

    public static int goodNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        return countGoodNodes(Integer.MIN_VALUE,root);


    }


    public static int countGoodNodes(int maxVal , TreeNode root){
        if(root == null){
            return 0;
        }

        int result = 0;
        if(root.val >= maxVal){
            maxVal = root.val;
            result = 1;
        }

        result += countGoodNodes(maxVal,root.left);
        result += countGoodNodes(maxVal,root.right);

        return result;

    }


    public static void main(String[] args){
        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(1);
        t.right = new TreeNode(4);
        t.left.left = new TreeNode(3);
        t.right.left = new TreeNode(2);
        t.right.right = new TreeNode(5);
        System.out.println(goodNodes(t));
    }
}
