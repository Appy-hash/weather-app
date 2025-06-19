import java.util.List;

public class AddTwoNumbers {



    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;

        ListNode sumNode = new ListNode();
        ListNode ans = sumNode;
        int sum = 0;
        while(l1 != null || l2 != null){

            if(l1 != null && l2 != null){
                sum = carry + l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            }

            else if(l1 == null){
                sum = carry + l2.val;
                l2 = l2.next;

            }

            else {
                sum = carry + l1.val;
                l1 = l1.next;
            }

            if(sum >= 10){
                ans.next = new ListNode(sum % 10);
                carry = 1;
            }else{
                ans.next = new ListNode(sum);
                carry = 0;
            }
            ans = ans.next;


        }
        if(carry > 0){
            ans.next = new ListNode(carry);
        }
        while(sumNode != null){
            System.out.println(sumNode.val);
            sumNode = sumNode.next;
        }
        return sumNode.next;
    }


    public static void main(String[] args){
        ListNode n = new ListNode(2);
        n.next = new ListNode(4);
        n.next.next = new ListNode(3);

        ListNode m = new ListNode(5);
        m.next = new ListNode(6);
        m.next.next = new ListNode(4);
        addTwoNumbers(n,m);

    }
}
