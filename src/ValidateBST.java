public class ValidateBST {


    static Long minValue ;
    static Long maxValue;

    public static boolean isValidBST(TreeNode root) {
        minValue = Long.MIN_VALUE;
        maxValue = Long.MAX_VALUE;
        return checkifBST(root,minValue,maxValue);


    }

    public static boolean  checkifBST(TreeNode root, Long min , Long max){
        if(root == null){
            return true;
        }

        if(root.val > min && root.val < max){
            return checkifBST(root.left,min, Long.valueOf(root.val)) && checkifBST(root.right,Long.valueOf(root.val),max);

        }

        return false;

    }


    public static  void main(String... args){
        TreeNode node = new TreeNode(2147483647);
//        node.left = new TreeNode(1);
//        node.right = new TreeNode(3);

//        node.right.left = new TreeNode(3);
//        node.right.right = new TreeNode(6);
        boolean result =  isValidBST(node);
        System.out.println(result);
    }
}
