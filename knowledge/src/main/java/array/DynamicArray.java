package array;

@SuppressWarnings("unused")
public class DynamicArray<E> {
    private Object[] data;
    private int size;


    public DynamicArray(int capacity) {
        data = new Object[capacity];
        size = 0;
    }

    public DynamicArray() {
        this(10);
    }


    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return 0 == size;
    }

    public void addLast(E e) {
        add(size, e);
    }

    public void resize(int capacity) {
        if (capacity == 0) {
            throw new IllegalArgumentException("resize failed! capacity is zero");
        }
        Object[] newData = new Object[capacity];
        if (size >= 0) System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    public void add(int index, E e) {
        if (size == data.length) {
            resize(size * 2);
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Illegal index");
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get failed index out of range");
        }
        return null == data[index] ? null : (E) data[index];
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get failed index out of range");
        }
        data[index] = e;
    }


    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public E remove(int index) {
        if (size != 0 && size < data.length / 4) {
            resize(data.length / 2);
        }

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("remove failed index out of bound");
        }
        E ret = (E) data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return ret;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public boolean removeElement(E e) {
        int index = find(e);
        if (-1 != index) {
            return e == remove(index);
        }
        return false;
    }

    public int removeElementRecursion(E e) {
        int remCnt = 0;
        if (removeElement(e)) {
            return removeElementRecursion(e) + 1;
        }
        return remCnt;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array size: %d capacity: %d array: ", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);

            if (i == size - 1) {
                res.append("]");
            } else {
                res.append(",");
            }

        }
        return res.toString();
    }

    public E getLast() {
        return get(size - 1);
    }
}
