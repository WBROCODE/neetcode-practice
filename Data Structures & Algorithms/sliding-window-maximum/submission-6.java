class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        MQ mq = new MQ();

        for(int i = 0; i < k - 1; i++){
            mq.push(nums[i]);
        }
        int n = nums.length;
        int index = 0;
        int[]ans = new int[n - k + 1];
        for(int i = k - 1; i < n; i++){
            mq.push(nums[i]);
            ans[index++] = mq.max();
            mq.pop(nums[i - k + 1]);
        }
        return ans;
    }
}

class MQ{
    Deque<Integer> dq;

    public MQ(){
        dq = new ArrayDeque<>();
    }

    public void push(int x){
        while(!dq.isEmpty() && dq.peekLast() < x){
            dq.pollLast();
        }
        dq.offerLast(x);
    }

    public void pop(int x){
        if(dq.isEmpty()) return;
        if(x == dq.peekFirst()) dq.removeFirst();
    }

    public int max(){
        return dq.peekFirst();
    }

}

