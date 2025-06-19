public class ReverseKNodesFromGroup {

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (null == head) {
            return head;
        }

        ListNode revCopy = new ListNode(-1);
        ListNode rev = revCopy;
        ListNode temp = head;
        ListNode headCopy = head;
        ListNode curr = head;
        ListNode kNext = null;
        int count = 1;

        while (temp != null) {

            count++;
            temp = temp.next;
            curr = curr.next;
            if (count == k) {
                kNext = curr.next;
                revCopy.next = reverseNodes(headCopy, curr,kNext);
                temp = kNext;
                count = 1;
            }


        }
        return rev;


    }


    private static ListNode reverseNodes(ListNode start, ListNode curr, ListNode kNext){
        ListNode dummy = new ListNode(-1);
        ListNode startCopy;
        ListNode endNode = null;
        ListNode endGroupStart = start;
        while(start != null){
            startCopy = start;
            dummy.next = startCopy;
            start = start.next;
            startCopy.next = endNode;
            endNode = startCopy;
            if(start == kNext){
                endGroupStart.next = kNext;
                break;
            }
        }
        return dummy.next;
    }



    public static  void main(String[] args){
        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next = new ListNode(3);
        n.next.next.next = new ListNode(4);
        n.next.next.next.next = new ListNode(5);

        reverseKGroup(n, 2);
    }
}
