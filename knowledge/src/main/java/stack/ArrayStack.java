package stack;

import array.DynamicArray;

public class ArrayStack<E> implements Stack<E> {

    private final DynamicArray<E> dynamicArray;

    public ArrayStack() {
        this.dynamicArray = new DynamicArray<E>();
    }

    public ArrayStack(int capacity) {
        this.dynamicArray = new DynamicArray<E>(capacity);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("stack print: [");
        for (int i = 0; i <dynamicArray.getSize() ; i++) {
            res.append(dynamicArray.get(i));
            if(i!=dynamicArray.getSize()-1){
                res.append(", ");
            }
        }
        res.append(" ] top");
        return res.toString();
    }

    public void push(E e) {
        this.dynamicArray.addLast(e);
    }

    public E pop() {
        return this.dynamicArray.removeLast();
    }

    public E peek() {
        return this.dynamicArray.getLast();
    }

    public int getSize() {
        return this.dynamicArray.getSize();
    }

    public boolean isEmpty() {
        return this.dynamicArray.isEmpty();
    }


}
