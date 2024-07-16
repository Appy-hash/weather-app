import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinAndMaxDistanceBwCriticalPoints {


    public static int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] distanceArray = new int[2];

        ListNode prev = head;
        ListNode curr = head.next;
        List<Integer> positions = new ArrayList<>();
        int count = 2;
        int minDiff = Integer.MAX_VALUE;
        int maxDiff = Integer.MIN_VALUE;
        while(curr.next != null){
            ListNode next = curr.next;

            if(curr.val > prev.val && curr.val > next.val){
                    positions.add(count);

            }

            if(curr.val < prev.val && curr.val < next.val){
                    positions.add(count);

            }
            prev = curr;
            curr = next;
            count++;
        }

        int index = 0;
        for(int i = 1 ; i < positions.size() ; i++){
            int diff = Math.abs(positions.get(index) - positions.get(i));
            minDiff = Math.min(minDiff, diff);
            index = i;
        }
        distanceArray[0] = minDiff;
        distanceArray[1] = positions.get(positions.size() -1) -
                positions.get(0);
        return distanceArray;
    }


    public static void main(String[] args) {
//        [5,3,1,2,5,1,2]
        ListNode head = new ListNode(5);
        head.next = new ListNode(3);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next = new ListNode(2);

        System.out.println(Arrays.toString(nodesBetweenCriticalPoints(head)));
    }
}
