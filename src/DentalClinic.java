public class DentalClinic extends Clinic {

    private String email;

    public DentalClinic(String clinicName, String address, String phoneNumber, boolean hasFreeService, boolean hasPaidService, int numberOfStaff, String email) {
        super(clinicName, address, phoneNumber, hasFreeService, hasPaidService, numberOfStaff);
        this.email = email;
    }

    public DentalClinic() {
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
        return "Dental clinic"+super.toString()+
                "email = "+ email +
                "}";
    }
    @Override
    public String formatFile(){
        return "d " + super.formatFile()+ "email "+ email+ ";\n";
    }
}
