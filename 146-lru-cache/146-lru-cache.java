class LRUCache {
    
   class Node {
        private int key;
        private int value;
        private Node next;
        private Node prev;
        
        public Node() {
            
        }
        
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private int cacheCapacity;
    private Map<Integer, Node> map;

    private final Node head = new Node();
    private final Node tail = new Node();
    
    public LRUCache(int capacity) {
        cacheCapacity = capacity;
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        int res = -1;
        
        Node node = map.get(key);
        
        if(node != null) {
            
            res = node.value;
            // remove the node from linkedList and add to the beginning to make it most recent
            removeFromLinkedList(node);
            addToLinkedList(node);
        }
        
        return res;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        // if key already present then change the value and make it recently used
        if(node != null) {
            removeFromLinkedList(node);
            node.value = value;
            addToLinkedList(node);
        }else{
            // check the cache size if full remove the least used node  i.e prev of tail
            if(map.size() == cacheCapacity){
                map.remove(tail.prev.key);
                removeFromLinkedList(tail.prev);
            }
             // Add the node to the map and linkedList
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addToLinkedList(newNode);
        }
  
    }
    
    private void addToLinkedList(Node node) {
        //check for the next node as the recent new Node should be first
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;
    }
    
    private void removeFromLinkedList(Node node) {
        // store the next and prev node of the node need to be delete
        Node nextNode = node.next;
        Node prevNode = node.prev;
        
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */