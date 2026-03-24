/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        int n = 1;
        ListNode current = head;
        while(current.next != null){
            current = current.next;
            n++;
        }
        k = k % n;
        current.next = head;
        ListNode tail = head;
        for(int i=0; i<n-k-1; i++){
            tail = tail.next;
        }
        ListNode newhead = tail.next;
        tail.next = null;
        return newhead;
    }
}