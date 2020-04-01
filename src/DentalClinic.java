public class DentalClinic extends Clinic {

    private String email;

    public DentalClinic(String clinicName, String address, String phoneNumber, boolean hasFreeService, boolean hasPaidService, String email, StaffDoctor staffDoctor) {
        super(clinicName, address, phoneNumber, hasFreeService, hasPaidService, staffDoctor);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public DentalClinic setEmail(String email) {
        this.email = email;
        return this;
    }

    protected String electronicRecord(){
        return "you can make an appointment with the doctor by email " + email;
    }

    @Override
    public String toString(){
        return "DentalClinic{"+
                "email = "+ email + "," +
                super.toString()+"}";
    }

}
