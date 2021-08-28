class Solution {
    // Time Complexity O(NlogN) and Space Complexity O(N)
    public int minMeetingRooms(int[][] intervals) {
        
        if(intervals.length == 0){
            return 0;
        }
        
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        
        for(int i = 0; i < intervals.length; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        
        Arrays.sort(start);
        
        Arrays.sort(end);
        
        int  start_pointer = 0;
        int  end_pointer = 0;
        
        int usedRooms = 0;
        
        //Start [0, 5, 15]
        //End [10, 20, 30]
        
        while(start_pointer < intervals.length){
            if(start[start_pointer] >= end[end_pointer]){
                usedRooms -= 1;
                end_pointer += 1;
            }
            
            usedRooms += 1;
            start_pointer += 1;
        }
        
        return usedRooms;
    }
}