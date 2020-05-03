import java.util.Arrays;

public class GenericContainer<T> {


    private int count = 0;
    private int capasity = 5;
    private T[] array = (T[]) new Object[capasity];

    public T[] getArray() {
        return array;
    }

    public int getCount() {
        return count;
    }

    public int getCapasity() {
        return capasity;
    }

    public T get (int index){
        return array[index];
    }


   public void add(T o) {

        if (count < array.length) {
            array[count] = o;
        } else {
            capasity = capasity * 2;
            T[] newArray = (T[]) new Object[capasity];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
            array[count] = o;
        }

        count++;
    }


    public void delite(int index){
        for (int i=index; i<capasity-1; i++){
            array[i]=array[i+1];
        }
        count--;
    }


}