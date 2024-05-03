import java.util.LinkedList;
import java.util.Queue;



class LevelNodes{

    TreeNode node;
    int level;

    public LevelNodes(TreeNode n, int level){
        node = n;
        this.level = level;
    }
}
public class HighestSumInALevel {



    public static int maxSumOfTree(TreeNode node){
        int maxSum = Integer.MIN_VALUE;
        int levelWithMaxSum = 0;
        if(null == node){
            return 0;
        }

        if(node.left == null && node.right == null){
            return node.val;
        }

        Queue<LevelNodes> queue = new LinkedList<>();
        LevelNodes root = new LevelNodes(node, 0);
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            int sum = 0;
            int level  = 0;
            while(size > 0){
                LevelNodes top = queue.poll();
                TreeNode nodeTop = top.node;
                level = top.level;
                sum += nodeTop.val;
                if(nodeTop.left != null){
                    queue.add(new LevelNodes(nodeTop.left, top.level +1));
                }

                if(nodeTop.right != null){
                    queue.add(new LevelNodes(nodeTop.right, top.level +1));
                }


                size--;
            }

            if(sum > maxSum){
                maxSum = Math.max(maxSum, sum);
                levelWithMaxSum = level;
            }

        }
        return levelWithMaxSum;
    }


    public static void main(String[] args){
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.right = new TreeNode(6);
        System.out.println(maxSumOfTree(node));

    }
}
