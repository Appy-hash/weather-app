import java.util.List;

public class ReverseLinkedList {


    public static ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode reverseNode = new ListNode(-1);
        ListNode temp = head;
        ListNode end = null;

        while(temp != null){
            reverseNode.next = temp;
            ListNode temp1 = temp;
            temp = temp.next;

            temp1.next  = end;
            end = temp1;


        }
        return reverseNode.next;


    }

    public static void main(String[] args){
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        System.out.println(reverseList(node));
    }
}
