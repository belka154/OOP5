import java.io.Serializable;
import java.util.Objects;

public class ChildrenClinic extends Clinic implements Serializable {

    private String numberCallHomeDoctor;

    public ChildrenClinic(String clinicName, String address, String phoneNumber, boolean hasFreeService, boolean hasPaidService, int numberOfStaff, String numberCallHomeDoctor) {
        super(clinicName, address, phoneNumber, hasFreeService, hasPaidService, numberOfStaff);
        this.numberCallHomeDoctor = numberCallHomeDoctor;
    }

    public ChildrenClinic() {
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
    public String toString() {
        return "Children clinic" + super.toString()+
                "numberCallHomeDoctor=" + numberCallHomeDoctor + "}";

    }
    @Override
    public String formatFile(){
        return "c " + super.formatFile()+ "numberCallHomeDoctor " + numberCallHomeDoctor + ";\n";
    }
}
