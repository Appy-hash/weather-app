public class RemoveNthNodeFromLast {

    static int count;

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return head;
        }

        if(head.next == null && n == 1){
            return null;
        }
        count = n;
        ListNode temp = new ListNode(-1);
        temp.next = head;
        removeNodeUsingRecursion(null,temp);

        return temp.next;
    }

    public static void removeNodeUsingRecursion(ListNode prev, ListNode curr){
        if(curr.next != null){
            removeNodeUsingRecursion( curr,curr.next);
        }
        count--;
        ListNode next = curr.next;

        if(count == 0){
            prev.next = next;
            curr.next = null;
        }


    }






    public static void main( String[] args){
        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next = new ListNode(3);
        n.next.next.next = new ListNode(4);
        n.next.next.next.next = new ListNode(5);
        removeNthFromEnd(n, 2);
    }
}
