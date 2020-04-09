import java.util.Objects;

public class ChildrenClinic extends Clinic {

    private String numberCallHomeDoctor;

    public ChildrenClinic(String clinicName, String address, String phoneNumber, boolean hasFreeService, boolean hasPaidService, String numberCallHomeDoctor, StaffDoctor staffDoctor) {
        super(clinicName, address, phoneNumber, hasFreeService, hasPaidService, staffDoctor);
        this.numberCallHomeDoctor = numberCallHomeDoctor;
    }

    public String getNumberCallHomeDoctor() {
        return numberCallHomeDoctor;
    }

    public ChildrenClinic setNumberCallHomeDoctor(String numberCallHomeDoctor) {
        this.numberCallHomeDoctor = numberCallHomeDoctor;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ChildrenClinic that = (ChildrenClinic) o;
        return Objects.equals(numberCallHomeDoctor, that.numberCallHomeDoctor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberCallHomeDoctor);
    }

    @Override
    public String toString(){
        return "ChildrenClinic{"+
                "numberCallHomeDoctor = "+ numberCallHomeDoctor + "," +
                super.toString()+"}";
   }


}