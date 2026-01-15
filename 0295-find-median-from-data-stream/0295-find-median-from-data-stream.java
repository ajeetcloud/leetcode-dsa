/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
class MedianFinder {

    PriorityQueue<Integer> maxHeap; // 1st Half
    PriorityQueue<Integer> minHeap; // 2nd Half

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (maxHeap.isEmpty() || num >= maxHeap.peek()) {
            minHeap.offer(num);
        } else {
            maxHeap.offer(num);
        }
        if (Math.abs(maxHeap.size() - minHeap.size()) > 1) {
            balance();
        }
    }

    public void balance() {
        int s1 = maxHeap.size(); 
        int s2 = minHeap.size();
        if (s1 - s2 > 1) {
            minHeap.offer(maxHeap.poll());
        } else if (s2 - s1 > 1) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        int s1 = maxHeap.size(); 
        int s2 = minHeap.size();
        if (s1 == s2) {
            return (double)(maxHeap.peek() + minHeap.peek()) / 2;
        } else if (s1 > s2) {
            return maxHeap.peek();
        } else {
            return minHeap.peek();
        }
    }
}