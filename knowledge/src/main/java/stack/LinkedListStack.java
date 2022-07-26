package stack;

import linked.DummpHeadLinkedList;

public class LinkedListStack<E> implements Stack<E> {
    private DummpHeadLinkedList<E> list;

    public LinkedListStack() {
        this.list = new DummpHeadLinkedList<>();
    }

    @Override
    public void push(E e) {
        list.addFrist(e);
    }

    @Override
    public E pop() {
        return list.removeFrist();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return "LinkedListStack{" +
                "list=" + list +
                '}';
    }
}
