class BrowserHistory {
    
    class Node{
        private String page;
        private Node forward;
        private Node backward;
        
        public Node(String page, Node backward){
            this.page = page;
            this.backward = backward;
            this.forward = null;
        }
    }
    
    Node current;
    
    public BrowserHistory(String homepage) {
        current = new Node(homepage, null);    
    }
    
    public void visit(String url) {
        if(current.forward != null){
            current.forward.backward = null;
        }
        
        Node next = new Node(url, current);
        current.forward = next;
        current = next;
    }
    
    public String back(int steps) {
        while(steps-- > 0 && current.backward != null){
            current = current.backward;
        }
        return current.page;
    }
    
    public String forward(int steps) {
        while(steps-- > 0 && current.forward != null){
            current = current.forward;
        }
        return current.page;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */