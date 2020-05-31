import java.util.Arrays;
import java.util.Comparator;


public class GenericContainer<T> implements Container<T> {
    private int size = 0;
    private int capasity = 5;
    private T[] array = (T[]) new Object[capasity];

    public int getSize() {
        return size;
    }

    public T get(int index) {
        return array[index];
    }

    public void add(T o) {

        if (size < array.length) {
            array[size] = o;
        } else {
            capasity = capasity * 2;
            T[] newArray = (T[]) new Object[capasity];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
            array[size] = o;
        }
        size++;
    }


    public void delete(int index) {
        for (int i = index; i < capasity - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }


    public void sort(Comparator<T> c) {
        T[] arr = Arrays.copyOf(array, size);
        Arrays.sort(arr, c);
        array = Arrays.copyOf(arr, array.length);
    }

    public void update(int w) {
    }

    public void printAll() {
    }

//    public GenericContainer() {
//    }
}


