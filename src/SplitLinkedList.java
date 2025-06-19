import java.util.ArrayList;
import java.util.List;

public class SplitLinkedList {

    static int totalLength = Integer.MIN_VALUE;
    static ListNode[] a;
    static List<ListNode> listNodes;

    static ListNode reverse;

    static  ListNode revTemp;

    public static void  backTrackList(ListNode head, int k){

    }
    public static ListNode[] splitListToParts(ListNode head, int k) {
        a = new ListNode[k];
        reverse = new ListNode();
        totalLength = Integer.MIN_VALUE;
        revTemp = reverse;
        int count = 0;
        while(head != null){
            head = head.next;
            count++;
        }
        totalLength = count - 1;

        backTrack(head);

        while(revTemp != null){
            if(totalLength/k > 0){
                while(count % k == 0){
                    a[count-1] = new ListNode(revTemp.val);
                    revTemp  = revTemp.next;
                    count--;
                }
            }else{
                while(count != k){
                    a[count-1] = null;
                    count--;
                }

                a[count] = new ListNode(revTemp.val);
                revTemp  = revTemp.next;

            }


        }
        return a;
    }

    public static void backTrack(ListNode head){
        if(head == null){
            return;
        }
        backTrack(head.next);
        reverse.next = new ListNode(head.val);
        reverse = reverse.next;
    }

    public static  void main(String... args){
        ListNode a = new ListNode();
        a.next = new ListNode(1);
        a.next.next = new ListNode(2);
        a.next.next.next = new ListNode(3);
        splitListToParts(a,5);
    }
}

class ListNode{
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
