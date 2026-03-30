class LinkedList {
    ListNode head;
    ListNode tail;
    int size;
    public LinkedList() {
        this.head = new ListNode(-1);
        this.tail = head;
        this.size = 0;
    }

    public int get(int index) {
        ListNode cur = head.next;
        int i = 0;
        while(cur != null){
            if(i == index) return cur.val;
            i++;
            cur = cur.next;   
        }
        return -1;
    }

    public void insertHead(int val) {
        ListNode curHead = head.next;
        ListNode newHead = new ListNode(val);
        newHead.next = curHead;
        head.next = newHead;
        if(curHead == null) this.tail = newHead;
        size++;
    }

    public void insertTail(int val) {
        ListNode newTail = new ListNode(val);
        this.tail.next = newTail;
        this.tail = newTail;
        size++;
    }

    public boolean remove(int index) {
        if(index < 0 || index >= size) return false;
        ListNode prev = head;
        for(int i = 0; i < index; i++){
            prev = prev.next;
        }

        ListNode toDelete = prev.next;
        prev.next = prev.next.next;
        if(toDelete == tail) tail = prev;
        size--;
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode cur = head.next;
        while(cur != null){
            arr.add(cur.val);
            cur = cur.next;
        }
        return arr;
    }
}

class ListNode{
    int val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
    }
}
