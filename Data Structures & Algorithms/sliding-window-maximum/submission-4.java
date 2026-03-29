class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int n = nums.length;
        if(k > n) return new int[]{};
        MQ mq = new MQ();
        for(int i = 0; i < k; i++){
            mq.offer(nums[i]);
        }
        int[] res = new int[n - k + 1];
        res[0] = mq.max();
        for(int i = k; i < n; i++){
            int num = nums[i];
            mq.offer(num);
            mq.poll(nums[i - k]);
            res[i - k + 1] = mq.max();
        }

        return res;
    }
}

/**

            left: max
  2 1 0



*/

class MQ{
    LinkedList<Integer> linkedList;
    
    public MQ(){
        linkedList = new LinkedList<>();
    }

    public void offer(int x){
        while(!linkedList.isEmpty() && x > linkedList.getLast()){
            linkedList.removeLast();
        }
        linkedList.addLast(x);
    }

    public void poll(int x){
        if(!linkedList.isEmpty() && x == linkedList.getFirst()){
            linkedList.removeFirst();
        }
    }

    public int max(){
        return linkedList.getFirst();
    }

}
