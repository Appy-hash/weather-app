import java.util.*;

public class CloneGraph {
    static Map<Node, Node> cloneMap  = new HashMap<>();
    public static Node cloneGraph(Node node) {
        Node clonedNode = null;
        if(node != null) {
            if(!cloneMap.containsKey(node)){
                clonedNode = new Node(node.val);
                cloneMap.put(node,clonedNode);

                for(Node neighbor: node.neighbors){
                    clonedNode.neighbors.add(cloneGraph(neighbor));
                }
            }else{
                return cloneMap.get(node);
            }
        }
        return clonedNode;
    }
    

    public static  void main(String... args){
        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        List<Node> neighbors = new ArrayList<>();
        neighbors.add(node2);
        neighbors.add(node4);
        node.neighbors = neighbors;

        neighbors = new ArrayList<>();
        neighbors.add(node);
        neighbors.add(node3);
        node2.neighbors = neighbors;

        neighbors = new ArrayList<>();
        neighbors.add(node2);
        neighbors.add(node4);
        node3.neighbors = neighbors;

        neighbors = new ArrayList<>();
        neighbors.add(node);
        neighbors.add(node3);
        node4.neighbors = neighbors;
        cloneGraph(node);

    }
}
