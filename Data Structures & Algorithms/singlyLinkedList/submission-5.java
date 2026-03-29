class LinkedList {
    ListNode head;
    ListNode tail;
    public LinkedList() {
        this.head = new ListNode(-1);
        tail = head;
    }

    public int get(int index) {
        int i = 0;
        ListNode cur = head.next;
        while(cur != null){
            if(i == index) return cur.val;
            i++;
            cur= cur.next;
        }
        return -1;
    }

    public void insertHead(int val) {
        ListNode cur = head.next;
        ListNode newH = new ListNode(val);
        newH.next = cur;
        head.next = newH;
        if(cur == null) tail = newH;
    }

    public void insertTail(int val) {
        tail.next = new ListNode(val);
        tail = tail.next;
    }

    public boolean remove(int index) {
        int i = 0;
        ListNode cur = head;
        while(i < index && cur != null){
            i++;
            cur = cur.next;
        }

        if(cur != null && cur.next != null){
            if(cur.next == tail) tail = cur;
            cur.next = cur.next.next;
            return true;
        }
        return false;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> ans = new ArrayList<>();
        ListNode cur = head.next;

        while(cur != null){
            ans.add(cur.val);
            cur = cur.next;
        }

        return ans;
    }
}

class ListNode{

    ListNode next;
    int val;

    public ListNode(int val){
        this.val = val;
        this.next = null;
    }

}
