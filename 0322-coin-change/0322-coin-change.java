class Solution {
    public int coinChange(int[] coins, int amount) {


        // DP solution
        int[] dp = new int[amount + 1];
        return dpSolution(coins, dp, amount);

        /*
        // Memo solution
        int[] memo = new int[amount + 1];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = -2;
        }
        return memoSolution(coins, amount, memo);
        */

        /*
        // Backtracking solution
        return bt(coins, amount);
        */

    }

    private int dpSolution(int[] coins, int[] dp, int amount) {

        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i < dp.length; i++) {
            int amt = i;
            for (int coin: coins) {
                if (amt >= coin) {
                    dp[i] = Math.min(dp[i], 1 + dp[amt - coin]);
                }
            }
        }
        
        return dp[amount] > amount ? -1 : dp[amount];
    }

    private int memoSolution(int[] coins, int amount, int[] memo) {
        // TASK
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (memo[amount] != -2) {
            return memo[amount];
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int ans = memoSolution(coins, amount - coins[i], memo); // ans is of amount
            if (ans != -1) {
                result = Math.min(result, 1 + ans);
            }
        }

        memo[amount] = result == Integer.MAX_VALUE ? -1 : result;
        return memo[amount];
    }

    private int bt(int[] coins, int amount) {
        // TASK
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int ans = bt(coins, amount - coins[i]);
            if (ans != -1) {
                result = Math.min(result, 1 + ans);
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}