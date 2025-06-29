class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int stick: sticks) {
            pq.offer(stick);
        }
        int sum = 0;
        while (pq.size() > 1) {
            int num1 = pq.poll();
            int num2 = pq.poll();
            int tempSum = num1 + num2;
            sum += tempSum;
            pq.offer(tempSum);
        }
        return sum;
    }
}