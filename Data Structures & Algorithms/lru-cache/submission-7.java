class LRUCache {
    Node head; 
    Node tail; 
    Map<Integer, Node> map;
    int capacity;
    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        int val = node.val;
        remove(node);
        add(node);
        return val;
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key)){
            if(map.size() < capacity){
                Node newN = new Node(key, value);
                map.put(key, newN);
                add(newN);
            }else{
                Node oldN = tail.prev;
                Node newN = new Node(key, value);
                map.put(key, newN);
                remove(oldN);
                add(newN);  
                map.remove(oldN.key);
            }
        }else{
            Node oldN = map.get(key);
            oldN.val = value;
            remove(oldN);
            add(oldN);
        }

    }

    public void add(Node node){
        Node oH = head.next;
        head.next = node;
        node.prev = head;
        node.next = oH;
        oH.prev = node;
    }

    public void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        node.prev = null;
        node.next = null;

    }
}


class Node{
    Node prev;
    Node next;
    int key;
    int val;

    public Node(int key, int val){
        this.val = val;
        this.key = key;
    }
}