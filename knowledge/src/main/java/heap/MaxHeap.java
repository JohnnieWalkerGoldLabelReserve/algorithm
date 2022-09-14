package heap;

import array.DynamicArray;

public class MaxHeap<E extends Comparable<E>> {

    private DynamicArray<E> data;

    public MaxHeap(int capacity) {
        data = new DynamicArray<>(capacity);
    }

    public MaxHeap() {
        this(10);
    }

    public MaxHeap(Object[] arr) {
        data = new DynamicArray<>(arr);
        for (int i = parent(data.getSize() - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    public int getSize() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("root node don't have parent!");
        }
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k) {
        while (k > 0 && data.get(k).compareTo(data.get(parent(k))) > 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("size is null");
        }
        return data.get(0);
    }

    public E extractMax() {
        E ret = findMax();
        data.swap(0, getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            if (j + 1 < data.getSize() && data.get(j).compareTo(data.get(j + 1)) < 0) {
                j++;
            }
            if (data.get(j).compareTo(data.get(k)) <= 0) {
                break;
            }
            data.swap(j, k);
            k = j;
        }
    }

    public E replace(E e) {
        E max = findMax();
        data.set(0, e);
        siftDown(0);
        return max;
    }

    public static void main(String[] args) {
        Integer arr[] = new Integer[]{1, 3, 5, 9, 0, 7};
        MaxHeap<Integer> maxHeap = new MaxHeap<>(arr);
        for (int i = 0; i < 6; i++) {
            System.err.println(maxHeap.extractMax());
        }
    }
}
