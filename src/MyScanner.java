import java.util.Scanner;

public class MyScanner {

    Scanner cs= new Scanner(System.in);


    public int scannerInt(int a, int b) {

            int i = cs.nextInt();
            cs.nextLine();
            if (i < a || i > b) {
                System.err.println(" Enter correcter numbers \n ");

            }

            return i;
        }


        public String scannerString(){
        String str= cs.nextLine();
        return str;

    }


}
