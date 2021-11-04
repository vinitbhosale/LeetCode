class OrderedStream {
    // Time Complexity O(N) and Space Complecity O(N)
    String[] values;
    int pointer;
    
    public OrderedStream(int n) {
        values = new String[n];
        pointer = 0;
    }
    
    public List<String> insert(int idKey, String value) {
        values[idKey - 1] = value;
        List<String> result = new ArrayList<>();
        
        while(pointer < values.length && values[pointer] != null){
            result.add(values[pointer++]);
        }
        
        return result;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */