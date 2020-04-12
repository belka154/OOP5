import java.util.Arrays;

public class FactoryArray {


    private int count = 0;
    private int capasity = 5;
    private Clinic[] array = new Clinic[capasity];

    public Clinic[] getArray() {
        return array;
    }


    void add(Clinic clinic) {

        if (count < getArray().length) {
            array[count] = clinic;
        } else {
            capasity = capasity * 2;
            Clinic[] newArray = new Clinic[capasity];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
            array[count] = clinic;
        }

        count++;
    }

    void delited() {
        count--;
    }




    void sort() {
        for (int i = 0; i < array.length-1; i++) {
          if(array[i]==null){
              array[i]=array[i+1];
              array[i+1]=null;

}

        }
    }
}