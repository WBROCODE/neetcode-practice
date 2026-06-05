class LRUCache {
    Map<Integer, ListNode> map;
    int capacity;
    ListNode head;
    ListNode tail;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
         // return val, make LRU, put to tail
        if(map.containsKey(key)){
            ListNode cur = map.get(key);
            removeNode(cur);
            addTail(cur);
            return cur.val;
        }else return -1;
       
        // -1
    }
    
    public void put(int key, int value) {
        // < capacity
        // put to tail
        if(map.containsKey(key)){
            ListNode cur = map.get(key);
            cur.val = value;
            removeNode(cur);
            addTail(cur);
        }else{
            if(map.size() < capacity){
            ListNode cur = new ListNode(key, value); 
            map.put(key, cur);
            addTail(cur);
            }else if(map.size() == capacity){
                ListNode oldH = head.next;
                removeNode(oldH);
                map.remove(oldH.key);
                ListNode cur = new ListNode(key, value); 
                map.put(key, cur);
                addTail(cur);
            }
        }
        
       
        // > remove head put to tail
    }

    public void removeNode(ListNode node){
        ListNode prev = node.prev;
        ListNode next = node.next;
        prev.next = next;
        next.prev = prev;
        node.prev = null;
        node.next = null;
    }

    public void addTail(ListNode node){
        ListNode oldT = tail.prev;
        ListNode newT = node;
        oldT.next = newT;
        newT.prev = oldT;
        newT.next = tail;
        tail.prev = newT;
    }
}

class ListNode{
    int key;
    int val;
    ListNode prev;
    ListNode next;
    public ListNode(int key, int val){
        this.key = key;
        this.val = val;
        prev = null;
        next = null;
    }
}
