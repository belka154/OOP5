import java.io.Serializable;
import java.util.Objects;

public class Clinic implements Serializable, Comparable<Clinic> {
    private String clinicName;
    private String address;
    private String phoneNumber;
    private boolean hasFreeService;
    private boolean hasPaidService;
    private int numberOfStaff;
    private String hours;
    private int floors;


    public Clinic(String clinicName, String address, String phoneNumber, boolean hasFreeService, boolean hasPaidService, int numberOfStaff) {
        this.clinicName = clinicName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.hasFreeService = hasFreeService;
        this.hasPaidService = hasPaidService;
        this.numberOfStaff = numberOfStaff;
    }

    public Clinic() {
    }

    public String getClinicName() {
        return clinicName;
    }

    public Clinic setClinicName(String clinicName) {
        this.clinicName = clinicName;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Clinic setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Clinic setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public boolean isHasFreeService() {
        return hasFreeService;
    }

    public Clinic setHasFreeService(boolean hasFreeService) {
        this.hasFreeService = hasFreeService;
        return this;
    }

    public boolean isHasPaidService() {
        return hasPaidService;
    }

    public Clinic setHasPaidService(boolean hasPaidService) {
        this.hasPaidService = hasPaidService;
        return this;
    }

    public int getNumberOfStaff() {
        return numberOfStaff;
    }

    public Clinic setNumberOfStaff(int numberOfStaff) {
        this.numberOfStaff = numberOfStaff;
        return this;
    }

    public String getHours() {
        return hours;
    }

    public Clinic setHours(String hours) {
        this.hours = hours;
        return this;
    }

    public int getFloors() {
        return floors;
    }

    public Clinic setFloors(int floors) {
        this.floors = floors;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clinic clinic = (Clinic) o;
        return hasFreeService == clinic.hasFreeService &&
                hasPaidService == clinic.hasPaidService &&
                floors == clinic.floors &&
                clinicName.equals(clinic.clinicName) &&
                address.equals(clinic.address) &&
                phoneNumber.equals(clinic.phoneNumber) &&
                hours.equals(clinic.hours);
    }

    protected int areaCalculation(int x, int y) {
        return x * y;
    }

    protected String myWorkHours() {
        return "Clinic worjk " + hours + " hours";
    }


    @Override
    public int hashCode() {
        return Objects.hash(clinicName, address, phoneNumber, hasFreeService, hasPaidService, hours, floors);
    }

    @Override
    public String toString() {
        return "{" +
                "clinicName='" + clinicName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", hasFreeService=" + hasFreeService +
                ", hasPaidService=" + hasPaidService +
                ", numberOfStaff=" + numberOfStaff +
                ", ";
    }

    public String formatFile() {
        return "clinicName " + clinicName + "\n " +
                "address " + address + "\n " +
                "phoneNumber " + phoneNumber + "\n " +
                "hasFreeService " + hasFreeService + "\n " +
                "hasPaidService " + hasPaidService + "\n " +
                "numberOfStaff " + numberOfStaff + "\n ";
    }

    @Override
    public int compareTo(Clinic o) {
        if (this.numberOfStaff == o.numberOfStaff) {
            return 0;
        } else if (this.numberOfStaff < o.numberOfStaff) {
            return -1;

        } else {
            return 1;
        }

        }
    }


