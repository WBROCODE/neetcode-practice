class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        MQ mq = new MQ();
        for(int i = 0; i < k; i++){
            mq.offer(nums[i]);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = mq.max();

        for(int i = k; i < n; i++){
            mq.offer(nums[i]);
            mq.pop(nums[i - k]);
            ans[i - k + 1] = mq.max();
        }

        return ans;
    }
}

class MQ{
    Deque<Integer> dq;

    public MQ(){
        dq = new LinkedList<>();
    }

    public void offer(int x){
        while(!dq.isEmpty() && dq.getLast() < x){
            dq.pollLast();
        }
        dq.offerLast(x);
    }

    public void pop(int x){
        if(dq.peekFirst() == x) dq.pollFirst();
    }

    public int max(){
        return dq.peekFirst();
    }

}
