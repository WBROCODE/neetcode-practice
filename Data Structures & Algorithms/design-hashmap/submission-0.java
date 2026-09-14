class MyHashMap {
    List<Pair> buckets;
    public MyHashMap() {
        buckets = new ArrayList<>();
    }   
    
    public void put(int key, int value) {
        for(Pair p : buckets){
            if(p.key == key){
                p.val = value;
                return;
            }
        }
        buckets.add(new Pair(key, value));
    }
    
    public int get(int key) {
        for(Pair p : buckets){
            if(p.key == key){
                return p.val;
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        for(int i = 0; i < buckets.size(); i++){
            Pair p = buckets.get(i);
            if(p.key == key){
                buckets.remove(i);
                return;
            }
        } 
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

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */