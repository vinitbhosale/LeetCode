class Solution {
    // Time Complexity O(nlogN) and Space Complexity O(log N)
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1){
            return intervals;
        }
        
        // Sorting the array based on the start time
        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        
        List<int[]> output = new ArrayList<int[]>();
        int[] current_interval = intervals[0];
        
        // Adding the first interval into the output
        output.add(current_interval);
        
        for(int[] interval : intervals){
            int current_end = current_interval[1];
            int next_start = interval[0];
            int next_end = interval[1];
            
            // if end of the current is greater than th start of the next interval we update the end of the current with the end of the next interval
            if(current_end >= next_start){
                current_interval[1] = Math.max(current_end, next_end);
            }else{
                current_interval = interval;
                output.add(current_interval);
            }
        }
        
        return output.toArray(new int[output.size()][]);
    }
}