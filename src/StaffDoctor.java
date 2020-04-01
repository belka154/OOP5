import java.util.Objects;

public class StaffDoctor {
    private int id;
    private String name;
    private String lastName;
    private int category;
    private Doctor doctor;

    public StaffDoctor(int id, String name, String lastName, int category, Doctor doctor) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.category = category;
        this.doctor = doctor;
    }

    public int getId() {
        return id;
    }

    public StaffDoctor setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public StaffDoctor setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public StaffDoctor setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public int getCategory() {
        return category;
    }

    public StaffDoctor setCategory(int category) {
        this.category = category;
        return this;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public StaffDoctor setDoctor(Doctor doctor) {
        this.doctor = doctor;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffDoctor that = (StaffDoctor) o;
        return id == that.id &&
                category == that.category &&
                Objects.equals(name, that.name) &&
                Objects.equals(lastName, that.lastName) &&
                doctor.name().equals(that.doctor.name());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, category, doctor.name());
    }

    @Override
    public String toString() {
        return "StaffDoctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", category=" + category +
                ", doctor=" + doctor +
                '}';
    }

    public enum Doctor {

        PEDIATRICIAN("111"),
        OTOLARYNGOLOG("222"),
        ALLERGIC("333"),
        SURGEON("444"),
        ORTOPED("555"),
        ORTODONT("666");

        Doctor(String code) {

        }



    }
}
