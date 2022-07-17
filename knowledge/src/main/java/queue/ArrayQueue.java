package queue;

import array.DynamicArray;

public class ArrayQueue<E> implements Queue<E> {

    private DynamicArray<E> dynamicArray;

    public ArrayQueue() {
        this.dynamicArray = new DynamicArray<>();
    }

    public ArrayQueue(int capacity) {
        this.dynamicArray = new DynamicArray<>(capacity);
    }

    @Override
    public int getSize(){
        return dynamicArray.getSize();
    }

    @Override
    public boolean isEmpty(){
        return dynamicArray.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        dynamicArray.addLast(e);
    }

    @Override
    public E dequeue(){
        return dynamicArray.removeFirst();
    }

    @Override
    public E getFront(){
        return dynamicArray.getFrist();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder("stack print: top-> [");
        for (int i = 0; i <dynamicArray.getSize() ; i++) {
            res.append(dynamicArray.get(i));
            if(i!=dynamicArray.getSize()-1){
                res.append(", ");
            }
        }
        res.append(" ] -> tail");
        return res.toString();
    }
}
