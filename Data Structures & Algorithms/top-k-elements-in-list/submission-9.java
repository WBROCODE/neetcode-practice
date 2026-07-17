class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        /**
            0 1 2 3 4 5
            1,2,2,3,3,3
            M: unique element
            N: length of nums
            TC: N + M * logK         
            SC: K + M


            Map->freq
            PQ-> k -> min    
        */
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
                        (a, b) -> Integer.compare(
                                frequencyMap.get(a),
                                frequencyMap.get(b)
                        ));

        for (int num : frequencyMap.keySet()) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] ans = new int[k];
        int i = 0;

        while(!minHeap.isEmpty()){
            ans[i++] = minHeap.poll();
        }

        return ans;
    }
}
