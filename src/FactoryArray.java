public class FactoryArray <T> {


    private int count = 0;
    private int capasity = 5;
    private T[] array = (T[]) new Object[capasity];

    public T[] getArray() {
        return array;
    }

    public T get(int index) {
        return array[index];
    }


    void add(T o) {

        if (count < getArray().length) {
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



    void sort() {
        count--;
        for (int i = 0; i < array.length-1; i++) {
          if(array[i]==null){
              array[i]=array[i+1];
              array[i+1]=null;

}

        }
    }
}