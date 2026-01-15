class MedianFinder {

    PriorityQueue<Integer> maxHeap; // 1st Half
    PriorityQueue<Integer> minHeap; // 2nd Half
    int s1;
    int s2;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
        s1 = maxHeap.size();
        s2 = minHeap.size();
    }
    
    public void addNum(int num) {
        s1 = maxHeap.size();
        s2 = minHeap.size();
        if (s1 == 0 && s2 == 0) {
            maxHeap.offer(num);
            return;
        }

        int firstHalfMax = maxHeap.peek();
        if (num >= firstHalfMax) {
            minHeap.offer(num);
        } else {
            maxHeap.offer(num);
        }
        if (Math.abs(maxHeap.size() - minHeap.size()) > 1) {
            balance();
        }
    }

    public void balance() {
        s1 = maxHeap.size(); 
        s2 = minHeap.size();
        if (s1 - s2 > 1) {
            int max = maxHeap.poll();
            minHeap.offer(max);
        } else if (s2 - s1 > 1) {
            int min = minHeap.poll();
            maxHeap.offer(min);
        }
    }
    
    public double findMedian() {
        s1 = maxHeap.size(); 
        s2 = minHeap.size();
        if (s1 == s2) {
            return (double)(maxHeap.peek() + minHeap.peek()) / 2;
        } else if (s1 > s2) {
            return maxHeap.peek();
        } else {
            return minHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */