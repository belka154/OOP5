import java.util.Scanner;

public class FactoryClinic {


    MyScanner scanner = new MyScanner();


    public Clinic createClinic() {
        int i = 0;
        while (i <= 0 || i > 2) {
            i = preAdd();
        }

        return addClinic(i);
    }



    private int preAdd() {
        System.out.println(" 1: ChildrenClinic \n 2: DentalClinic");
        return scanner.scannerInt(1, 2);
    }





    public Clinic addClinic(int index) {

        System.out.println("Clinic name");
        String so = scanner.scannerString();

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

        System.out.println("hash paid service \n yes \n no");
        String s4 = scanner.scannerString();
        boolean b1 = false;
        if (s4.equals("yes")) {
            b1 = true;
        }

        String s5=null;
        String s6=null;

        if (index==1) {
         System.out.println("Number call home doctor");
        s5 = scanner.scannerString();
         }
          else {
        System.out.println("e-mail");
        s6 = scanner.scannerString();
        }



        if (index == 1) {
            return new ChildrenClinic(so, s1, s2, b, b1, s5);
        } else  {
            return new DentalClinic(so, s1, s2, b, b1, s6);
        }
    }


}