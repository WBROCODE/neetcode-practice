class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue(Collections.reverseOrder());
        minHeap = new PriorityQueue();
    }
    
    public void addNum(int num) {
        maxHeap.add(num);
        int val;
        if(!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()){

            minHeap.add(maxHeap.poll());
        }

        if(maxHeap.size() > minHeap.size() + 1){
            minHeap.add(maxHeap.poll());
        }

        if(maxHeap.size() + 1 < minHeap.size() ){
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        
        if(maxHeap.size() > minHeap.size()){
            return  (double) maxHeap.peek();
        }else if(maxHeap.size() < minHeap.size()){
            return  (double) minHeap.peek();
        }else{
            return  (double) (maxHeap.peek() + minHeap.peek()) / 2;
        }


    }
}
