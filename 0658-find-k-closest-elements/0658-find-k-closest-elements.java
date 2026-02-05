class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

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

        int count = k - 1;
        int i = closestIndex - 1;
        int j = closestIndex;
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