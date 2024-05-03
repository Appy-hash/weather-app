public class BuildBinaryTree {

    static int index;

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0){
            return null;
        }
        index = 0;
        return contructUsingRecusrion(preorder, inorder, 0, preorder.length-1);
    }



    public static TreeNode contructUsingRecusrion(int[] preorder, int[] inorder, int start, int end){


        if(index < preorder.length){

            TreeNode node = null;
            int pos = 0;
            for (int j = start; j <= end; j++) {

                if(index < preorder.length){
                    if (inorder[j] == preorder[index]) {
                        node = new TreeNode(preorder[index]);
                        index++;
                        pos = j;
                        node.left = contructUsingRecusrion(preorder, inorder, start, pos-1);
                        node.right = contructUsingRecusrion(preorder, inorder,pos+1, end);

                    }
                }

            }



            return node;
        }

        return null;

    }


    public static void main(String[] args){
        buildTree(new int[]{1,2}, new int[]{1,2});
    }
}
