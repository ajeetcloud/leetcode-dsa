class Solution {
    public boolean makesquare(int[] matchsticks) {
        Arrays.sort(matchsticks);

        int sum = 0;
        int squareSide = 0;
        for (int matchstick : matchsticks) {
            sum += matchstick;
        }
        if (sum % 4 != 0) {
            return false;
        }
        squareSide = sum / 4;
        for (int matchstick : matchsticks) {
            if (matchstick > squareSide) {
                return false;
            }
        }
        int topSide = 0;
        int rightSide = 0;
        int bottomSide = 0;
        int leftSide = 0;

        return backtrack(matchsticks, matchsticks.length - 1, topSide, rightSide, bottomSide, leftSide, squareSide);

    }

    private boolean backtrack(int[] matchsticks, int index, int topSide, int rightSide, int bottomSide, int leftSide,
            int squareSide) {

        if (index < 0) {
            return topSide == rightSide && rightSide == bottomSide && bottomSide == leftSide && leftSide == squareSide;
        }

        int currentStick = matchsticks[index];

        if ((topSide + currentStick <= squareSide) && backtrack(matchsticks, index - 1, topSide + currentStick,
                rightSide, bottomSide, leftSide, squareSide)) {
            return true;
        }

        if ((rightSide + currentStick <= squareSide) && backtrack(matchsticks, index - 1, topSide,
                rightSide + currentStick, bottomSide, leftSide, squareSide)) {
            return true;
        }

        if ((bottomSide + currentStick <= squareSide) && backtrack(matchsticks, index - 1, topSide, rightSide,
                bottomSide + currentStick, leftSide, squareSide)) {
            return true;
        }

        if ((leftSide + currentStick <= squareSide) && backtrack(matchsticks, index - 1, topSide, rightSide, bottomSide,
                leftSide + currentStick, squareSide)) {
            return true;
        }

        return false;
    }
}