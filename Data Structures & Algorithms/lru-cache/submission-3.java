class LRUCache {
    int capacity;
    Map<Integer, ListNode> map;
    ListNode head;
    ListNode tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
                // remove
        ListNode cur = map.get(key);
        remove(cur);
        // add Last
        addLast(cur);
        return cur.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            ListNode cur = map.get(key);
            cur.val = value;
            remove(cur);
            addLast(cur);
        }else{
            if(map.size() < capacity){
                ListNode cur = new ListNode(key, value);
                map.put(key, cur);
                addLast(cur);
            }else if(map.size() == capacity){
                ListNode oldH = head.next;
                map.remove(oldH.key);
                remove(oldH);
                ListNode cur = new ListNode(key, value);
                map.put(key, cur);
                addLast(cur);
            }
        }
    }

    public void remove(ListNode cur){
        ListNode prev=  cur.prev;
        ListNode next = cur.next;
        prev.next = next;
        next.prev = prev;
    }

    public void addLast(ListNode cur){
        ListNode oldT = tail.prev;
        oldT.next = cur;
        cur.prev= oldT;
        cur.next = tail;
        tail.prev = cur;
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
    }


}