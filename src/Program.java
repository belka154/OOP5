import java.io.IOException;

public class Program{

    private MyScanner scanner1 = new MyScanner();
    private ClinicFactory clinicFactory = new ClinicFactory();
    private FileClinicContainer factoryArray = new FileClinicContainer();
    private ClientContainer<Clinic> clientContainer = new ClientContainer<>("localhost", 8081, this);
    private boolean flag = true;

    public Program() throws IOException {
    }

    private void programConsole() throws IOException {
        System.out.println( "Select item: \n 1: add element \n 2: update element \n 3: delete element \n 4: print all \n 5: save to file \n 6: load from file \n 7: sort \n 0: exit");

        switch (scanner1.scannerInt(0,7)){
            case 1: addElement();break;
            case 2: updateElement();break;
            case 3: deleteElement(); break;
            case 4: printAll(); break;
            case 5: saveToFile(); break;
            case 6: loadFromFile(); break;
            case 7: sort(); break;
            case 0: exitProgram();break;
            default:
        }
    }

    public void process() throws IOException {
        while (flag){
            programConsole();
        }
    }

    public void addElement() {
        Clinic clinic = clinicFactory.createClinic();
        clientContainer.add(clinic);
    }

    public void updateElement() throws IOException {
        clientContainer.size();
        System.out.println("Enter Clinic index to update between 0 and " + (clientContainer.getSize()-1));
        int w = scanner1.scannerInt(0, clientContainer.getSize());
        if ((clientContainer.getSize()) == 0) {
            System.err.println("Add Clinic \n");
            return;
        }
        clientContainer.update(w);
    }


        public void updateClinic(Clinic clinic) {
            int w1;
            if (clinic instanceof ChildrenClinic) {
                System.out.println("What you want change? \n 1: Clinic name \n 2: Address \n 3: Phone number \n 4: Has free service \n 5: Has paid service  \n 6: number of staff \n 7: number call home doctor \n 0: exit");
                w1 = scanner1.scannerInt(0, 6);
            } else {
                System.out.println("What you want change? \n 1: Clinic name \n 2: Address \n 3: Phone number \n 4: Has free service \n 5: Has paid service \n 6: number of staff \n 7: e - mail \n 0: exit");
                w1 = scanner1.scannerInt(0, 6);
            }
                switch (w1) {
                    case 0:
                        return;
                    case 1:
                        System.out.println(" Enter new name clinic");
                        String ww = scanner1.scannerString();
                        clientContainer.clinic.setClinicName(ww);
                        break;
                    case 2:
                        System.out.println(" Enter new address clinic");
                        String ww1 = scanner1.scannerString();
                        clientContainer.clinic.setAddress(ww1);
                        break;
                    case 3:
                        System.out.println(" Enter new phone number clinic");
                        String ww2 = scanner1.scannerString();
                        clientContainer.clinic.setPhoneNumber(ww2);
                        break;
                    case 4:
                        System.out.println(" Enter hash free service clinic \n yes \n no ");
                        String ww3 = scanner1.scannerString();
                        boolean d = false;
                        if (ww3.equals("yes")) {
                            d = true;
                        } else {
                        }
                        clientContainer.clinic.setHasFreeService(d);
                        break;
                    case 5:
                        System.out.println(" Enter hash paid service clinic \n yes \n no ");
                        String ww4 = scanner1.scannerString();
                        boolean d1 = false;
                        if (ww4.equals("yes")) {
                            d1 = true;
                        } else {
                        }
                        clientContainer.clinic.setHasPaidService(d1);
                        break;
                    case 6:
                        boolean bb = true;
                        int ww9 = 0;
                        while (bb) {
                            System.out.println("Enter new number of staff");
                            String e = scanner1.scannerString();
                            try {
                                ww9 = Integer.parseInt(e);
                                bb = false;
                            } catch (NumberFormatException e1) {
                                System.err.println("Enter number");
                            }
                        }
                        clientContainer.clinic.setNumberOfStaff(ww9);
                        break;
                    case 7:
                        if (clientContainer.clinic instanceof ChildrenClinic) {
                            System.out.println(" Enter new number call home doctor");
                            String ww5 = scanner1.scannerString();
                            ((ChildrenClinic) clientContainer.clinic).setNumberCallHomeDoctor(ww5);
                        } else {
                            System.out.println(" Enter new e-mail");
                            String ww5 = scanner1.scannerString();
                            ((DentalClinic) clientContainer.clinic).setEmail(ww5);
                        }
                        break;
                    default:
                }
            }

    private void deleteElement() throws IOException {
        clientContainer.size();
        if (clientContainer.getSize() == 0) {
                System.err.println("Collection is Null / Enter Clinic");
               return;
            }
            else {
                System.out.println("Delete element at index");
                System.out.println("Enter index between 0 and " + (clientContainer.getSize() - 1));
            }
            int s5=scanner1.scannerInt(0,clientContainer.getSize()-1);
            clientContainer.delete(s5);

    }


    private void printAll()  {
        try {
            clientContainer.printAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
   }


   private void saveToFile() throws IOException {
       clientContainer.size();
       if (clientContainer.getSize() == 0) {
           System.err.println("Добавьте клинику");
           return;
       } else {
       }
       System.out.println("Введите имя файла для записи в файл");
       String k=scanner1.scannerString();
       try{
           clientContainer.write(k);
       }
       catch (Exception e){
           e.printStackTrace();
       }
       }


   private void loadFromFile() {
       System.out.println("Введите имя файла для чтения из файла");
       String w=scanner1.scannerString();
       try {
           clientContainer.read(w);
       } catch (Exception e) {
        e.printStackTrace();
       }
   }


   private void sort() throws IOException {
           clientContainer.sort((o1, o2) ->{
               if (o1.getNumberOfStaff() == o2.getNumberOfStaff()) {
                   return 0;
               } else if (o1.getNumberOfStaff() < o2.getNumberOfStaff()) {
                   return -1;
               } else {
                   return 1;
               }
           });
     }


    private void exitProgram(){
        flag = false;
    }
}
