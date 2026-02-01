class Solution {
    public int search(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
        
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[n - 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }


        int answer = doBinarySearch(nums, 0, left - 1, target);
        if (answer != -1) {
            return answer;
        }
        return doBinarySearch(nums, left, end, target);
    
    }

    private int getInflectionPoint(int[] nums) {

        int startIndex = 0;
        int endIndex = nums.length - 1;
        
        while (startIndex <= endIndex) {
            int mid = startIndex + (endIndex - startIndex) / 2;

            if (nums[mid] > nums[endIndex]) {
                startIndex = mid + 1;
            } 
            else {
                endIndex = mid;
            }
        }
        return startIndex;
    }


    private int doBinarySearch(int[] nums, int startIndex, int endIndex, int target) {

        while (startIndex <= endIndex) {
            int mid = startIndex + (endIndex - startIndex ) / 2;
            if (nums[mid] > target) {
                endIndex = mid - 1;
            } 
            else if (nums[mid] < target) {
                startIndex = mid + 1;
            } 
            else {
                return mid;
            }
        }
        return -1;
    }
}