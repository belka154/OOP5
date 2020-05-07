import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


public class FileGenericContainer extends GenericContainer<Clinic> {

    int count = 0;

    public void write(String a) throws Exception {

        File file = new File(a);
        BufferedWriter fileOutputStream = new BufferedWriter(new FileWriter(file));
        FileWriter fileWriter = new FileWriter(file);

        for (int i = 0; i < getSize(); i++) {
            if (get(i) != null) {
                count++;
            }
        }

        fileOutputStream.write(count + ";" + "\n");
        for (int i = 0; i < getSize(); i++) {
            if (get(i) != null) {
                String str = get(i).formatFile();
                fileOutputStream.write(str);
            }
        }
        fileWriter.close();
        fileOutputStream.close();


    }


    public void read(String a) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(a));

        String e;
        StringBuilder stringBuilder = new StringBuilder();

        while ((e = bufferedReader.readLine()) != null) {
            stringBuilder.append(e);
        }
        String s = stringBuilder.toString();
        parse(s);
        bufferedReader.close();
    }


    public void parse(String a) {

        String arrayy[] = a.split(";");
        Boolean b = false;
        for (int i = 0; i < arrayy.length; i++) {
            String r = arrayy[i];
            String array1[] = r.split(" ");

            if ("c".equals(array1[0])) {
                ChildrenClinic clinic = new ChildrenClinic();
                setter(array1, clinic);
                clinic.setNumberCallHomeDoctor(array1[14]);
                    add(clinic);


            } else if ("d".equals(array1[0])){
                DentalClinic clinic1 = new DentalClinic();
                    setter(array1, clinic1);
                    clinic1.setEmail(array1[14]);
                    add(clinic1);

                }


            }

        }

    private void setter(String[] array1, Clinic clinic) {
        boolean b;
        clinic.setClinicName(array1[2]);
        clinic.setAddress(array1[4]);
        clinic.setPhoneNumber(array1[6]);
        if ("yes".equals(array1[8])) {
            b = true;
            clinic.setHasFreeService(b);
        }
        if ("yes".equals(array1[10])) {
            b = true;
            clinic.setHasPaidService(b);
        }
        clinic.setNumberOfStaff(Integer.parseInt(array1[12]));
    }
}







