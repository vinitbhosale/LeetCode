class UndergroundSystem {
    class Event {
        private int id;
        private String stationName;
        private int time;
        
        public Event(int id, String stationName, int time){
            this.id = id;
            this.stationName = stationName;
            this.time = time;
        }
    }
    class Average {
        
        private double total = 0;
        private int count  = 0;
        
        public void updateAverage(int diff){
            count += 1;
            total += diff;
        }
        
        public double getAverage(){
            return total / count;
        }
        
    }

    Map<Integer, Event> arrivals;
    Map<String, Average> averages;
        
    public UndergroundSystem() {
        arrivals = new HashMap<>();
        averages = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        arrivals.put(id, new Event(id, stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Event arrivalEvent = arrivals.get(id);
        arrivals.remove(id);
        
        int diff = t - arrivalEvent.time;
        String key = arrivalEvent.stationName+","+stationName;
        
        Average average = averages.containsKey(key) ? averages.get(key) : new Average();
        
        average.updateAverage(diff);
        //average.getAverage();
        
        averages.put(key, average);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String key = startStation+","+endStation;
        return averages.get(key).getAverage();
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */