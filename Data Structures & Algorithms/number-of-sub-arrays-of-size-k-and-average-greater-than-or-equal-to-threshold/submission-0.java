class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int ans = 0;
        LinkedList<Integer> window = new LinkedList<>();
        int left = 0, right = 0;
        int len = arr.length;
        while(right < len){
            int num = arr[right];
            window.addLast(num);
            if(window.size() == k){
               if(average(window) >= threshold){
                    ans++;
               }
                window.removeFirst();
                left++;
            }
            right++;
        }

        return ans;
    }

    public int average(List<Integer> window){
        int total = 0, n = window.size();
        for(int num : window) total += num;
        return (int) total / n;
    }
}