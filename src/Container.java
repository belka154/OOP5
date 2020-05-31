import java.io.IOException;
import java.util.Collection;
import java.util.Comparator;

public interface Container<T>  {

    int getSize();

    void update(int w) throws IOException;

    T get(int index);

    void add(T o) throws IOException;

    void delete(int index) throws IOException;

    void printAll() throws IOException;

    void sort(Comparator<T> c) throws IOException;
}
