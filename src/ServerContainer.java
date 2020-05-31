import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerContainer {


    private  static ExecutorService executorService;
    private static CopyOnWriteArrayList<Clinic> list = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws IOException {

        executorService = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(8081);

        while (true) {
            Socket socket = serverSocket.accept();
            process(socket);
        }
    }
    private static void process(Socket socket){

       executorService.submit(new Runnable() {
           @Override
           public void run() {
               try {
                   ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                   ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

                   while (true){
                       communicate(objectInputStream,objectOutputStream);
                   }
               } catch (IOException e) {
                   e.printStackTrace();
               } catch (ClassNotFoundException e) {
                   e.printStackTrace();
               }
           }
       });
    }

    private static void communicate(ObjectInputStream objectInputStream, ObjectOutputStream objectOutputStream) throws IOException, ClassNotFoundException {
        int u = 0;
        Request request = (Request) objectInputStream.readObject();
        switch (request.getType()){
            case ADD:{
                Clinic clinic = (Clinic) request.getPayload();
                list.add(clinic);
                System.out.println(list);
                break;
            }
            case GET:{
                Response response = new Response(list);
                objectOutputStream.writeObject(response);
                objectOutputStream.flush();
                break;
            }
            case DELETE:{
                int t = (int)request.getPayload();
                list.remove(t);
                System.out.println(list);
                break;
            }
            case UPDATE:{
                u = (int)request.getPayload();
                Response response = new Response(list.get(u));
                objectOutputStream.writeObject(response);
                objectOutputStream.flush();
                list.remove(u);
                break;
            }
            case SIZE:{
                int size = list.size();
                Response response = new Response(size);
                objectOutputStream.writeObject(response);
                objectOutputStream.flush();
                break;
            }
            case SORT: {
                list.sort((o1, o2) -> {
                    if (o1.getNumberOfStaff() == o2.getNumberOfStaff()) {
                        return 0;
                    } else if (o1.getNumberOfStaff() < o2.getNumberOfStaff()) {
                        return -1;

                    } else {
                        return 1;
                    }
                });
                Response response = new Response(list);
                objectOutputStream.writeObject(response);
                objectOutputStream.flush();
                break;
            }
            case CHANGES:{
                Clinic clinic = (Clinic) request.getPayload();
                list.add(u, clinic);
                System.out.println(list);
            }
            case WRITE:{


            }
          }
        }
    }




