class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int startIndex = 1;         // minSpeed
        int endIndex = piles[0];    // maxSpeed

        for (int i = 1; i < piles.length; i++) {
            endIndex = Math.max(endIndex, piles[i]);
        }

        while (startIndex <= endIndex) {
            int mid = startIndex + (endIndex - startIndex) / 2;
            // calculate validity
            boolean result = canFinishInTime(mid, piles, h);
            if (result) {
                endIndex = mid - 1; // valid, try smaller branch
            } else {
                startIndex = mid + 1;
            }
        }
        return startIndex;
    }

    public boolean canFinishInTime(int speed, int[] piles, int h) {

        long sumHours = 0;
        for (int pile : piles) {
            sumHours += (pile + speed - 1) / speed;
        }
        return sumHours <= h;
    }
}