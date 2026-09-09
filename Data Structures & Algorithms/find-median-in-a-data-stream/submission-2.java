class MedianFinder {
    PriorityQueue<Integer> min = new PriorityQueue<>();
    PriorityQueue<Integer> max = new PriorityQueue<>((a,b) -> b - a);
    public MedianFinder() {
        /**        
            3
            1
        */
    }
    
    public void addNum(int num) {
        if(min.size() > max.size()){
            min.offer(num);
            max.offer(min.poll());
        }else{
            max.offer(num);
            min.offer(max.poll());
        }
    }
    
    public double findMedian() {    
        return min.size() == max.size()? (double)(min.peek() + max.peek()) / 2.0 : (double)  min.peek();
    }
}
