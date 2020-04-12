import java.util.Arrays;

public class MyClinic {
    @Override
    public String toString() {
        return "MyClinic{}";
    }

    public static void main(String[] args) {
        StaffDoctor staff = new StaffDoctor(254, "Petr", "Frolov", 1, StaffDoctor.Doctor.PEDIATRICIAN);
        StaffDoctor staff1 = new StaffDoctor(145, "Ivan", "Ivanov", 2, StaffDoctor.Doctor.ORTODONT);
        StaffDoctor staff2 = new StaffDoctor(589, "Igor", "Petrov", 3, StaffDoctor.Doctor.ALLERGIC);
        StaffDoctor staff3 = new StaffDoctor(389, "Ivan", "Zyev", 2, StaffDoctor.Doctor.ORTOPED);
        StaffDoctor staff4 = new StaffDoctor(789, "Andrey", "Ivanov", 1, StaffDoctor.Doctor.OTOLARYNGOLOG);
        StaffDoctor staff5 = new StaffDoctor(146, "Osip", "Kib", 3, StaffDoctor.Doctor.SURGEON);


        Clinic c3 = new ChildrenClinic("Clinic№7", "Sovetskaia 96", "35 - 96 - 87", true, true, "39 - 89 - 99", staff);
        Clinic c2 = new ChildrenClinic("Clinic№8", "Lenina 3", "35 - 96 -59", true, true, "39 - 89 - 12", staff2);
        Clinic c1 = new ChildrenClinic("Clinic№7", "Sovetskaia 96", "35 - 96 - 87", true, true, "39 - 89 - 99", staff);
        Clinic c4 = new ChildrenClinic("Clinic№2", "Kirova 5", "78 - 56 - 56", false, true, "39 - 89 - 78", staff4);
        //c1=c3;


        Clinic d1 = new DentalClinic("Dental Family", "Irininskaia 7", "59 - 19 - 18", false, true, "Belka154@mail.ru", staff1);
        Clinic d2 = new DentalClinic("Dental Children", "Mazurova 11", "78 - 89 - 22", false, true, "NashaDental4@mail.ru", staff5);


        c1.areaCalculation(5647, 9785);
        c4.areaCalculation(1254, 2554);
        d1.areaCalculation(1258, 5456);


        c1.setFloors(32);
        c2.setFloors(45);
        c4.setFloors(36);

        d1.setFloors(25);
        d2.setFloors(35);

        staff.setLastName("Begemotov");

        c4.setHours("12");
        c4.myWorkHours();

        d1.setHours("24");
        d1.myWorkHours();


        Program program = new Program();


        program.getStaffDoctor().add(staff);
        program.getStaffDoctor().add(staff1);
        program.getStaffDoctor().add(staff2);
        program.getStaffDoctor().add(staff3);
        program.getStaffDoctor().add(staff4);
        program.getStaffDoctor().add(staff5);


        program.process();


    }
}
