class LRUCache {
    /**
        A-B-C-D

        1 2 3 4    
        1 2 3 4

        size > capacity 

        size < capacity
    */
    int capacity;
    Map<Integer, ListNode> map;
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
        // remove cur, then add to tail
        if(!map.containsKey(key)){
            return -1;
        }else{
            ListNode cur = map.get(key);
            remove(cur);
            addToTail(cur);
            return cur.val;
        }
    }
    
    public void addToTail(ListNode cur){
        ListNode prevT = tail.prev;
        prevT.next = cur;
        cur.prev = prevT;
        tail.prev = cur;
        cur.next = tail;
    }

    public void remove(ListNode cur){
        if(cur == null || cur == head || cur == tail) return;
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
    }

    public void put(int key, int value) {
        // contains Update & make remove curNode, addToTail
        if(map.containsKey(key)){
            ListNode cur = map.get(key);
            cur.val = value;
            remove(cur);
            addToTail(cur);
        }else{
            // size > capacity -> remove head - addToTail
            if(map.size() < capacity){
                // add To Tail
                ListNode newCur = new ListNode(key, value);
                addToTail(newCur);
                map.put(key, newCur);
            }else{
                ListNode removed = head.next;
                map.remove(removed.key);
                remove(removed);
                ListNode newCur = new ListNode(key, value);
                addToTail(newCur);
                map.put(key, newCur);
            }   
        }

           
    }
}

class ListNode{
    ListNode prev;
    ListNode next;
    int key;
    int val;

    public ListNode(int key, int val){
        this.key = key;
        this.val = val;
        prev = null;
        next = null;
    }
}