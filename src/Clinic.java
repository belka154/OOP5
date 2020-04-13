import java.util.Objects;

public abstract class Clinic {
    private String clinicName;
    private String address;
    private String phoneNumber;
    private boolean hasFreeService;
    private boolean hasPaidService;
    private String hours;
    private int floors;



    public Clinic(String clinicName, String address, String phoneNumber, boolean hasFreeService, boolean hasPaidService) {
        this.clinicName = clinicName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.hasFreeService = hasFreeService;
        this.hasPaidService = hasPaidService;

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
                ", ";
    }
}

