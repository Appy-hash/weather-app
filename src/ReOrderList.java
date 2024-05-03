import java.awt.*;

public class ReOrderList {

    static ListNode copy;
    public static void reorderList(ListNode head) {
        if(head != null){
            copy = head;
            backTrack(null, head);
        }
    }


    public static void backTrack(ListNode prev , ListNode currNow){

        if(currNow.next != null){
        backTrack(currNow,currNow.next);
        }

        if(currNow.next == null){
            if(copy.next == null || copy.next.equals(currNow)){
                return;
            }
            prev.next = null;
            ListNode temp = copy;
            ListNode nextNode = temp.next;

            temp.next = currNow;
            currNow.next = nextNode;
            copy = currNow.next;

        }


    }


    public static void main(String[] args){
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        //node.next.next.next.next = new ListNode(5);

        reorderList(node);
    }
}
