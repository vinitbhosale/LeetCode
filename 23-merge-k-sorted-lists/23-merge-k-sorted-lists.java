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
    
    // Divide and Conquer Time Complexity O(NLogK) Space O(1)
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0 || lists == null) return null;
        
        return divideKLists(lists, 0, lists.length - 1);
    }
    
    private ListNode divideKLists(ListNode[] lists, int start, int end){
        // base condition
        if(start == end)
            return lists[start];
        
        int mid = start + (end - start) / 2;
        
        ListNode left = divideKLists(lists, start, mid);
        ListNode right = divideKLists(lists, mid + 1, end);
        
        return merge(left, right);
    }
    
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode result = new ListNode(-1);
        ListNode current = result;
        
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                current.next = l1;
                l1 = l1.next;
            }else{
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if(l1 != null){
            current.next = l1;
        }
        if(l2 != null){
            current.next = l2;
        }
        return result.next;
    }
}