class Solution {
    public int rob(int[] houses) {
        
        if(houses.length == 0){
            return 0;
        }
        if(houses.length == 1){
            return houses[0];
        }
        
        int[] storage = new int[houses.length];
        storage[0] = houses[0];
        storage[1] = Math.max(houses[1], houses[0]);
        for (int i = 2; i < houses.length; i++) {
            storage[i] = Math.max(houses[i] + storage[i - 2], storage[i - 1]);
        }
        return storage[houses.length - 1];
    }
}