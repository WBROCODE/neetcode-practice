class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> nums = new Stack();

        for(String o : operations){
            if(o.equals("C") && !nums.isEmpty()){
                nums.pop();
            }else if(o.equals("D")){
                int top = nums.peek();
                nums.push(top * 2);
            }else if(o.equals("+")){
                int one = nums.pop();
                int two = nums.pop();
                int newT = one + two;
                nums.push(two);
                nums.push(one);
                nums.push(newT);
            }else{
                nums.push(Integer.parseInt(o));
            }
        }
        int ans = 0;

        while(!nums.isEmpty()){
            ans += nums.pop();
        }
        return ans;
    }

}