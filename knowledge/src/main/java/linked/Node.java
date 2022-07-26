package linked;

public class Node<E> {
    public E e;
    public Node<E> next;

    public Node(E e, Node next) {
        this.e = e;
        this.next = next;
    }

    public Node(E e) {
        this.e = e;
    }

    public Node() {
    }
}
