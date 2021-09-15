/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    // Time Complexity O(N) and Space Complexity O(N)
    
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        
        Map<Node, Node> visited = new HashMap<>();
        
        // create reference for original list
        Node current = head;
        // create refernce for new list;
        Node newNode = new Node(-1);
        Node copy = newNode;
        
        while(current != null){
            copy.next = new Node(current.val);
            copy = copy.next;
            visited.put(current, copy);
            current = current.next;            
        }
        
        current = head;
        copy = newNode.next;
        
        while(current != null){
            copy.random = visited.get(current.random);
            copy = copy.next;
            current = current.next;
        }
        
        return newNode.next;
    }
    
//------------------------------------OPTIMIZE--------------------------------------//
    
    // Time Complexity O(N) and Space Complexity O(1)
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        
        Node current = head;
        
        while(current != null){
            Node copy = new Node(current.val);
            copy.next = current.next;
            current.next = copy;
            current = current.next.next;
        }
        
        current = head;
        while(current != null){
            current.next.random = current.random == null ? null : current.random.next;
            current = current.next.next;
        }
        
        Node newList = new Node(-1);
        Node copy = newList;
        current = head;
        
        while(current != null){
            copy.next = current.next;
            copy = copy.next;
            current.next = current.next.next;
            current = current.next;
        }
        
        return newList.next;
   } 
}
