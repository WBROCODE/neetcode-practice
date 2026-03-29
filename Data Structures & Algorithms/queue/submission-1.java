class Deque {
    Node head;
    Node tail;

    public Deque() {
        this.head = new Node(-1);
        this.tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
    }

    public boolean isEmpty() {
        return head.next == tail;
    }

    public void append(int value) { 
        Node newNode = new Node(value);
        newNode.prev = tail.prev; 
        newNode.next = tail;
        tail.prev.next = newNode;
        tail.prev = newNode;
    }

    public void appendleft(int value) {
        Node newNode = new Node(value);
        newNode.next = head.next;
        newNode.prev = head;
        head.next.prev = newNode;
        head.next = newNode;
    }

    public int pop() {
       if(isEmpty()) return -1;
       Node end = tail.prev;
       int val = end.val;
       Node prevEnd = end.prev;
       tail.prev = prevEnd;
       prevEnd.next = tail;
       
       return val;
    }

    public int popleft() {
        if(isEmpty()) return -1;
        Node cur = head.next;
        int val = cur.val;
        Node nextN = cur.next;

        head.next = nextN;
        nextN.prev = head;

        return val;
    }
}

class Node{
    int val;
    Node prev; 
    Node next;

    public Node(int val){
        this.val = val;
        this.prev = null;
        this.next = null;
    }


}
