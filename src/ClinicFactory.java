public class ClinicFactory {
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
        System.out.println("Number of staff");
        int s7=0;
        boolean bb=true;
        while (bb){
            String w=scanner.scannerString();
         try {
             s7=Integer.parseInt(w);
             bb=false;
         } catch (NumberFormatException e){
             System.err.println("Введите число");
          }
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
            return new ChildrenClinic(so, s1, s2, b, b1,s7,s5);
        } else  {
            return new DentalClinic(so, s1, s2, b, b1, s7, s6);
        }
    }
}