class Solution {
    public int change(int amount, int[] coins) {
      int coinsLength = coins.length;
      int storage[][] = new int[coinsLength + 1][amount + 1];
      for (int i = 0; i < storage.length; i++) {
        storage[i][0] = 1;
      }
      for (int i = coinsLength - 1; i >= 0; i--) {
        int coin = coins[i];
        for (int j = 0; j <= amount; j++) {
          if (coin > j) {
            storage[i][j] = storage[i + 1][j];
          } else {
            storage[i][j] = storage[i + 1][j] + storage[i][j - coin];
          }
        }
      }

      return storage[0][amount];
    }
}