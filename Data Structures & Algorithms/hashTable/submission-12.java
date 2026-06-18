class HashTable {
    int capacity;
    List<Pair>[]buckets;
    int size;
    public HashTable(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.buckets = new ArrayList[capacity];
    }

    public int hash(int key){
        return Math.abs(key % this.capacity);
    }

    public void insert(int key, int value) {
        int index = hash(key);
        if(buckets[index] != null){
            for(Pair p : buckets[index]){
                if(p.key == key){
                    p.val = value;
                    return;
                }
            }
        }else{
            buckets[index] = new ArrayList<>();
        }    
        buckets[index].add(new Pair(key, value));
        size++;
        if(size >= capacity * 0.5) resize();
    }

    public int get(int key) {
        int index = hash(key);
        if(buckets[index] != null){
            for(Pair p : buckets[index]){
                if(p.key == key){
                    return p.val;
                }
            }
        }
        return -1;
    }

    public boolean remove(int key) {
        int index = hash(key);
        if(buckets[index] != null){
            for(int i = 0; i < buckets[index].size(); i++){
                Pair p = buckets[index].get(i);
                if(p.key == key){
                    buckets[index].remove(i);
                    size--;
                    return true;
                }
            }
            return false;
        }else{
            return false;
        }
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void resize() {
        int old = capacity;
        capacity *= 2;
        List<Pair>[] newBuckets = new ArrayList[capacity];
        for(int i = 0; i < old; i++){
            List<Pair> pairs = buckets[i];
            if(pairs == null || pairs.isEmpty()) continue;
            for(Pair p : pairs){
                int index = hash(p.key);
                if(newBuckets[index] == null){
                    newBuckets[index] = new ArrayList<>();
                }
                newBuckets[index].add(p);
            }
        }
        this.buckets = newBuckets;
        
    }
}

class Pair{
    int key;
    int val;
    public Pair(int key, int val){
        this.key = key;
        this.val = val;
    }
}
