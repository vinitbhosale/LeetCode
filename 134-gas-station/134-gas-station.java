class Solution {
    // Brute Force Time Complexity O(N^2) and Space COmplexity O(1)
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length; // #station
        
        // for each station i (starting point)
        for (int i = 0; i < n; ++i) { 
            // refuel at starting point
            int gallon = gas[i]; 
            // isAmple: is it a valid starting point
            boolean isAmple = true; 
            
            // we need to check n stations
            // note: nextStation is the one we need to check
            //       currStation is denoted because the cost information is in it
            for (int j = 0; j < n; ++j) {
                
                int currStation = (i + j) % n;
                
                int nextStation = (currStation + 1) % n;
                
                gallon -= cost[currStation];
                
                // not reachable from currStation to nextStation
                if (gallon < 0) { 
                    isAmple = false;
                    break;
              }
                // refuel in nextStation
                gallon += gas[nextStation]; 
            }   
            if (isAmple) return i;
        }
        return -1;
    }
  
    
//------------------------------------------Optimize-------------------------------------------------------------// 
    // One pass Approach Time Complexity O(N) and Space Complexity O(1)
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        
        int totalGas = 0;
        int currentGas = 0;
        int startPoint = 0;
        
        for(int i = 0; i < n; i++){
            totalGas += gas[i] - cost[i];
            currentGas += gas[i] - cost[i];
            
            if(currentGas < 0 ){
                startPoint = i + 1;
                currentGas = 0;
            }
        }
        
        return totalGas >= 0 ? startPoint : -1;
    }
}
