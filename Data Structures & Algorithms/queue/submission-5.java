class Deque {
    ListNode head;
    ListNode tail;
    int size;

    public Deque() {
        head = new ListNode(-1);
        tail = new ListNode(-1);
        head.next = tail;
        tail.prev = head;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void append(int value) {
        ListNode end = tail.prev;
        ListNode newE = new ListNode(value);
        end.next = newE;
        newE.prev = end;
        tail.prev = newE;
        newE.next = tail;
        size++;
    }

    public void appendleft(int value) {
        ListNode curH = head.next;
        ListNode newH = new ListNode(value);
        head.next = newH;
        newH.prev = head;
        newH.next = curH;
        curH.prev = newH;
        size++;
    }

    public int pop() {
        if(isEmpty()) return -1;
        ListNode end = tail.prev;
        ListNode lastE = end.prev;
        lastE.next = tail;
        tail.prev = lastE;
        end.next = null;
        end.prev = null;
        size--;
        return end.val;
    }

    public int popleft() {
        if(isEmpty()) return -1;
        ListNode curH = head.next;
        ListNode curN = curH.next;
        head.next =curN;
        curN.prev = head;

        curH.next = null;
        curH.prev = null;

        size--;

        return curH.val;
    }
}

class ListNode{
    ListNode prev;
    ListNode next;
    int val;

    public ListNode(int val){
        this.val = val; 
    }


}
