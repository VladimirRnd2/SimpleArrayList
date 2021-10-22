import java.util.ArrayList;
import java.util.List;

public class SimpleArrayList<E extends Comparable<? super E>> {

    private final int DEFAULT_CAPACITY = 16;

    // размер списка
    private int size;

    // Текущий индекс, показывающий под каким индексом добавлять новый элемент в список
    private int index;

    private Object [] elements;

    public SimpleArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public SimpleArrayList(int capacity) {
        elements = new Object[capacity];
    }

    private void growArray() {
        Object[] copyArray = new Object[(elements.length * 3) / 2 + 1];
        System.arraycopy(elements,0,copyArray,0,index - 1);
        elements = copyArray;
    }

    private void checkIndex(int index) {
        if(index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    public void add(E value) {
        if(index == elements.length) {
            growArray();
        }
        elements[index] = value;
        size++;
        index++;
    }

    public boolean add (int index, E value) {
        checkIndex(index);
        if(index == elements.length) {
            growArray();
        }
        System.arraycopy(elements,index, elements, index + 1, this.index - index);
        elements[index] = value;
        size++;
        this.index++;
        return true;
    }

    public E get(int index) {
        checkIndex(index);
        return (E)elements[index];
    }

    public void set(int index, E value) {
        checkIndex(index);
        elements[index] = value;
    }

    public E remove(int index) {
        checkIndex(index);
        Object removeObject = elements[index];
        System.arraycopy(elements,index + 1,elements, index, this.index - index);
        size--;
        this.index--;
        return (E) removeObject;
    }

    public boolean remove(Object value) {
        int index;
        if(value == null) {
            for (index = 0; index < elements.length; index++) {
                if(elements[index] == null) {
                    remove(index);
                }
                return true;
            }
        }
        else {
            for (index = 0; index < elements.length; index++) {
                if(elements[index].equals(value)) {
                    remove(index);
                }
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }
    public void clear () {
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
            size = 0;
        }
    }

    public boolean isEmpty() {
        if(size == 0) {
            return true;
        }
        return false;
    }

}
