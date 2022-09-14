package queue;

import linked.Node;

public class LinkedListQueue<E> implements Queue<E> {
    private Node<E> head, tail;
    private int size;


    @Override
    public void enqueue(E e) {
        if (tail == null) {
            tail = new Node<>(e);
            head = tail;
        } else {
            tail.next = new Node<>(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("queue is empty!");
        }
        Node<E> retNode = head;
        head = head.next;
        retNode.next = null;
        if (head == null) {
            tail = null;
        }
        size--;
        return retNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("queue is empty!");
        }
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("head: ");
        for (Node cur = head; cur != null; cur = cur.next) {
            res.append(cur.e).append(" ->");
        }
        return res.append("NULL tail").toString();
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        for (int i = 0; i <5 ; i++) {
            linkedListQueue.enqueue(i);
        }
        System.err.println(linkedListQueue);
    }
}
