import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClientContainer<T extends Serializable> implements Container <T> {

    private Socket socket;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;
    Clinic clinic;
    private Program program;
    private int size;

    public ClientContainer(String host, int port, Program program) throws IOException {
        socket = new Socket(host, port);
        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectInputStream = new ObjectInputStream(socket.getInputStream());
        this.program = program;
    }


    @Override
    public int getSize() {
        return size;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public void add(T o) {
        Request request = new Request(Type.ADD, o);
        try {
            objectOutputStream.writeObject(request);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int w) throws IOException {
        Request request = new Request(Type.UPDATE, w);
        objectOutputStream.writeObject(request);
        objectOutputStream.flush();
        try {
            Response response = (Response) objectInputStream.readObject();
            clinic = (Clinic) response.getPayload();
            System.out.println(clinic);
            program.updateClinic(clinic);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Request request1 = new Request(Type.CHANGES, clinic);
        objectOutputStream.writeObject(request1);
        objectOutputStream.flush();
    }

    public void size() throws IOException {
        Request request = new Request(Type.SIZE, null);
        objectOutputStream.writeObject(request);
        objectOutputStream.flush();

        try {
            Response response = (Response) objectInputStream.readObject();
            size = (int) response.getPayload();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int index) {
        Request request = new Request(Type.DELETE, index);
        try {
            objectOutputStream.writeObject(request);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void printAll() throws IOException {
        Request request = new Request(Type.GET, null);
        objectOutputStream.writeObject(request);
        objectOutputStream.flush();

        try {
            Response response = (Response) objectInputStream.readObject();
            System.out.println(response.getPayload());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sort(Comparator<T> c) throws IOException {
        Request request1 = new Request(Type.SORT, null);
        objectOutputStream.writeObject(request1);
        objectOutputStream.flush();
        try {
            Response response = (Response) objectInputStream.readObject();
            System.out.println(response.getPayload());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void write(String a) throws Exception {
        Request request = new Request(Type.GET, null);
        objectOutputStream.writeObject(request);
        objectOutputStream.flush();
        Response response = (Response) objectInputStream.readObject();
        File file = new File(a);
        BufferedWriter fileOutputStream = new BufferedWriter(new FileWriter(file));
        FileWriter fileWriter = new FileWriter(file);
        fileOutputStream.write(size + ";" + "\n");
        List<Clinic> list = (List) response.getPayload();
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
                String str = list.get(i).formatFile();
                fileOutputStream.write(str);
            }
            fileWriter.close();
            fileOutputStream.close();
        }

    public void read(String a) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(a));
        String e;
        StringBuilder stringBuilder = new StringBuilder();
        while ((e = bufferedReader.readLine()) != null) {
            stringBuilder.append(e);
        }
        String s = stringBuilder.toString();
        bufferedReader.close();
        System.out.println(s);
    }
}
