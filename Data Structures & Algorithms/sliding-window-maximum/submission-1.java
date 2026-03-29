class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int n = nums.length;
        if(k > n) return new int[]{};
        MQ mq = new MQ();
        for(int i = 0; i < k; i++){
            mq.offer(nums[i]);
        }
        List<Integer> ans = new ArrayList<>();
        ans.add(mq.max());
        for(int i = k; i < n; i++){
            int num = nums[i];
            mq.offer(num);
            mq.poll();
            ans.add(mq.max());
        }

        int[] res = new int[n - k + 1];
        for(int i = 0; i < res.length; i++){
            res[i] = ans.get(i);
        }
        return res;
    }
}

/**


            left: max
  2 1 0



*/

class MQ{
    Deque<Integer> deque;
    int max;
    int countMax;
    public MQ(){
        deque = new ArrayDeque<>();
        max = Integer.MIN_VALUE;
    }

    public void offer(int x){
        if(max < x){
            max = x;
            countMax = 1;
        }else if(max == x){
            max = x;
            countMax++;
        }
        deque.offerLast(x);
    }

    public void poll(){
        if(deque.isEmpty()) return;
        int front = deque.pollFirst(); 
        if(front == max){        
            updateMax();
        }
    }

    public int max(){
        return this.max;
    }

    public void updateMax(){
        if(countMax > 1){  
            countMax--;
            return;
        }
        int newMax = Integer.MIN_VALUE;
        int newCount = 0;
        for(int num : deque){
            if(num > newMax){
                newMax = num;
                newCount = 1;
            } else if(num == newMax){
                newCount++;
            }
        }
        this.max = newMax;
        this.countMax = newCount;
        
    }

}
