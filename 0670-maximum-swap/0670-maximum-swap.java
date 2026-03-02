class Solution {

    // One pass, space optimal solution
    public int maximumSwap(int num) {

        char digits[] = String.valueOf(num).toCharArray();

        int smallIndex = -1; // stores index of small position(left)

        int maxRightIndex = digits.length - 1;
        int largeIndex = digits.length - 1; // stores index of large position(right)
        int maxNumTillNow = digits[largeIndex] - '0'; // assume rightmost is my max

        for (int i = largeIndex - 1; i >= 0; i--) {

            int currNum = digits[i] - '0';
            if (currNum > maxNumTillNow) {
                maxNumTillNow = currNum;
                maxRightIndex = i;
            } else if (currNum < maxNumTillNow) {
                // swapping candidate found
                smallIndex = i;
                largeIndex = maxRightIndex;
            }
        }

        if (smallIndex != -1) {
            // swap between smallIndex & largeIndex
            char temp = digits[smallIndex];
            digits[smallIndex] = digits[largeIndex];
            digits[largeIndex] = temp;

            return Integer.parseInt(new String(digits));
        }
        return num;
    }

    // Not sapce optimal
    public int maximumSwap1(int num) {

        char[] digits = Integer.toString(num).toCharArray();

        int[] lastIndex = new int[10];
        for (int i = 0; i < digits.length; i++) {
            int numIndex = digits[i] - '0';
            lastIndex[numIndex] = i;
        }

        for (int i = 0; i < digits.length; i++) {

            int currrentNum = digits[i] - '0';
            for (int j = 9; j > currrentNum; j--) {
                if (lastIndex[j] > i) {
                    // swap
                    int posA = i;
                    int posB = lastIndex[j];

                    char temp = digits[posA];
                    digits[posA] = digits[posB];
                    digits[posB] = temp;

                    // create number
                    int result = 0;
                    for (int k = 0; k < digits.length; k++) {
                        int d = digits[k] - '0';
                        result = (result * 10) + d;
                    }
                    return result;
                }
            }

        }
        return num; // if already maximum
    }
}