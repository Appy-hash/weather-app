import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPoinetr {

    static Map<Integer, PointerNode> map;
    public static PointerNode copyRandomList(PointerNode head) {
        map = new HashMap<>();

        return formLinkedList(head);

    }

    public static PointerNode formLinkedList(PointerNode node){
        if(node == null){
            return null;
        }
        PointerNode copyNode;
        if(!map.containsKey(node.val)){
            copyNode = new PointerNode(node.val);
            map.put(node.val,copyNode);
            copyNode.next = formLinkedList(node.next);
            copyNode.random = formLinkedList(node.random);
        }else{
            return map.get(node.val);
        }
        return copyNode;
    }



    public static void main(String[] args){
        PointerNode node = new PointerNode(7);
        node.next = new PointerNode(13);
        node.random = null;

        node.next.next = new PointerNode(11);
        node.next.random = node;

        node.next.next.next = new PointerNode(10);
        node.next.next.next.random = node.next.next;
        node.next.next.next.next = new PointerNode(1);
        node.next.next.random = node.next.next.next.next;
        node.next.next.next.next.random = node;

        copyRandomList(node);

    }


}

class PointerNode {
    int val;
    PointerNode next;
    PointerNode random;

    public PointerNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
