class MinHeap {
    List<Integer> heap;
    public MinHeap() {
        heap = new ArrayList<>();
    }

    public void push(int val) {
        heap.add(val);
        int i = heap.size() - 1;
        while(i > 0 && heap.get((i - 1) / 2) > heap.get(i)){
            swap((i - 1) / 2, i);
            i = (i - 1) / 2;
        }
    }

    public Integer pop() {
        if (heap.isEmpty()) return -1;
        if(heap.size() == 1) return heap.remove(0);
        int top = heap.get(0), last = heap.remove(heap.size() - 1);
        int n = heap.size();
        heap.set(0, last);

        int i = 0;
        // left = 2 * i + 1 right = 2 * i + 2 
        while(true){
            int left = 2 * i + 1, right = 2 * i + 2, smallest = i;
            if(left < n && heap.get(smallest) > heap.get(left)) smallest = left;
            if(right < n && heap.get(smallest) > heap.get(right)) smallest = right;
            if(smallest == i) break;
            swap(i, smallest);
            i = smallest;
        }
        return top;
    }

    public Integer top() {
        if (heap.isEmpty()) return -1;
        return heap.get(0);
    }

    public void heapify(List<Integer> nums) {
        heap.clear();
        for(int num : nums) heap.add(num);
        int n = heap.size();
        for(int i = n / 2 - 1; i >= 0; i--){
            // left = 2 * i + 1 right = 2 * i + 2 
            while(true){
                int left = 2 * i + 1, right = 2 * i + 2, smallest = i;
                if(left < n && heap.get(smallest) > heap.get(left)) smallest = left;
                if(right < n && heap.get(smallest) > heap.get(right)) smallest = right;
                if(smallest == i) break;
                swap(i, smallest);
                i = smallest;
            }
        }
    }

    public void swap(int i, int j){
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
