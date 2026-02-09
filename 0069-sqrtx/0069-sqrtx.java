class Solution {
    public int mySqrt(int x) {

        if (x == 0 || x == 1) {
            return x;
        }

        int startIndex = 2;
        int endIndex = x / 2;

        while (startIndex <= endIndex) {
            int mid = startIndex + (endIndex - startIndex) / 2;
            long square = (long) mid * mid;

            if (square == x) {
                return mid;
            } 
            else if (square < x) {
                startIndex = mid + 1;
            }
            else {
                endIndex = mid - 1;
            }
        }
        return endIndex;
    }
}