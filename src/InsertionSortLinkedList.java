import java.util.List;

public class InsertionSortLinkedList {






    public  static  ListNode insertionSortList(ListNode head) {
        ListNode prev = head;
        ListNode  curr = head.next;
        ListNode nextNode;
        ListNode prevNode;

        while(curr != null){
            if(curr.val < prev.val){
                //Swap prev and curr
                prevNode = prev;
                nextNode = curr.next;
                prev.next = nextNode;
                curr.next = prevNode;

            }
        }
        return head;
    }


    public static  void main(String... args){
        ListNode list = new ListNode(4);
        list.next = new ListNode(2);
        list.next.next = new ListNode(1);
        list.next.next.next = new ListNode(3);
        insertionSortList(list);
    }
}
