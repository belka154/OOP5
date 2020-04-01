import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {


    private ArrayList<StaffDoctor> staffDoctor=new ArrayList<>();

    //private MyList<StaffDoctor> staffDoctor = new MyList<StaffDoctor>();



    boolean flag = true;


    @Override
    public String toString() {
        return "Program{" +
                "staffDoctor=" + staffDoctor +
                '}';
    }


    public ArrayList<StaffDoctor> getStaffDoctor() {
        return staffDoctor;
    }

    public Program setStaffDoctor(ArrayList<StaffDoctor> staffDoctor) {
        this.staffDoctor = staffDoctor;
        return this;
    }

    private void programConsole(){
        System.out.println( "Select item: \n 1: add element \n 2: update element \n 3: delete element \n 4: print all \n 5: save to file \n 6: load from file \n 0: exit");
        Scanner sc = new Scanner(System.in);
        int number= sc.nextInt();
        if (number<0 || number>6){
            System.err.println("Enter corrected item between 0 and 6 inclusive");
        }
        switch (number){
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


    private void addElement() {
        System.out.println(" ADD DOCTOR");
        boolean bo = true;
        String e = null;
        while (bo) {
            System.out.println("Enter ID");
            e = scanner();
            try {
                Integer.parseInt(e);
                bo = false;
            } catch (NumberFormatException ex) {
                System.err.println(" Enter numbers");
            }
        }
        boolean bo2 = true;
        String e1 = null;
        while (bo2) {
            System.out.println("Enter Name");
            e1 = scanner();
            try {
                Integer.parseInt(e1);
                System.err.println("Enter Line");
                bo2 = true;
            } catch (NumberFormatException ex3) {
                bo2 = false;


            }

        }
        boolean bo3 = true;
        String e2 = null;
        while (bo3) {
            System.out.println("Enter Last Name");
            e2 = scanner();
            try {
                Integer.parseInt(e2);
                System.err.println("Enter Line");
                bo3 = true;
            } catch (NumberFormatException ex4) {
                bo3 = false;
            }
        }


        System.out.println("Enter Category");
        String e3 = null;
        boolean bo1 = true;
        while (bo1) {
            e3 = scanner();
            try {
                Integer.parseInt(e3);
                bo1 = false;
            } catch (NumberFormatException ex1) {
                System.err.println(" Enter numbers");
            }
        }

        System.out.println("Enter Profession \n 1: PEDIATRICIAN \n 2: OTOLARYNGOLOG \n 3: ALLERGIC \n 4: SURGEON \n 5: ORTOPED \n 6: ORTODONT");
        String e4 ;
        boolean bo4 = true;
        while (bo4) {
            e4 = scanner();
            int f = 0;
            try {
                f = Integer.parseInt(e4);
                bo4=false;
            } catch (NumberFormatException ex5) {
                System.err.println(" Enter numbers between 1 and 6");
            }

            if (f < 1 || f > 6) {
                System.err.println(" Enter correct number");
                bo4=true;
            }
            else {
                bo4=false;
            }
            StaffDoctor.Doctor doctor = null;
            switch (f) {
                case 1:
                    doctor = StaffDoctor.Doctor.PEDIATRICIAN;
                    break;
                case 2:
                    doctor = StaffDoctor.Doctor.OTOLARYNGOLOG;
                    break;
                case 3:
                    doctor = StaffDoctor.Doctor.ALLERGIC;
                    break;
                case 4:
                    doctor = StaffDoctor.Doctor.SURGEON;
                    break;
                case 5:
                    doctor = StaffDoctor.Doctor.ORTOPED;
                    break;
                case 6:
                    doctor = StaffDoctor.Doctor.ORTODONT;
                    break;
                default:

            }

            staffDoctor.add(new StaffDoctor(Integer.parseInt(e), e1, e2, Integer.parseInt(e3), doctor));
        }
        System.out.println(" RECORDED! \n ");

    }
    private void updateElement() {
        System.out.println("Enter Doctor index to update between 0 and " + (staffDoctor.size() - 1));
        Scanner s7 = new Scanner(System.in);
        int e7 = 0;
        boolean boo = true;
        while (boo) {
            e7 = s7.nextInt();
            if (e7 < 0 || e7 > (staffDoctor.size() - 1)) {
                System.err.println("Enter corrected index between 0 and " + (staffDoctor.size() - 1));

            } else {
                boo = false;
            }
        }
        StaffDoctor d = staffDoctor.get(e7);
        System.out.println(staffDoctor.get(e7));
        System.out.println("What you want change? \n 1: ID \n 2: Name \n 3: Last name \n 4: Category \n 5: Profession");
        Scanner sc1 = new Scanner(System.in);
        int number1 = 0;
        boolean boo1 = true;
        while (boo1) {
            number1 = sc1.nextInt();
            if (number1 < 0 || number1 > 5) {
                System.err.println("Enter correct number");
            } else {
                boo1 = false;
            }
        }
        switch (number1) {
            case 1:
                boolean bool = true;
                String str;
                int in = 0;
                while (bool) {
                    System.out.println("Enter new ID");
                    str = scanner();
                    try {
                        in = Integer.parseInt(str);
                        bool = false;
                    } catch (NumberFormatException ex) {
                        System.err.println(" Enter numbers");
                    }
                }
                d.setId(in);
                System.out.println(staffDoctor.get(e7));
                break;
            case 2:
                boolean bool1 = true;
                String str5 = null;
                while (bool1) {
                    System.out.println("Enter new Name");
                    str5 = scanner();
                    try {
                        Integer.parseInt(str5);
                        System.err.println("Enter Line");
                        bool1 = true;
                    } catch (NumberFormatException ex3) {
                        bool1 = false;


                    }

                }
                d.setName(str5);
                System.out.println(staffDoctor.get(e7));
                break;
            case 3:
                boolean bool2 = true;
                String str1 = null;
                while (bool2) {
                    System.out.println("Enter new Last name");
                    str1 = scanner();
                    try {
                        Integer.parseInt(str1);
                        System.err.println("Enter Line");
                        bool2 = true;
                    } catch (NumberFormatException ex3) {
                        bool2 = false;


                    }

                }
                d.setLastName(str1);
                System.out.println(staffDoctor.get(e7));
                break;
            case 4:
                boolean bool3 = true;
                String str2;
                int ini = 0;
                while (bool3) {
                    System.out.println("Enter new Category");
                    str2 = scanner();
                    try {
                        ini = Integer.parseInt(str2);
                        bool3 = false;
                    } catch (NumberFormatException ex) {
                        System.err.println(" Enter numbers");
                    }
                }
                d.setCategory(ini);
                System.out.println(staffDoctor.get(e7));
                break;
            case 5:
                    System.out.println("Enter new Profession \n PEDIATRICIAN \n OTOLARYNGOLOG \n ALLERGIC \n SURGEON \n ORTOPED \n ORTODONT");
                    Scanner sc6 = new Scanner(System.in);
                    String str3 = sc6.nextLine();
                    StaffDoctor.Doctor doctor1 = StaffDoctor.Doctor.valueOf(str3);
                    d.setDoctor(doctor1);
                    System.out.println(staffDoctor.get(e7));
                    break;
                    default:
                }
        }




    private void deleteElement(){

            if (staffDoctor.size() == 0) {
                System.err.println("Collection is Null / Enter Doctor");
               return;
            }
            else {

            }
            System.out.println("Delete element at index");
        System.out.println("Enter index between 0 and "+ (staffDoctor.size()-1));
        Scanner s5=new Scanner(System.in);
        boolean b=true;
        int e5=0;
        while (b) {
            e5 = s5.nextInt();
            if (e5 < 0) {
                try {
                    throw new ProgramExeption("Enter corrected index");
                } catch (ProgramExeption programExeption) {
                    programExeption.printStackTrace();
                }
            }
            if (staffDoctor.size() < e5 + 1) {
                try {
                    throw new ProgramExeption("Enter an index between 0 and " + (staffDoctor.size() - 1));
                } catch (ProgramExeption programExeption) {
                    programExeption.printStackTrace();
                }

            } else {
                b = false;
            }
        }
        staffDoctor.remove(e5);
        System.out.println("Element delited \n ");

    }



    private void printAll(){

        for ( StaffDoctor doctor: staffDoctor) {
            System.out.println(doctor);

        }

    }

    private void exitProgram(){
        flag = false;
    }

   private String scanner(){
        Scanner cs=new Scanner(System.in);
        String re=cs.nextLine();
        return re;
   }

}
