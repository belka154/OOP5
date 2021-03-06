import java.io.IOException;
import java.util.Arrays;

public class MyClinic {


    public static void main(String[] args) {
        StaffDoctor staff = new StaffDoctor(254, "Petr", "Frolov", 1, StaffDoctor.Doctor.PEDIATRICIAN);
        StaffDoctor staff1 = new StaffDoctor(145,"Ivan", "Ivanov", 2, StaffDoctor.Doctor.ORTODONT );
        StaffDoctor staff2 = new StaffDoctor(589,"Igor", "Petrov", 3, StaffDoctor.Doctor.ALLERGIC );
        StaffDoctor staff3 = new StaffDoctor(389,"Ivan", "Zyev", 2, StaffDoctor.Doctor.ORTOPED );
        StaffDoctor staff4 = new StaffDoctor(789,"Andrey", "Ivanov", 1, StaffDoctor.Doctor.OTOLARYNGOLOG );
        StaffDoctor staff5 = new StaffDoctor(146,"Osip", "Kib", 3, StaffDoctor.Doctor.SURGEON);


        Clinic c3 = new ChildrenClinic("Clinic№7", "Sovetskaia 96", "35 - 96 - 87", true, true, 5, "39 - 89 - 99");
        Clinic c2 = new ChildrenClinic("Clinic№8", "Lenina 3", "35 - 96 -59", true, true, 6,"39 - 89 - 12");
        Clinic c1 = new ChildrenClinic("Clinic№7", "Sovetskaia 96", "35 - 96 - 87", true, true, 7,"39 - 89 - 99");
        Clinic c4 = new ChildrenClinic("Clinic№2", "Kirova 5", "78 - 56 - 56", false, true, 10, "39 - 89 - 78");
         c1=c3;


        Clinic d1 = new DentalClinic("Dental Family", "Irininskaia 7", "59 - 19 - 18", false, true, 5, "Belka154@mail.ru");
        Clinic d2 = new DentalClinic("Dental Children", "Mazurova 11", "78 - 89 - 22", false, true, 7,"NashaDental4@mail.ru");



        try {
            Program program = new Program();
            program.process();
        }
            catch (IOException e){
        }
    }
}

