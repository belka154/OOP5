import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;

public class GenericContainer<T> {


    private int size = 0;
    private int capasity = 5;
    private T[] array = (T[]) new Object[capasity];


    public int getSize() {
        return size;
    }

    public int getCapasity() {
        return capasity;
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


    public void delite(int index) {
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


    static AtomicInteger ai = new AtomicInteger();

    Thread t1 = new Thread(new Runnable() {
        @Override
        public void run() {
            int local = 0;
            for (int i = 0; i < 1_000_000; i++) {
                local++;
            }

            ai.addAndGet(local);
        }
    });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int local2 = 0;
                for (int i = 0; i < 1_000_000; i++) {
                    local2--;
                }
                ai.addAndGet(local2);
            }
        });

    }

