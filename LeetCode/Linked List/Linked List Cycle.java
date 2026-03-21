public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode right = head;
        ListNode left = head;
        while(right != null && right.next != null){
            left = left.next;
            right = right.next.next;
            if(left == right){
                return true;
            }
        }
        return false;
    }
}