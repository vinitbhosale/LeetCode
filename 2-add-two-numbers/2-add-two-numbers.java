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
    // Time Complexity O(max(m,n)) Space O(max(m,n))
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(l1 == null || l2 == null) return null;
        
        ListNode head = new ListNode(0);
        ListNode l3 = head;
        int carry = 0;
        
        while(l1 != null || l2 !=null){
            int l1_val = (l1 != null) ? l1.val:0;
            int l2_val = (l2 != null) ? l2.val:0;
            
            int sum = l1_val + l2_val + carry;
            carry = sum/10;
            int last_digit = sum % 10;
            
            ListNode new_node = new ListNode(last_digit);
            l3.next = new_node;
            
            
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
            
            l3 = l3.next;
        }
        if(carry > 0){
            ListNode new_node = new ListNode(carry);
            l3.next = new_node;
            l3 = l3.next;
            
        }
        
        return head.next;

    }
}