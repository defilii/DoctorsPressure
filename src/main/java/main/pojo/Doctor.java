package main.pojo;

import java.util.HashSet;
import java.util.Set;

public class Doctor {

    private String doctorName;
    private Set<Patient> patients;

    public Doctor(String doctorName, Set<Patient> patients) {
        this.doctorName = doctorName;
        this.patients = new HashSet<Patient>();
    }

    private String getDoctorName() {
        return doctorName;
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    @Override
    public String toString() {
        return "Doctor: " + doctorName + '\n' + patients;
    }
}
