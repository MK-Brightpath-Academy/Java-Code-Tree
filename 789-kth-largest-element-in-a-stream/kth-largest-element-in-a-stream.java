class KthLargest {
  private PriorityQueue<Integer> minHeap;
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();

        // Add initial numbers
        for (int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
           // Add new value to heap
        minHeap.offer(val);

        // If heap grows beyond size k, remove smallest
        if (minHeap.size() > k) {
            minHeap.poll();
        }

        // The root is now the kth largest
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */