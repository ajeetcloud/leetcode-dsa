/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {

        int startIndex = 1;
        int endIndex = n;

        while (startIndex <= endIndex) {
            int mid = startIndex + (endIndex - startIndex ) / 2;
            boolean isBad = isBadVersion(mid);
            if (!isBad) {
                startIndex = mid + 1;
            } 
            else {
                endIndex = mid - 1;
            }
        }
        return startIndex;
        
    }
}