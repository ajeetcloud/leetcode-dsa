class Solution {
    public int coinChange(int[] coins, int amount) {
        int storage[] = new int[amount + 1];
        for (int i = 0; i < storage.length; i++) {
          storage[i] = amount + 1;
        }
        storage[0] = 0;
        for (int i = 1; i < storage.length; i++) {
          for (int c = 0; c < coins.length; c++) {
            int coin = coins[c];
            if (i - coin < 0) {
              continue;
            }
            storage[i] = Math.min(storage[i], storage[i - coin] + 1);
          }
          
        }
        return storage[amount] == amount + 1 ? -1 : storage[amount];

    }
}