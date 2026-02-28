class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int tank = 0;
        int totalSurplus = 0;
        int candidate = 0;

        for (int i = 0; i < gas.length; i++) {
            
            tank += gas[i] - cost[i];
            totalSurplus += gas[i] - cost[i];
            if (tank < 0) {
                tank = 0;
                candidate =  i + 1;
            }
        }

        if (totalSurplus >= 0) {
            return candidate;
        }
        return -1;
    }
}