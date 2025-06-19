public class MergeTwoSortedLists {


    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }

        if(list2 == null){
            return list1;
        }

        if(list1.val <= list2.val){
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }else{
            list2.next = mergeTwoLists(list1,list2.next);
            return list2;

        }


    }


    public static void main(String[] args){
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(4);


        ListNode node2 = new ListNode(1);
        node.next = new ListNode(3);
        node.next.next = new ListNode(4);
        System.out.println(mergeTwoLists(node, node2));
    }
}
