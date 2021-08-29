class MyHashMap {

    private static final int BUCKETS_SIZE = 1000001;
    private class Entry {
        private int key;
        private int value;
        
        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private LinkedList<Entry>[] entries;

    /** Initialize your data structure here. */
    public MyHashMap() {
        entries = new LinkedList[BUCKETS_SIZE];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = hash(key);
        
        if(entries[index] == null)
            entries[index] = new LinkedList<>();
       
        LinkedList<Entry> bucket = entries[index];
        
        if(!bucket.isEmpty()){
            for(Entry entry : bucket){
                if(entry.key == key){
                    entry.value = value;
                    return;
                }
            }
        } 
        bucket.addLast(new Entry(key, value));
    } 
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = hash(key);
        
        LinkedList<Entry> bucket = entries[index];
        
        if(bucket != null){
            for(Entry entry : bucket){
                if(entry.key == key)
                    return entry.value;
            }
        }
        
        return -1;
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = hash(key);
        
        LinkedList<Entry> bucket = entries[index];
        
        if(bucket == null) return;
        
        for(Entry entry : bucket){
            if(entry.key == key){
                bucket.remove(entry);
                return;
            }
        }
        
    }
    
    // Returns hashcode
    public int hash(int key) {
        return key % entries.length;
    }
} 


/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
