class LRUCache {
    Map<Integer, ListNode> map;
    int capacity;
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
        ListNode val = map.get(key);
        remove(val);
        addToTail(val);
        return val.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            ListNode old = map.get(key);
            old.val = value;
            remove(old);
            addToTail(old);
            return;
        }else if(map.size() == capacity){
            ListNode oldH = head.next;
            remove(oldH);
            map.remove(oldH.key);
        }
        ListNode newN = new ListNode(key, value);
        addToTail(newN);
        map.put(key, newN);
    }

    public void addToTail(ListNode node){
        ListNode oldT = tail.prev;
        node.next = tail;
        tail.prev = node;
        oldT.next = node;
        node.prev = oldT;
    }

    public void remove(ListNode node){
        ListNode prev = node.prev;
        ListNode next = node.next;
        node.prev = null;
        node.next = null;
        prev.next = next;
        next.prev = prev;
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