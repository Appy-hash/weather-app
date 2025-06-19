import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class SerializeAndDeserialize {


        static  List<String> preOrder;


        static int index;

        public SerializeAndDeserialize(){
            preOrder = new ArrayList<>();

        }

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root == null){
                return "";
            }

            doDFSPreorder(root);

            String pre = String.join(":", preOrder);
            return pre;
        }

        private static void doDFSPreorder(TreeNode root){
            if(root == null){
                preOrder.add("N");
                return;
            }
            preOrder.add(String.valueOf(root.val));
            doDFSPreorder(root.left);
            doDFSPreorder(root.right);

        }


        // Decodes your encoded data to tree.
        public static TreeNode deserialize(String data) {
            if(data == null || data.length() == 0){
                return null;
            }

            String preOrder[] = data.split(":");
            return buildBinaryTree(preOrder);

        }



    private static  TreeNode buildBinaryTree(String[] pre) {
            if(index >= pre.length){
                return null;
            }

            if(pre[index].equals("N")){
                return null;
            }

            TreeNode node= new TreeNode(Integer.parseInt(pre[index]));
            ++index;
            node.left = buildBinaryTree(pre);

            ++index;

            node.right = buildBinaryTree(pre);

            return node;

    }




        public static  void main(String[] args){
            SerializeAndDeserialize ser = new SerializeAndDeserialize();
            SerializeAndDeserialize deser = new SerializeAndDeserialize();
            TreeNode root = new TreeNode(3);
            root.left = new TreeNode(2);
            root.right = new TreeNode(4);

            root.right.left = new TreeNode(3);
//            root.right.right = new TreeNode(5);
            TreeNode ans = deser.deserialize(ser.serialize(root));
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

