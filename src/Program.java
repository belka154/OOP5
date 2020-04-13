public class Program{

    private MyScanner scanner1 = new MyScanner();
    private FactoryClinic factoryClinic = new FactoryClinic();
    private FactoryArray<Clinic> factoryArray = new FactoryArray<>();
    private int count=0;
    private boolean flag = true;


    private void programConsole(){
        System.out.println( "Select item: \n 1: add element \n 2: update element \n 3: delete element \n 4: print all \n 5: save to file \n 6: load from file \n 0: exit");

        switch (scanner1.scannerInt(0,4)){
            case 1: addElement();break;
            case 2: updateElement();break;
            case 3: deleteElement(); break;
            case 4: printAll(); break;
            case 0: exitProgram();break;

            default:
        }

    }

    public void process(){
        while (flag){
            programConsole();
        }
    }





    public void addElement() {

        Clinic clinic = factoryClinic.createClinic();
        factoryArray.add(clinic);
        count++;
    }




    private void updateElement() {

        if (count == 0) {
            System.err.println("Add Clinic \n");
            return;
        }

        System.out.println("Enter Clinic index to update between 0 and " + (count - 1));
        int w = scanner1.scannerInt(0, count - 1);


        System.out.println(factoryArray.getArray()[w] +"\n");
        int w1=0;
        int w2=0;

        if (factoryArray.getArray()[w] instanceof ChildrenClinic) {
            System.out.println("What you want change? \n 1: Clinic name \n 2: Address \n 3: Phone number \n 4: Has free service \n 5: Has paid service  \n 6: number call home doctor \n 0: exit");
             w1 = scanner1.scannerInt(0, 6);
        }else {
            System.out.println("What you want change? \n 1: Clinic name \n 2: Address \n 3: Phone number \n 4: Has free service \n 5: Has paid service \n 6: e - mail \n 0: exit");
             w1=scanner1.scannerInt(0,6);

        }

        switch (w1) {
            case 0:return;
            case 1: System.out.println(" Enter new name clinic");
                    String ww = scanner1.scannerString();
                    factoryArray.getArray()[w].setClinicName(ww); break;
            case 2: System.out.println(" Enter new address clinic");
                    String ww1 = scanner1.scannerString();
                    factoryArray.getArray()[w].setAddress(ww1); break;
            case 3: System.out.println(" Enter new phone number clinic");
                    String ww2 = scanner1.scannerString();
                    factoryArray.getArray()[w].setPhoneNumber(ww2); break;
            case 4: System.out.println(" Enter hash free service clinic \n yes \n no ");
                    String ww3 = scanner1.scannerString();
                    boolean d=false;
                    if (ww3.equals("yes")) {
                         d = true;
                    }else {

                    }
                    factoryArray.getArray()[w].setHasFreeService(d); break;
            case 5: System.out.println(" Enter hash paid service clinic \n yes \n no ");
                    String ww4 = scanner1.scannerString();
                    boolean d1=false;
                    if (ww4.equals("yes")) {
                    d1 = true;
                    }else {

                    }
                    factoryArray.getArray()[w].setHasPaidService(d1); break;
            case 6:
                   if (factoryArray.getArray()[w] instanceof ChildrenClinic) {
                       System.out.println(" Enter new number call home doctor");
                       String ww5=scanner1.scannerString();
                       ((ChildrenClinic) factoryArray.getArray()[w]).setNumberCallHomeDoctor(ww5);
                   }
                   else {
                       System.out.println(" Enter new e-mail");
                       String ww5=scanner1.scannerString();

                       ((DentalClinic) factoryArray.getArray()[w]).setEmail(ww5);
                   }
                   break;
                default:
                }
        }






        private void deleteElement(){

            if (count == 0) {
                System.err.println("Collection is Null / Enter Clinic");
               return;
            }
            else {
                System.out.println("Delete element at index");
                System.out.println("Enter index between 0 and " + (count - 1));
            }


            int s5=scanner1.scannerInt(0,count-1);


            for (int i=0; i<factoryArray.getArray().length; i++){
                if (i==s5){
                factoryArray.getArray()[i]=null;
                count--;
                    factoryArray.sort();
            }
        }
        System.out.println("Element delited \n ");

    }







   private void printAll(){
       for (int i = 0; i < count; i++) {
           factoryArray.get(i);
       }
   }





    private void exitProgram(){
        flag = false;
    }



}
