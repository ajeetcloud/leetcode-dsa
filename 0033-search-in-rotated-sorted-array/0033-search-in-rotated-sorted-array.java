class Solution {
    public int search(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
        int inflectionPoint = getInflectionPoint(nums);

        int answer = doBinarySearch(nums, 0, inflectionPoint - 1, target);
        if (answer != -1) {
            return answer;
        }
        return doBinarySearch(nums, inflectionPoint, end, target);
    
    }

    private int getInflectionPoint(int[] nums) {

        int startIndex = 0;
        int endIndex = nums.length - 1;
        
        while (startIndex <= endIndex) {
            int mid = startIndex + (endIndex - startIndex) / 2;

            if (nums[mid] > nums[nums.length - 1]) {
                startIndex = mid + 1;
            } 
            else {
                endIndex = mid - 1;
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