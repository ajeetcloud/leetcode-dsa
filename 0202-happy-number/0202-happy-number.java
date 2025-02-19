class Solution {
    public boolean isHappy(int n) {
      int slow = n;
      int fast = getSquaresSum(n);
      while (slow != fast) {
        if (fast == 1) {
          return true;
        }
        slow = getSquaresSum(slow);
        fast = getSquaresSum(getSquaresSum(fast));
      }
      return fast == 1;
    }

    public int getSquaresSum(int n) {
      int sum = 0;
      int digit = 0;
      while (n > 0) {
        digit = n % 10;
        sum = sum + (digit * digit);
        n = n / 10;
      }
      return sum;
    }
}