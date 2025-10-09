class MedianFinder {

     PriorityQueue<Integer>  max = new PriorityQueue<>(Collections.reverseOrder()); // maintaining max elements

     PriorityQueue<Integer>  min = new PriorityQueue<>();// maintaining min eleements


    public MedianFinder() {
        
    }
    
    public void addNum(int num) 
    {
        max.offer(num);
        min.offer(max.poll());

        if(min.size()>max.size())
        {
            max.offer(min.poll());
        }
        
    }
    
    public double findMedian() 
    {
        if(max.size()>min.size()) return max.peek(); // odd size

        else 
        {
            return (max.peek()+min.peek())/2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */