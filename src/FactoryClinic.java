
public class MadeObject {



    StaffDoctor staffDoctor;
    ChildrenClinic childrenClinic;
    Program program;
    int count = 0;
    MyScanner scanner = new MyScanner();

    public void add() {
        System.out.println(" 1: DentalClinic \n 2: ChildrenClinic");
        scanner.scannerInt(1, 2);
        addClinic(scanner.scannerInt(1, 2));
    }


    public Clinic addClinic(int index) {

        System.out.println("Clinic name");
        String s0 = scanner.scannerString();

        System.out.println("Address");
        String s1 = scanner.scannerString();

        System.out.println("Phone number");
        String s2 = scanner.scannerString();

        System.out.println("Hash free service \n yes \n no");
        String s3 = scanner.scannerString();
        boolean b = false;
        if (s3.equals("yes")) {
            b = true;
        }


        System.out.println("hash paid service");
        String s4 = scanner.scannerString();
        boolean b1 = false;
        if (s4.equals("yes")) {
            b1 = true;
        }

        System.out.println("Number call home doctor");
        String s5 =scanner.scannerString();


        if (index == 1) {
            return new ChildrenClinic(s0, s1, s2, b, b1, s5);
        } else  {
            return new DentalClinic(s0, s1, s2, b, b1, s5);
        }
    }


}