class Solution {

    // Binary Search To Find The Left Bound of the Window - more Optimal
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        List<Integer> result = new ArrayList<>();

        int startIndex = 0;
        int endIndex = arr.length - k - 1;

        while (startIndex <= endIndex) {
            int mid = startIndex + (endIndex - startIndex) / 2;

            if (x - arr[mid] <= arr[mid + k] - x) {
                endIndex = mid - 1; // try better case, use startIndex
            } 
            else {
                startIndex = mid + 1;
            }
        }
        for (int i = startIndex; i < startIndex + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }

    // Binary Search + Sliding Window
    public List<Integer> findClosestElements1(int[] arr, int k, int x) {

        List<Integer> result = new ArrayList<>();

        int startIndex = 0;
        int endIndex = arr.length - 1;
        while (startIndex < endIndex) {
            int mid = startIndex + (endIndex - startIndex) / 2;
            if (arr[mid] >= x) {
                endIndex = mid;
            } else {
                startIndex = mid + 1;
            }
        }
        int closestIndex = startIndex;

        int i = closestIndex - 1;
        int j = closestIndex;
        // Sliding window solution
        while (j - i - 1 < k) {
            if (i < 0) {
                j++;
            } else if (j > arr.length - 1) {
                i--;
            } else {
                int left = arr[i];
                int right = arr[j];
                if (Math.abs(left - x) <= Math.abs(right - x)) {
                    i--;
                } else {
                    j++;
                }
            }
        }
        for (int start = i + 1; start < j; start++) {
            result.add(arr[start]);
        }

        return result;
    }
}