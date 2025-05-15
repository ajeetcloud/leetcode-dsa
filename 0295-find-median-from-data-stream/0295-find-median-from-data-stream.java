class MedianFinder {

  PriorityQueue<Integer> pqMinHeap;
  PriorityQueue<Integer> pqMaxHeap;

  public MedianFinder() {
    pqMinHeap = new PriorityQueue<>();
    pqMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
  }

  public void addNum(int num) {
    if (pqMaxHeap.isEmpty() || num <= pqMaxHeap.peek()) {
      pqMaxHeap.offer(num);
    } else {
      pqMinHeap.offer(num);
    }
    // Balancing step
    if (pqMaxHeap.size() > pqMinHeap.size() + 1) {
      pqMinHeap.offer(pqMaxHeap.poll());
    } else if (pqMinHeap.size() > pqMaxHeap.size() + 1) {
      pqMaxHeap.offer(pqMinHeap.poll());
    }

  }

  public double findMedian() {
    int minSize = pqMinHeap.size();
    int maxSize = pqMaxHeap.size();
    if (maxSize > minSize) {
      return (double) pqMaxHeap.peek();
    } else if (minSize > maxSize) {
      return (double) pqMinHeap.peek();
    } else if (maxSize > 0 && minSize > 0 && maxSize == minSize) {
      return (double) (pqMaxHeap.peek() + pqMinHeap.peek()) / 2;
    }
    return 0d;
  }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */