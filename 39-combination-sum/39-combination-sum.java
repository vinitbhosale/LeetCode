class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        backtrack(candidates, 0, target, new ArrayList<>(), result);
        
        return result;
    }
    
    public void backtrack(int[] canditates, int start, int target, List<Integer> list, 
                          List<List<Integer>> result){
        
        if(target < 0)
            return;
        if(target == 0)
            result.add(new ArrayList<>(list));
        
        for(int i = start; i < canditates.length; i++){
            list.add(canditates[i]);
            backtrack(canditates, i, target - canditates[i], list, result);
            list.remove(list.size() - 1);
        }
    }
}