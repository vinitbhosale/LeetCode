class Logger {
    public Map<String, Integer> count;
    /** Initialize your data structure here. */
    public Logger() {
        count = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!count.containsKey(message)){
            count.put(message, timestamp);
            return true;
        }
        int oldTimestamp = count.get(message);
        if(timestamp - oldTimestamp >= 10){
            count.put(message, timestamp);
            return true;
        }else
            return false;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */