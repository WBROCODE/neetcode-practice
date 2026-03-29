class DynamicArray {
    int[] arr;
    int size;
    int capacity;
    public DynamicArray(int capacity) {
        this.arr = new int[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    public int get(int i) {
        return arr[i];
    }

    public void set(int i, int n) {
        arr[i] = n;
    }

    public void pushback(int n) {
        if(size == capacity) resize();
        arr[size] = n;
        size++;
    }

    public int popback() {
        if(size > 0){
            size--;
        }
        return arr[size];
    }

    private void resize() {
        this.capacity *= 2;
        int[] newOne = new int[capacity];
        int index = 0;
        for(int i : arr){
            newOne[index++] = i;
        }
        arr = newOne;
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.capacity;
    }
}
