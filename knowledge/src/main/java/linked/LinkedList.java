package linked;

public class LinkedList<E> {
    private Node<E> head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public void addFrist(E e) {
        head = new Node<>(e, head);
        size++;
    }


    public void add(int index, E e) {
        if (index == 0) {
            addFrist(e);
            return;
        }
        Node<E> pre = head;
        for (int i = 0; i < index - 1; i++) {
            pre = pre.next;
        }
        pre.next = new Node<>(e, pre.next);
        size++;
    }

    public void addLast(E e) {
        add(size, e);
    }


}
