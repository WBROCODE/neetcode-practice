class LRUCache {
    Map<Integer, ListNode> map;
    int capacity;
    ListNode head;
    ListNode tail;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            ListNode cur = map.get(key);
            int val = cur.val;
            removeNode(cur);
            addToTail(cur);
            return val;
        }else return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            ListNode cur = map.get(key);
            cur.val = value;
            removeNode(cur);
            addToTail(cur);
        }else{
            if(map.size() == capacity){
                ListNode newNode = new ListNode(key, value);
                int headNext = head.next.key;
                removeNode(head.next);
                map.remove(headNext);
                addToTail(newNode);
                map.put(key, newNode);
            }else if(map.size() < capacity){
                ListNode newNode = new ListNode(key, value);
                addToTail(newNode);
                map.put(key, newNode);
            }
        }
    }

    public void removeNode(ListNode node){
        ListNode prevNode = head;

        while(prevNode.next != node){
            prevNode = prevNode.next;
        }
        ListNode next = node.next;
        node.prev = null;
        node.next = null;
        prevNode.next = next;
        next.prev = prevNode;
    }

    public void addToTail(ListNode node){
        ListNode prevTail = tail.prev;
        prevTail.next = node;
        node.prev = prevTail;
        node.next = tail;
        tail.prev = node;
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
