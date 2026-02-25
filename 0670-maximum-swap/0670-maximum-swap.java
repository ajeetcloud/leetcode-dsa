class Solution {
    public int maximumSwap(int num) {

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
        return num;  // if already maximum
    }
}