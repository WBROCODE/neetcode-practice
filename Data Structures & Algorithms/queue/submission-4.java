class Deque {
    LinkedList<Integer> list;
    public Deque() {
        this.list = new LinkedList<>();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void append(int value) {
       list.addLast(value);
    }

    public void appendleft(int value) {
        list.addFirst(value);
    }

    public int pop() {
        if (isEmpty()) return -1;
        return list.removeLast();
    }

    public int popleft() {
        if (isEmpty()) return -1;
        return list.removeFirst();
    }
}
